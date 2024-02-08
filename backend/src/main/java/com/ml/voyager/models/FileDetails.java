package com.ml.voyager.models;

import lombok.*;

@Builder
@ToString
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
public class FileDetails {

    private String name;
    private boolean isDirectory;
    private long size;
    private String lastModified;

}
