package com.ml.voyager.services.read;

import com.ml.voyager.exceptions.DirectoryReadException;
import com.ml.voyager.exceptions.FileReadException;
import com.ml.voyager.exceptions.NotADirectoryException;
import com.ml.voyager.models.DirectoryContent;
import com.ml.voyager.models.FileDetails;
import org.apache.commons.io.FileUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

@Service
public class ReadDirectoryService {

    private static final int PARALLELISM = Runtime.getRuntime().availableProcessors();

    @Cacheable("directoryContents")
    public Flux<DirectoryContent> readDirectory(String path) {
        File directory = new File(path);

        if (!directory.isDirectory()) {
            throw new NotADirectoryException("The specified path is not a directory.");
        }


        return Flux.defer(() ->
                Flux.fromStream(() -> {
                            try {
                                return Files.list(directory.toPath());
                            } catch (IOException e) {
                                throw new DirectoryReadException("Error reading the directory.", e);
                            }
                        })
                        .parallel(PARALLELISM)
                        .runOn(Schedulers.parallel())
                        .map(this::createFileDetails)
                        .sequential()
                        .collectList()
                        .map(files -> DirectoryContent.builder()
                                .path(directory.getAbsolutePath())
                                .files(files)
                                .build())
                        .flux()
        );
    }

    private FileDetails createFileDetails(Path path) {
        try {
            File file = path.toFile();
            BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);

            return FileDetails.builder()
                    .name(file.getName())
                    .isDirectory(file.isDirectory())
                    .size(FileUtils.sizeOf(file))
                    .lastModified(attrs.lastModifiedTime().toInstant().toString())
                    .build();
        } catch (IOException e) {
            throw new FileReadException("Error reading file attributes.", e);
        }
    }
}
