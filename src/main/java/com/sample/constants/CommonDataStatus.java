package com.sample.constants;

public enum CommonDataStatus {

    ACTIVE((byte) 1);

    public byte statusCode;

    private CommonDataStatus(byte code) {
        this.statusCode = code;
    }
}
