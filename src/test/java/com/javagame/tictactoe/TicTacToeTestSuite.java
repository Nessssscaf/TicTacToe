package com.javagame.tictactoe;

import org.junit.jupiter.api.*;

public class TicTacToeTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Test of winning O combinations")
    class TestDrawO {

        @Test
        void testWinningCombinationHorizontalFirstLineO() {
            //Given
            Controller controller = new Controller(null);
            controller.drawO.add(1);
            controller.drawO.add(2);
            controller.drawO.add(3);

            //When
            controller.winningCombinationO();

            //Then
            Assertions.assertTrue(controller.winningCombinationO());
        }
        @Test
        void testWinningCombinationHorizontalSecondLineO(){
            //Given
            Controller controller = new Controller(null);
            controller.drawO.add(4);
            controller.drawO.add(5);
            controller.drawO.add(6);

            //When
            controller.winningCombinationO();

            //Then
            Assertions.assertTrue(controller.winningCombinationO());
        }

        @Test
        void testWinningCombinationHorizontalThirdLineO(){
            //Given
            Controller controller = new Controller( null);
            controller.drawO.add(7);
            controller.drawO.add(8);
            controller.drawO.add(9);

            //When
            controller.winningCombinationO();

            //Then
            Assertions.assertTrue(controller.winningCombinationO());
        }

        @Test
        void testWinningCombinationDiagonalLeftLineO(){
            //Given
            Controller controller = new Controller( null);
            controller.drawO.add(1);
            controller.drawO.add(5);
            controller.drawO.add(9);

            //When
            controller.winningCombinationO();

            //Then
            Assertions.assertTrue(controller.winningCombinationO());
        }

        @Test
        void testWinningCombinationDiagonalRightLineO(){
            //Given
            Controller controller = new Controller(null);
            controller.drawO.add(3);
            controller.drawO.add(5);
            controller.drawO.add(7);

            //When
            controller.winningCombinationO();

            //Then
            Assertions.assertTrue(controller.winningCombinationO());
        }

        @Test
        void testWinningCombinationVerticalFirstLineO(){
            //Given
            Controller controller = new Controller(null);
            controller.drawO.add(1);
            controller.drawO.add(4);
            controller.drawO.add(7);

            //When
            controller.winningCombinationO();

            //Then
            Assertions.assertTrue(controller.winningCombinationO());
        }

        @Test
        void testWinningCombinationVerticalSecondLineO(){
            //Given
            Controller controller = new Controller(null);
            controller.drawO.add(2);
            controller.drawO.add(5);
            controller.drawO.add(8);

            //When
            controller.winningCombinationO();

            //Then
            Assertions.assertTrue(controller.winningCombinationO());
        }

        @Test
        void testWinningCombinationVerticalThirdLineO(){
            //Given
            Controller controller = new Controller(null);
            controller.drawO.add(3);
            controller.drawO.add(6);
            controller.drawO.add(9);

            //When
            controller.winningCombinationO();

            //Then
            Assertions.assertTrue(controller.winningCombinationO());
        }
    }

    @Nested
    @DisplayName("Test of winning X combinations")
    class TestDrawX {

        @Test
        void testWinningCombinationHorizontalFirstLineX() {
            //Given
            Controller controller = new Controller(null);
            controller.drawX.add(1);
            controller.drawX.add(2);
            controller.drawX.add(3);

            //When
            controller.winningCombinationX();

            //Then
            Assertions.assertTrue(controller.winningCombinationX());
        }

        @Test
        void testWinningCombinationHorizontalSecondLineX() {
            //Given
            Controller controller = new Controller(null);
            controller.drawX.add(4);
            controller.drawX.add(5);
            controller.drawX.add(6);

            //When
            controller.winningCombinationX();

            //Then
            Assertions.assertTrue(controller.winningCombinationX());
        }

        @Test
        void testWinningCombinationHorizontalThirdLineX() {
            //Given
            Controller controller = new Controller(null);
            controller.drawX.add(7);
            controller.drawX.add(8);
            controller.drawX.add(9);

            //When
            controller.winningCombinationX();

            //Then
            Assertions.assertTrue(controller.winningCombinationX());
        }

        @Test
        void testWinningCombinationDiagonalLeftLineX() {
            //Given
            Controller controller = new Controller(null);
            controller.drawX.add(1);
            controller.drawX.add(5);
            controller.drawX.add(9);

            //When
            controller.winningCombinationX();

            //Then
            Assertions.assertTrue(controller.winningCombinationX());
        }

        @Test
        void testWinningCombinationDiagonalRightLineX() {
            //Given
            Controller controller = new Controller(null);
            controller.drawX.add(3);
            controller.drawX.add(5);
            controller.drawX.add(7);

            //When
            controller.winningCombinationX();

            //Then
            Assertions.assertTrue(controller.winningCombinationX());
        }

        @Test
        void testWinningCombinationVerticalFirstLineX() {
            //Given
            Controller controller = new Controller(null);
            controller.drawX.add(1);
            controller.drawX.add(4);
            controller.drawX.add(7);

            //When
            controller.winningCombinationX();

            //Then
            Assertions.assertTrue(controller.winningCombinationX());
        }

        @Test
        void testWinningCombinationVerticalSecondLineX() {
            //Given
            Controller controller = new Controller(null);
            controller.drawX.add(2);
            controller.drawX.add(5);
            controller.drawX.add(8);

            //When
            controller.winningCombinationX();

            //Then
            Assertions.assertTrue(controller.winningCombinationX());
        }

        @Test
        void testWinningCombinationVerticalThirdLineX() {
            //Given
            Controller controller = new Controller(null);
            controller.drawX.add(3);
            controller.drawX.add(6);
            controller.drawX.add(9);

            //When
            controller.winningCombinationX();

            //Then
            Assertions.assertTrue(controller.winningCombinationX());
        }
    }
}