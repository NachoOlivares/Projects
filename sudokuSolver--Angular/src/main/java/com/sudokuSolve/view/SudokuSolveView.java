package com.sudokuSolve.view;

import com.sudokuSolve.service.SudokuSolveServiceImpl;

public class SudokuSolveView {

	
	public static void main(String[] args) {
		
		var app = new SudokuSolveServiceImpl();
		/**
		Thread app2 = new Thread(app);
		Thread app3 = new Thread(app);
		Thread app4 = new Thread(app);
		**/

		int[][] box = {
				{5, 3, 0, 6, 0, 0, 0, 9, 8},
				{0, 7, 0, 1, 9, 5, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 6, 0},
				{8, 0, 0, 4, 0, 0, 7, 0 ,0},
				{0, 6, 0, 8, 0, 3, 0, 2, 0},
				{0, 0, 3, 0, 0, 1, 0, 0, 6},
				{0, 6, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 4, 1, 9, 0, 8, 0},
				{2, 8, 0, 0, 0, 5, 0, 7, 9},
		};
		if (app.ShowResult(box)) {
			System.out.println("Resuelto!");
		}
		else {
			System.out.println("No se puede resolver...");
		}
		
		for (int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
					System.out.print(box[i][j]);
					if(j==2 || j==5 || j==8) {
						System.out.print("|");
					}
			}
			System.out.println("");
			if(i==2 || i==5 || i==8) {
				System.out.println("---------");
			}
		}
		/** MultiThreads
		app2.start();
		app3.start();
		app4.start();
		**/
	}
}
