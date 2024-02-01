package com.ml.voyager.dtos.response;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
public record FileDetailsDto(
        String name,
        boolean isDirectory,
        long size,
        String lastModified
) {
}
