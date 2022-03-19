package view;

import java.io.IOException;
import java.util.Scanner;

import service.DiccionarioService;

public class DiccionarioView {

	
	public static void main(String[] args) throws IOException {
		
		DiccionarioService app = new DiccionarioService();
		
		Scanner sc = new Scanner(System.in);
		boolean exact = false;
		
		System.out.println("Set the letters to search a word which contains them: ");
		String word = sc.next();
		System.out.println("Do u wanna find an exact match? (y/n)");
		if (sc.nextLine().equals("Y") || sc.nextLine().equals("y")) {
			exact = true;
		}
		
		app.Buscador(word.toUpperCase(), exact);
		sc.close();
	}

}
