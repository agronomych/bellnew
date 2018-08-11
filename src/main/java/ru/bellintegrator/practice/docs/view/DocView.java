package ru.bellintegrator.practice.docs.view;

import io.swagger.annotations.ApiModelProperty;

public class DocView {

    @ApiModelProperty(hidden = true)
    public Integer id;

    public String name;

    public int code;

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";code" + code + "}";
    }
}