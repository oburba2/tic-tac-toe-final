package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicTacToeBoardTest {
    // Unusual cases test:
    @Test
    public void testValidBoardOGoesFirst() {
        TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
        assertEquals(Evaluation.UnreachableState, board.evaluate());
    }

    @Test
    public void testValidBoardXGoesTwice() {
        TicTacToeBoard board = new TicTacToeBoard("XX.......");
        assertEquals(Evaluation.UnreachableState, board.evaluate());
    }

    @Test
    public void testValidBoardOGoesTwice() {
        TicTacToeBoard board = new TicTacToeBoard("XOO......");
        assertEquals(Evaluation.UnreachableState, board.evaluate());
    }

    @Test
    public void testValidBoardNoWinner() {
        TicTacToeBoard board = new TicTacToeBoard("XOOOXXXOO");
        assertEquals(Evaluation.NoWinner, board.evaluate());
    }

    @Test
    public void testValidBoard2Winners() {
        TicTacToeBoard board = new TicTacToeBoard("OOOXXX...");
        assertEquals(Evaluation.UnreachableState, board.evaluate());
    }

    // Test for X winning (Horizontal, Vertical, Diagonal):
    @Test
    public void testValidBoardXWinnerHorizontal() {
        TicTacToeBoard board = new TicTacToeBoard("XXXOX.O.O");
        assertEquals(Evaluation.Xwins, board.evaluate());
    }

    @Test
    public void testValidBoardXWinnerVerticl() {
        TicTacToeBoard board = new TicTacToeBoard("OX..X.OX.");
        assertEquals(Evaluation.Xwins, board.evaluate());
    }

    @Test
    public void testValidBoardXWinnerVertical() {
        TicTacToeBoard board = new TicTacToeBoard("O.X.XOXOX");
        assertEquals(Evaluation.Xwins, board.evaluate());
    }

    // Test for O winning (Horizontal, Vertical, Diagonal):
    @Test
    public void testValidBoardYWinnerHorizontal() {
        TicTacToeBoard board = new TicTacToeBoard("XX.OXXOOO");
        assertEquals(Evaluation.Owins, board.evaluate());
    }

    @Test
    public void testValidBoardYWinnerColumn() {
        TicTacToeBoard board = new TicTacToeBoard("XO.XOXOOX");
        assertEquals(Evaluation.Owins, board.evaluate());
    }

    @Test
    public void testValidBoardYWinnerDiagonal() {
        TicTacToeBoard board = new TicTacToeBoard("..OXOXOX.");
        assertEquals(Evaluation.Owins, board.evaluate());
    }
}
