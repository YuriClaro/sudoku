package com.java.dio.sudoku.service;

public interface SudokuService {
    void startSudoku(int[][] initialNumbers);
    void placeNumber(int number, int row, int col);
    void removeNumber(int row, int col);
    String checkStatus();
    void clear();
    int[][] getBoard();
    boolean[][] getFixed();
}
