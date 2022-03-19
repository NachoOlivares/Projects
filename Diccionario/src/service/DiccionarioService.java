package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class DiccionarioService {

	// Funcion para mapear la palabra introducida y cada alabra del diccionario en
	// un hasmap con key=>valor
	public Map<Character, Integer> MapearPalabra(String word) {

		Map<Character, Integer> LettersCount = new HashMap<>();

		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			int count = LettersCount.containsKey(letter) ? LettersCount.get(letter) : 0;
			LettersCount.put(letter, count + 1);
		}
		return LettersCount;
	}

	// Funcion para recoger convinacion de letras (input) y palabra del diccionario
	// con la que comparar
	public void Buscador(String word, boolean exact) throws IOException {

		Map<Character, Integer> OurWordMap = MapearPalabra(word.toLowerCase());
		boolean result = false;

		try (BufferedReader reader = new BufferedReader(
				new FileReader("C:/Users/Usuario/Documents/My Web Sites/Java/diccionario/diccionario.txt"))) {
			// Si dictWord fuera null significara que hemos llegado al final de la lista por
			// lo que acabara este bucle for
			for (String dictWord = reader.readLine(); dictWord != null; dictWord = reader.readLine()) {
				
				dictWord = dictWord.replaceAll("\\d","");
				
				Map<Character, Integer> dictWordMap = MapearPalabra(dictWord.toLowerCase());
				boolean Doable = true;

				for (Character charac : dictWordMap.keySet()) {
					// Se cuenta cuantos caracteres tiene cada parte
					int dictWordCount = dictWordMap.get(charac);
					// Para nuestra palabra primero vemos si contiene los caracteres de la palabra
					// del diccionario
					int OurWordCount = OurWordMap.containsKey(charac) ? OurWordMap.get(charac) : 0;

					// Si la palabra del diccionario no contiene las mismas letras que la convinacion dada
					// Y la palabra del diccionario y la convinacion no miden lo mismo significará que
					// No puede coincidir con una palabra exacta, por lo que romperemos el bucle sin pasar la palabra
					if(exact) {
						if (OurWordCount != dictWordCount || dictWord.length() != word.length()) {
							Doable = false;
							break;
						}
					}
					else {
						if (OurWordCount < dictWordCount) {
							Doable = false;
							break;
						}
					}
				}
				// Si doable es true significa que cada caracter de nuestra palabra es contenido
				// con el mmismo numero o menor por la palabra del diccionario
				if (Doable) {
					result = true;
					System.out.println(dictWord);
				}
			}
			if (!result) {
				System.out.println("There are not words that can be made combining that letters");
			}
		}

	}
}
