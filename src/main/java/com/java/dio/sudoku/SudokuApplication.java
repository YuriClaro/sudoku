package com.java.dio.sudoku;

import com.java.dio.sudoku.controller.SudokuController;
import com.java.dio.sudoku.service.SudokuService;
import com.java.dio.sudoku.service.impl.SudokuServiceImpl;
import com.java.dio.sudoku.view.SudokuView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class SudokuApplication {
	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(SudokuApplication.class, args);

		SwingUtilities.invokeLater(() -> {
			SudokuService sudokuService = new SudokuServiceImpl();
			SudokuView sudokuView = new SudokuView(sudokuService);
			SudokuController sudokuController = new SudokuController(sudokuService, sudokuView);

			int[][] initialNumbers = {
					{5, 3, 0, 0, 7, 0, 0, 0, 0},
					{6, 0, 0, 1, 9, 5, 0, 0, 0},
					{0, 9, 8, 0, 0, 0, 0, 6, 0},
					{8, 0, 0, 0, 6, 0, 0, 0, 3},
					{4, 0, 0, 8, 0, 3, 0, 0, 1},
					{7, 0, 0, 0, 2, 0, 0, 0, 6},
					{0, 6, 0, 0, 0, 0, 2, 8, 0},
					{0, 0, 0, 4, 1, 9, 0, 0, 5},
					{0, 0, 0, 0, 8, 0, 0, 7, 9}
			};

			sudokuController.startGame(initialNumbers);
			sudokuView.setVisible(true);
		});
	}

}
