package com.ml.voyager.mappers;

import com.ml.voyager.dtos.response.DirectoryContentsDto;
import com.ml.voyager.models.DirectoryContents;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DirectoryContentsMapper {
    @IterableMapping(elementTargetType = DirectoryContentsDto.class)
    DirectoryContentsDto toDto(DirectoryContents directoryContents);
}
