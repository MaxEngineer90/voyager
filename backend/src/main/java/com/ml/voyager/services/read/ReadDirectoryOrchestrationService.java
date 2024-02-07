package com.ml.voyager.services.read;

import com.ml.voyager.dtos.request.ReadDirectoryContentDto;
import com.ml.voyager.dtos.response.DirectoryContentsDto;
import com.ml.voyager.mappers.DirectoryContentsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ReadDirectoryOrchestrationService {

    private final ReadDirectoryService directoryService;
    private final DirectoryContentsMapper dirContentMapper;

    public Flux<DirectoryContentsDto> readDirectory(ReadDirectoryContentDto readDirectoryContentDto) {
        String path = readDirectoryContentDto.path();
        return directoryService.readDirectory(path)
                .map(dirContentMapper::toDto);
    }
}