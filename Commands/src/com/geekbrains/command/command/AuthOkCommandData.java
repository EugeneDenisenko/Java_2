package com.geekbrains.command.command;

import java.io.Serializable;

public class AuthOkCommandData implements Serializable {
    private final String userName;

    public AuthOkCommandData(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
