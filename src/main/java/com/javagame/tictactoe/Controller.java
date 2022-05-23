package com.javagame.tictactoe;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {
    Integer countX = 0;
    Integer countO = 0;
    Integer draw = 0;
    Integer numberOfGames;
    boolean isAdvanced;
    GridPane root;
    List<HashSet<Integer>> matchingList = new ArrayList<>();
    Set<Integer> drawX = new HashSet<>();
    Set<Integer> drawO = new HashSet<>();
    Stage appPrimaryStage;

    public Controller(GridPane root) {
        this.root = root;
        HashSet<Integer> hashSet = new HashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        matchingList.add(hashSet);
        HashSet<Integer> hashSet1 = new HashSet();
        hashSet1.add(4);
        hashSet1.add(5);
        hashSet1.add(6);
        matchingList.add(hashSet1);
        HashSet<Integer> hashSet2 = new HashSet();
        hashSet2.add(7);
        hashSet2.add(8);
        hashSet2.add(9);
        matchingList.add(hashSet2);
        HashSet<Integer> hashSet3 = new HashSet();
        hashSet3.add(1);
        hashSet3.add(4);
        hashSet3.add(7);
        matchingList.add(hashSet3);
        HashSet<Integer> hashSet4 = new HashSet();
        hashSet4.add(2);
        hashSet4.add(5);
        hashSet4.add(8);
        matchingList.add(hashSet4);
        HashSet<Integer> hashSet5 = new HashSet();
        hashSet5.add(3);
        hashSet5.add(6);
        hashSet5.add(9);
        matchingList.add(hashSet5);
        HashSet<Integer> hashSet6 = new HashSet();
        hashSet6.add(3);
        hashSet6.add(5);
        hashSet6.add(7);
        matchingList.add(hashSet6);
        HashSet<Integer> hashSet7 = new HashSet();
        hashSet7.add(1);
        hashSet7.add(5);
        hashSet7.add(9);
        matchingList.add(hashSet7);
    }

    public void computerMove() {
        List<Tile> tiles = root.getChildren().stream()
                .filter(node -> node instanceof Tile)
                .map(node -> ((Tile) node))
                .filter(tile -> tile.text.getText().equals(""))
                .collect(Collectors.toList());
        Random randomGenerator = new Random();
        int computerTileIndex = randomGenerator.nextInt(tiles.size());
        Tile tile = tiles.get(computerTileIndex);
        tile.text.setText("O");
        drawO.add(tile.idNumber);
        verifyResult(drawO);
    }

    public void computerMoveAdvanced() {
        List<Tile> tiles = root.getChildren().stream()
                .filter(node -> node instanceof Tile)
                .map(node -> ((Tile) node))
                .filter(tile -> tile.text.getText().equals(""))
                .collect(Collectors.toList());

        HashSet<Integer> integers = new HashSet<>();
        integers.addAll(drawO);
        integers.addAll(drawX);
        List<HashSet<Integer>> collect = matchingList.stream()
                .filter(s -> !integers.containsAll(s))
                .collect(Collectors.toList());
        Optional<HashSet<Integer>> first = collect.stream()
                .filter(combination -> combination.containsAll(drawX))
                .findFirst();
        if (first.isPresent()) {
            Optional<Integer> tileToSet = first.get().stream()
                    .filter(tileNo -> !drawX.contains(tileNo) && !drawO.contains(tileNo))
                    .findFirst();
            Tile tile = tiles.stream()
                    .filter(tile1 -> tile1.idNumber == tileToSet.get())
                    .findFirst().get();
            tile.text.setText("O");
            drawO.add(tile.idNumber);
        } else {
            HashSet<Integer> combination = new HashSet<>();
            for (HashSet<Integer> win : collect) {
                int count = 0;
                for (Integer mark : drawX) {
                    if (win.contains(mark)) {
                        count++;
                    }
                    if (count == 2) {
                        combination = win;
                    }
                }
                if (!combination.isEmpty()) {
                    Integer missing = combination.stream()
                            .filter(x -> !drawX.contains(x))
                            .findFirst().get();

                    Tile tile = root.getChildren().stream()
                            .filter(node -> node instanceof Tile)
                            .map(node -> ((Tile) node))
                            .filter(t -> t.idNumber == missing)
                            .findFirst().get();
                    tile.text.setText("O");
                    drawO.add(tile.idNumber);
                    verifyResult(drawO);
                    break;
                }
            }
            if (combination.isEmpty()) {
                List<Tile> tiles2 = root.getChildren().stream()
                        .filter(node -> node instanceof Tile)
                        .map(node -> ((Tile) node))
                        .filter(tile -> tile.text.getText().equals(""))
                        .collect(Collectors.toList());
                Random randomGenerator = new Random();
                int computerTileIndexAdvanced = randomGenerator.nextInt(tiles2.size());
                Tile tile = tiles2.get(computerTileIndexAdvanced);
                tile.text.setText("O");
                drawO.add(tile.idNumber);
                verifyResult(drawO);
            }
        }
    }

    public boolean ifFieldWasUsedBefore(Tile tile) {
        boolean result = drawO.contains(tile.idNumber) || drawX.contains(tile.idNumber);
        return result;
    }

    public void runAGame(Tile tile) {
        if (!ifFieldWasUsedBefore(tile)) {
            tile.text.setText("X");
            drawX.add(tile.idNumber);
            verifyResult(drawX);
        }
    }

    public boolean isDraw() {
        if ((drawO.size() == 5 && drawX.size() == 4) || (drawO.size() == 4 && drawX.size() == 5)) {
            return true;
        }
        return false;
    }

    public void verifyResult(Set<Integer> hashSet) {
        if (winningCombinationX() || winningCombinationO() || isDraw()) {
            endOfRound();
        }
    }

    public boolean winningCombinationO() {
        return matchingList.stream()
                .anyMatch(combination -> drawO.containsAll(combination));
    }

    public boolean winningCombinationX() {
        return matchingList.stream()
                .anyMatch(combination -> drawX.containsAll(combination));
    }

    public void endOfRound() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("End of Round");
        alert.setHeaderText("Enjoy Tic Tac Toe !!!");

        String message = "";

        if (winningCombinationX()) {
            countX++;
            message = "X won this round. Total win for X is: " + countX;
        } else if (winningCombinationO()) {
            countO++;
            message = "O won this round. Total win for O is: " + countO;
        } else {
            draw++;
            message = "Draw. Total draw in this game is: " + draw;
        }
        alert.setContentText(message);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            this.drawX = new HashSet<>();
            this.drawO = new HashSet<>();
            for (int i = 0; i < root.getChildren().size(); i++) {
                ((Tile) root.getChildren().get(i)).text.setText("");
            }
        } else {
            appPrimaryStage.close();
        }
        if (numberOfGames <= (countX + countO + draw)) {
            endOfGame();
        }
    }

    public void endOfGame() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("End of Game");
        String message = "";
        alert.setHeaderText("Thank you for playing Tic Tac Toe !!!");
        if (countX > countO) {
            message = "Won X, Would you like to play again?";
        } else if (countO > countX) {
            message = "Won O, Would you like to play again?";
        } else {
            message = "Draw. Would you like to play again?";
        }
        alert.setContentText(message);
        Optional<ButtonType> result = alert.showAndWait();
        countX = 0;
        countO = 0;
        draw = 0;
        if (result.get() == ButtonType.OK) {
            this.drawX = new HashSet<>();
            this.drawO = new HashSet<>();
            for (int i = 0; i < root.getChildren().size(); i++) {
                ((Tile) root.getChildren().get(i)).text.setText("");
            }
            appPrimaryStage.setScene(TicTacToeApplication.createAppScene(appPrimaryStage));
        } else {
            appPrimaryStage.close();
        }
    }
}