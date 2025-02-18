package com.java.dio.sudoku.model;

public class Sudoku {
    private int[][] board = new int[9][9];
    private boolean[][] fixed = new boolean[9][9];

    public Sudoku(int[][] initialNumbers) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = initialNumbers[i][j];
                fixed[i][j] = initialNumbers[i][j] != 0;
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean[][] getFixed() {
        return fixed;
    }

    public void placeNumber(int number, int row, int col) {
        if (!fixed[row][col]) {
            board[row][col] = number;
        }
    }

    public void removeNumber(int row, int col) {
        if (!fixed[row][col]) {
            board[row][col] = 0;
        }
    }

    public boolean checkConflicts() {
        return false;
    }

    public boolean isComplete() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!fixed[i][j]) {
                    board[i][j] = 0;
                }
            }
        }
    }
}
