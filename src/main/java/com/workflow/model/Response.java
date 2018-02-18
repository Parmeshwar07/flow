package com.workflow.model;

public class Response<T> {
    private String description;
    private int code;
    private T result;

    public Response(String description, int code, T result) {
        this.description = description;
        this.code = code;
        this.result = result;
    }

    public Response() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
