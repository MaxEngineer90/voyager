package com.ml.voyager.component;

import com.ml.voyager.models.DirectoryContent;
import com.ml.voyager.services.read.ReadRootService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CacheInitializer {

    private final ReadRootService readRootService;

    private final CacheManager cacheManager;

    @PostConstruct
    public void init() {
        List<DirectoryContent> details = readRootService.getDetails();
        Cache cache = cacheManager.getCache("directoryContents");
        if (!details.isEmpty()) {
            cache.put("initial", details);
        }
    }
}
