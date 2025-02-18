package com.java.dio.sudoku.service.impl;

import com.java.dio.sudoku.model.Sudoku;
import com.java.dio.sudoku.service.SudokuService;

public class SudokuServiceImpl implements SudokuService {
    private Sudoku sudoku;

    @Override
    public void startSudoku(int[][] initialNumbers) {
        sudoku = new Sudoku(initialNumbers);
    }

    @Override
    public void placeNumber(int number, int row, int col) {
        if (sudoku != null) {
            sudoku.placeNumber(number, row, col);
        }
    }

    @Override
    public void removeNumber(int row, int col) {
        if (sudoku != null) {
            sudoku.removeNumber(row, col);
        }
    }

    @Override
    public String checkStatus() {
        if (sudoku == null) {
            return "Not started";
        } else if (sudoku.isComplete()) {
            return sudoku.checkConflicts() ? "Complete with errors" : "Complete without errors";
        } else {
            return sudoku.checkConflicts() ? "Incomplete with errors" : "Incomplete without errors";
        }
    }

    @Override
    public void clear() {
        if (sudoku != null) {
            sudoku.clear();
        }
    }

    @Override
    public int[][] getBoard() {
        return sudoku != null ? sudoku.getBoard() : new int[9][9];
    }

    @Override
    public boolean[][] getFixed() {
        return sudoku != null ? sudoku.getFixed() : new boolean[9][9];
    }
}
