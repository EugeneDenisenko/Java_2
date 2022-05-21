package com.geekbrains.command.command;

import java.io.Serializable;

public class PublicMessageCommandData implements Serializable {
    private final String publicMessage;

    public PublicMessageCommandData(String publicMessage) {
        this.publicMessage = publicMessage;
    }

    public String getPublicMessage() {
        return publicMessage;
    }
}
