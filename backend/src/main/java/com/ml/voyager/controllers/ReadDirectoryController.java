package com.ml.voyager.controllers;

import com.ml.voyager.dtos.request.ReadDirectoryContentDto;
import com.ml.voyager.dtos.response.DirectoryContentsDto;
import com.ml.voyager.services.read.ReadDirectoryOrchestrationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/voyager/rest/api/v1/directory/read")
@RequiredArgsConstructor
public class ReadDirectoryController {

    private final ReadDirectoryOrchestrationService directoryService;
    private static final Logger logger = LoggerFactory.getLogger(ReadDirectoryController.class);

    @GetMapping(path = "/all-paths", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DirectoryContentsDto>> getAllPaths() {
        List<DirectoryContentsDto> paths = directoryService.getAllPaths();
        if (paths.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(paths);
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<DirectoryContentsDto>> getDirectoryInfo(@RequestBody ReadDirectoryContentDto directoryContents) {
        return directoryService.readDirectory(directoryContents)
                .next()
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build())
                .doOnSuccess(result -> logger.info("Controller: Directory contents collected"))
                .doOnError(error -> logger.error("Controller: Error processing request", error));
    }
}
