package com.ml.voyager.dtos.response;

import com.ml.voyager.models.FileDetails;

import java.util.List;


public record DirectoryContentsDto(String path,
                                   List<FileDetails> files) {

}
