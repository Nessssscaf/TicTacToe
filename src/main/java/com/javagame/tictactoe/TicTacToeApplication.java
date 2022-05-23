package com.javagame.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    static GridPane root;
    static Controller controller;

    public static Parent createContent() {
        root = new GridPane();
        controller = new Controller(root);
        root.setPrefSize(608, 608);

        int tileCounter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile(controller);
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);
                tileCounter++;
                tile.idNumber = tileCounter;
                root.getChildren().add(tile);
            }
        }
        return root;
    }

    public static Scene createAppScene(Stage primaryStage) {
        Scene appScene = new Scene(createContent());
        Scene sceneWithButton;
        FlowPane flowpane = new FlowPane();
        Button button1;
        Button button2;
        TextField nameInput = new TextField();

        Label sign = new Label("How many games you want to play?");

        button1 = new Button("Basic level");
        button1.setBackground(Background.fill(Color.LIGHTGREEN));

        button2 = new Button("Advanced level");
        button2.setBackground(Background.fill(Color.RED));

        flowpane.getChildren().add(button1);
        flowpane.getChildren().add(button2);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(50, 50, 50, 50));
        layout.getChildren().addAll(sign, nameInput, flowpane);
        sceneWithButton = new Scene(layout, 600, 600);
        button1.setOnMouseClicked(e -> {
            controller.numberOfGames = Integer.valueOf(nameInput.getText());
            System.out.println(nameInput.getText());
            primaryStage.close();
            primaryStage.setScene(appScene);
            primaryStage.show();
            controller.isAdvanced = false;
        });
        button2.setOnMouseClicked(e -> {
            controller.numberOfGames = Integer.valueOf(nameInput.getText());
            System.out.println(nameInput.getText());
            primaryStage.close();
            primaryStage.setScene(appScene);
            primaryStage.show();
            controller.isAdvanced = true;
        });
        return sceneWithButton;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setScene(createAppScene(primaryStage));
        primaryStage.setTitle("Tic Tac Toe");
        controller.appPrimaryStage = primaryStage;
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}