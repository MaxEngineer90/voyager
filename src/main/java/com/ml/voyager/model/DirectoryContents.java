package com.ml.voyager.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DirectoryContents {
    private String path;
    private List<FileDetails> files;
}
