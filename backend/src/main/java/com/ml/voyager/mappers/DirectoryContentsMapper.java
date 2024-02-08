package com.ml.voyager.mappers;

import com.ml.voyager.dtos.response.DirectoryContentsDto;
import com.ml.voyager.models.DirectoryContent;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.io.File;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DirectoryContentsMapper {
    @IterableMapping(elementTargetType = DirectoryContentsDto.class)
    DirectoryContentsDto toDto(DirectoryContent directoryContent);

    DirectoryContent fileToDirectoryContents(File file);
}
