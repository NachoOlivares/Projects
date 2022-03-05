package com.diccionario.service;

import java.io.IOException;
import java.util.List;

public interface DiccionarioService {

	List<String> Buscador(String word, String exact) throws IOException;

}
