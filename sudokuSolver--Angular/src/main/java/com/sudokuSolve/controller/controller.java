package com.sudokuSolve.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sudokuSolve.service.SudokuSolveService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@CrossOrigin("*")
@Api("Sudoku")
@RestController
public class controller {
		@Autowired
		SudokuSolveService app;
		/**int[][] box = {
				{5, 3, 0, 6, 0, 0, 0, 9, 8},
				{0, 7, 0, 1, 9, 5, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 6, 0},
				{8, 0, 0, 4, 0, 0, 7, 0 ,0},
				{0, 6, 0, 8, 0, 3, 0, 2, 0},
				{0, 0, 3, 0, 0, 1, 0, 0, 6},
				{0, 6, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 4, 1, 9, 0, 8, 0},
				{2, 8, 0, 0, 0, 5, 0, 7, 9},
		};**/
		
		//530600098070195000000000060800400700060803020003001006060000000000419080280005079
		
		@ApiOperation("Resolver sudoku")
		@GetMapping({"/ResolveSudoku"})
		public int[] ResolveSudoku(@ApiParam @RequestParam String box) {
			int[] sol = new int[81];
			String a = app.AngularShowResults(box);
			for (int i = 0; i < a.length(); i++) {
				sol[i] = Character.getNumericValue(a.charAt(i));
			}
			return sol;
		}
}
