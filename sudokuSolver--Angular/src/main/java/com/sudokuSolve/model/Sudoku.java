package com.sudokuSolve.model;

public class Sudoku {

	private int[][] box;

	public Sudoku(int[][] box) {
		super();
		this.box = box;
	}
	
	public Sudoku() {
		super();
	}

	public int[][] getBox() {
		return box;
	}

	public void setBox(int[][] box) {
		this.box = box;
	}
	
	
}
