package com.sudokuSolve.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudokuSolve.service.SudokuSolveService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api("Sudoku")
@RestController
public class controller {
		@Autowired
		SudokuSolveService app;
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
		@ApiOperation("Resolver sudoku")
		@GetMapping({"/ResolveSudoku"})
		public int[][] ResolveSudoku() {

			if(app.ShowResult(this.box)) {
				return this.box;
			};
			return null;
		}
}
