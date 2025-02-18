package com.java.dio.sudoku.controller;

import com.java.dio.sudoku.service.SudokuService;
import com.java.dio.sudoku.view.SudokuView;

public class SudokuController {
    private final SudokuService sudokuService;
    private final SudokuView sudokuView;

    public SudokuController(SudokuService sudokuService, SudokuView sudokuView) {
        this.sudokuService = sudokuService;
        this.sudokuView = sudokuView;
    }

    public void startGame(int[][] initialNumbers) {
        sudokuService.startSudoku(initialNumbers);
        sudokuView.updateBoard();
    }
}
