package com.javagame.tictactoe;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {
    int idNumber;
    Text text = new Text();

    public Tile(Controller controller) {
        Rectangle border = new Rectangle(200, 200);
        border.setFill(null);
        border.setStroke(Color.BURLYWOOD);
        border.setStrokeWidth(8.0);

        setAlignment(Pos.CENTER);
        getChildren().addAll(border, text);
        text.setFont(Font.font(72));
        text.setStroke(Color.BLUEVIOLET);

        setOnMouseClicked(event ->
        {
            Tile source = (Tile) event.getSource();
            controller.runAGame(source);
            if (controller.isAdvanced) {

                controller.computerMoveAdvanced();
            } else {
                controller.computerMove();
            }
        });
    }
}