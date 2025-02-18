package com.java.dio.sudoku.view;

import com.java.dio.sudoku.service.SudokuService;

import javax.swing.*;
import java.awt.*;

public class SudokuView extends JFrame {
    private SudokuService sudokuService;
    private JButton[][] buttons = new JButton[9][9];

    public SudokuView(SudokuService gameService) {
        this.sudokuService = gameService;
        setTitle("Sudoku Game");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 9));

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 20));
                add(buttons[i][j]);
            }
        }

        updateBoard();
    }

    public void updateBoard() {
        int[][] board = sudokuService.getBoard();
        boolean[][] fixed = sudokuService.getFixed();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    buttons[i][j].setText(String.valueOf(board[i][j]));
                } else {
                    buttons[i][j].setText("");
                }
                buttons[i][j].setEnabled(!fixed[i][j]);
            }
        }
    }
}
