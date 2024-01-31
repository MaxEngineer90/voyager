package com.ml.voyager.controller;

import com.ml.voyager.model.DirectoryContents;
import com.ml.voyager.model.ReadDirectoryContents;
import com.ml.voyager.service.ReadDirectoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/directory/read")
public class ReadDirectoryController {

    private final ReadDirectoryService directoryService;

    @PostMapping
    public ResponseEntity<DirectoryContents> getDirectoryInfo(@RequestBody ReadDirectoryContents directoryContents) throws IOException {
        DirectoryContents contents = directoryService.readDirectory(directoryContents);
        return ResponseEntity.ok(contents);
    }
}
