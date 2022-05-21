package com.geekbrains.ckientchat.model;

import com.geekbrains.command.Command;

public interface ReadMessageListener {
    void processReceivedCommand(Command command);
}
