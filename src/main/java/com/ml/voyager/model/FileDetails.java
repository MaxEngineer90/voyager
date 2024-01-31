package com.ml.voyager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.nio.file.attribute.FileTime;

@Getter
@Setter
@ToString
public class FileDetails {

    private String name;
    private boolean isDirectory;
    private long size;
    private String lastModified;

}
