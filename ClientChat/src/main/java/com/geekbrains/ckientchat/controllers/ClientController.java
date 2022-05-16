package com.geekbrains.ckientchat.controllers;

import com.geekbrains.ckientchat.ClientChat;
import com.geekbrains.ckientchat.Network;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.function.Consumer;

public class ClientController {

    @FXML
    public TextField messageTextArea;

    @FXML
    public Button sendMessageButton;

    @FXML
    public TextArea chatTextArea;

    @FXML
    public ListView userList;

    private ClientChat application;

    public void sendMessage() {
        String message = messageTextArea.getText();
        if (message.isEmpty()) {
            messageTextArea.clear();
            return;
        }
        String sender = null;
        if (!userList.getSelectionModel().isEmpty()) {
            sender = userList.getSelectionModel().getSelectedItems().toString();
        }
        try {
            message = sender != null ? String.format(": ", sender, message) : message;
            Network.getInstance().sendMessage(message);
        } catch (IOException e) {
            application.showErrorDialog("Ошибка передачи данных по сети.");
        }
        appendMessageToChat("Я: ",message);
    }

    public void appendMessageToChat(String sender, String message) {
        chatTextArea.appendText(DateFormat.getInstance().format(new Date()));
        chatTextArea.appendText(System.lineSeparator());
        if (sender != null) {
            chatTextArea.appendText(sender + ": ");
            chatTextArea.appendText(System.lineSeparator());
        }
        chatTextArea.appendText(message);
        chatTextArea.appendText(System.lineSeparator());
        chatTextArea.appendText(System.lineSeparator());
        messageTextArea.requestFocus();
        messageTextArea.clear();
    }

    private void requestFocus() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                messageTextArea.requestFocus();
            }
        });
    }

    public ClientChat getApplication() {
        return application;
    }

    public void setApplication(ClientChat application) {
        this.application = application;
    }

    public void initializeMessageHandler() {
        Network.getInstance().waitMessages(new Consumer<String>() {
            @Override
            public void accept(String message) {
                appendMessageToChat("Server: ", message);
            }
        });
    }
}