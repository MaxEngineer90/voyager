package com.ml.voyager.services.read;

import com.ml.voyager.dtos.request.ReadDirectoryContentDto;
import com.ml.voyager.dtos.response.DirectoryContentsDto;
import com.ml.voyager.mappers.DirectoryContentsMapper;
import com.ml.voyager.models.DirectoryContent;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadDirectoryOrchestrationService {

    private final ReadDirectoryService directoryService;
    private final DirectoryContentsMapper dirContentMapper;
    private final CacheManager cacheManager;

    public List<DirectoryContentsDto> getAllPaths() {
        Cache cache = cacheManager.getCache("directoryContents");
        if (cache != null) {
            @SuppressWarnings("unchecked")
            List<DirectoryContent> cachedContent = cache.get("initial", List.class);
            if (cachedContent != null) {
                return cachedContent.stream()
                        .map(dirContentMapper::toDto)
                        .toList();
            }
        }
        return Collections.emptyList();
    }

    public Flux<DirectoryContentsDto> readDirectory(ReadDirectoryContentDto readDirectoryContentDto) {
        String path = readDirectoryContentDto.path();
        return directoryService.readDirectory(path)
                .map(dirContentMapper::toDto);
    }

}