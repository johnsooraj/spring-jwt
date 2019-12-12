package com.sample.constants;

public enum UserStatus {

    ACTIVE((byte) 1),
    DELETED((byte) 2),
    BLOCKED((byte) 3);

    public byte userStatus;

    private UserStatus(byte status) {
        this.userStatus = status;
    }
}
