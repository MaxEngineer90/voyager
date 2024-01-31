package com.ml.voyager.service;

import com.ml.voyager.model.DirectoryContents;
import com.ml.voyager.model.FileDetails;
import com.ml.voyager.model.ReadDirectoryContents;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Collectors;

@Service
public class ReadDirectoryService {

    public DirectoryContents readDirectory(ReadDirectoryContents readDirectoryContents) throws IOException {
        File directory = new File(readDirectoryContents.getPath());

        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Der angegebene Pfad ist kein Verzeichnis.");
        }

        DirectoryContents contents = new DirectoryContents();
        contents.setFiles(
                Files.list(directory.toPath())
                        .map(path -> {
                            try {
                                File file = path.toFile();
                                BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);

                                FileDetails details = new FileDetails();
                                details.setName(file.getName());
                                details.setDirectory(file.isDirectory());
                                details.setSize(FileUtils.sizeOf(file));
                                details.setLastModified(attrs.lastModifiedTime().toInstant().toString());

                                return details;
                            } catch (IOException e) {
                                throw new RuntimeException("Fehler beim Lesen der Dateiattribute.", e);
                            }
                        })
                        .collect(Collectors.toList())
        );

        return contents;
    }
}
