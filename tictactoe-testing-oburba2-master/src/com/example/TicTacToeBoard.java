package com.example;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 * Format came from the following link
 * https://github.com/google/styleguide/blob/gh-pages/intellij-java-google-style.xml
 */
public class TicTacToeBoard {

    private String finishedGame;
    final int boardLength = 3;
    private char[][] board;
    int XSum = 0;
    int OSum = 0;

    /**
     * This method should load a string into your TicTacToeBoard class.
     *
     * @param Board The string representing the board
     */
    public TicTacToeBoard(String Board) {
        finishedGame = Board.toUpperCase();
        if (Board.length() == 9) {
            int stringIndex = 0;
            board = new char[boardLength - 1][boardLength - 1];
            for (int i = 0; i < boardLength - 1; i++) {
                for (int j = 0; j < boardLength - 1; j++) {
                    board[i][j] = Board.charAt(stringIndex++);
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid input, string is not 9 characters long");
        }
    }

    /**
     * Tests for validity of board
     *
     * @return a boolean value true if board is valid false if board is invalid
     */
    public boolean validBoardTest() {
        int xCount = 0;
        int oCount = 0;
        for (int k = 0; k < finishedGame.length(); k++) {
            if ((finishedGame.charAt(k) == 'X') || (finishedGame.charAt(k) == 'x')) {
                xCount++;
            } else if ((finishedGame.charAt(k) == 'O') || (finishedGame.charAt(k) == 'o')) {
                oCount++;
            }
        }
        if (xCount == oCount || xCount == oCount++) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tests for the winner of the game
     *
     * @return int 1 if x wins 2 if o wins
     */
    private int winTest() {
        int winner = 0;
        winner = horizontalTest() + verticalTest() + diagonalTest() + diagonal2Test();
        return winner;
    }

    /**
     * Checks the state of the board (unreachable, no winner, X wins, or O wins)
     *
     * @return an enum value corresponding to the board evaluation
     */
    public Evaluation evaluate() {
        if (validBoardTest() == true) {
            if (winTest() == 1) {
                return Evaluation.Xwins;
            } else if (winTest() == 2) {
                return Evaluation.Owins;
            } else {
                return Evaluation.NoWinner;
            }
        } else {
            return Evaluation.UnreachableState;
        }
    }

    /**
     * Tests for wins in all rows
     *
     * @return int winningMarker 1 if x won horizontally and 2 if o won horizontally
     */
    private int horizontalTest() {
        int winningMarker = 0;
        for (int i = 0; i < boardLength; i++) {
            XSum = 0;
            OSum = 0;
            for (int j = 0; j < boardLength; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else if (board[i][j] == 'X') {
                    XSum++;
                } else if (board[i][j] == 'O') {
                    OSum++;
                }
            }
            if (XSum == 3) {
                winningMarker += 1;
            }
            if (OSum == 3) {
                winningMarker += 2;
            }
        }
        return winningMarker;
    }

    /**
     * Tests for wins in all columns
     *
     * @return int winningMarker 1 if x won vertically and 2 if o won vertically
     */
    private int verticalTest() {
        int winningMarker = 0;
        for (int i = 0; i < boardLength; i++) {
            XSum = 0;
            OSum = 0;
            for (int j = 0; j < boardLength; j++) {
                if (board[j][i] == '.') {
                    continue;
                } else if (board[j][i] == 'X') {
                    XSum++;
                } else if (board[j][i] == 'O') {
                    OSum++;
                }
            }
            if (XSum == 3) {
                winningMarker += 1;
            }
            if (OSum == 3) {
                winningMarker += 2;
            }
        }
        return winningMarker;
    }

    /**
     * Tests for wins in the top left to bottom right diagonal
     *
     * @return int winningMarker 1 if x won diagonally and 2 if o won diagonally (top left to bottom right diagonal)
     */
    private int diagonalTest() {
        int winningMarker = 0;
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == 'X') {
                winningMarker += 1;
            } else if (board[0][0] == 'O') {
                winningMarker += 2;
            }
        }
        return winningMarker;
    }

    /**
     * Tests for wins in the bottom left to top right diagonal
     *
     * @return int winningMarker 1 if x won diagonally and 2 if o won diagonally (bottom left to top right diagonal)
     */
    private int diagonal2Test() {
        int winningMarker = 0;
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
            if (board[2][0] == 'X') {
                winningMarker += 1;
            } else if (board[2][0] == 'O') {
                winningMarker += 2;
            }
        }
        return winningMarker;
    }
}
