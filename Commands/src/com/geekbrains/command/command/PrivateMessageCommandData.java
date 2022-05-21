package com.geekbrains.command.command;

import java.io.Serializable;

public class PrivateMessageCommandData implements Serializable {
    private final String privateMessage;
    private final String receiver;

    public PrivateMessageCommandData(String privateMessage, String receiver) {
        this.privateMessage = privateMessage;
        this.receiver = receiver;
    }

    public String getPrivateMessage() {
        return privateMessage;
    }

    public String getReceiver() {
        return receiver;
    }
}
