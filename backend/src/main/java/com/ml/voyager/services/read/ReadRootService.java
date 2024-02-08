package com.ml.voyager.services.read;

import com.ml.voyager.VoyagerApplication;
import com.ml.voyager.mappers.DirectoryContentsMapper;
import com.ml.voyager.models.DirectoryContent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class ReadRootService {
    private final Logger logger = Logger.getLogger(VoyagerApplication.class.getName());

    private final DirectoryContentsMapper mapper;

    public List<DirectoryContent> getDetails() {
        List<DirectoryContent> contents = Arrays.stream(File.listRoots()).map(mapper::fileToDirectoryContents).toList();

        if (contents.isEmpty()) {
            logger.warning("Can`t find any root");
            return Collections.emptyList();
        }

        return contents;
    }
}
