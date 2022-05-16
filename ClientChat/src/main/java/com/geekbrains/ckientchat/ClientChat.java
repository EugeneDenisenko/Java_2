package com.geekbrains.ckientchat;

import com.geekbrains.ckientchat.controllers.AuthController;
import com.geekbrains.ckientchat.controllers.ClientController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class ClientChat extends Application {

    private Stage stage;
    private Stage authStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.stage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(ClientChat.class.getResource("chat-template.fxml"));

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        this.stage.setTitle("Student project");
        this.stage.setScene(scene);

        ClientController controller = fxmlLoader.getController();
        controller.userList.getItems().addAll("user1", "user2");

        primaryStage.show();
        connectToServer(controller);

        FXMLLoader authlLoader = new FXMLLoader();
        authlLoader.setLocation(ClientChat.class.getResource("authDialog.fxml"));
        AnchorPane authDialogPanel = authlLoader.load();
        authStage = new Stage();
        authStage.initOwner(primaryStage);
        authStage.initModality(Modality.WINDOW_MODAL);
        authStage.setScene(new Scene(authDialogPanel));

        AuthController authController = authlLoader.getController();
        authController.setClientChat(this);
        authController.initialezeMessageHandler();
        authStage.showAndWait();
        controller.initializeMessageHandler();

    }

    private void connectToServer(ClientController clientController) {
        boolean resultConnectedToServer = Network.getInstance().connect();
        if (!resultConnectedToServer) {
            String errorMessage = "Невозможно установить сетевое соединение.";
            System.err.println(errorMessage);
            showErrorDialog(errorMessage);
        }

        clientController.setApplication(this);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Network.getInstance().close();
            }
        });
    }

    public void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }

    public Stage getAuthStage() {
        return authStage;
    }
}