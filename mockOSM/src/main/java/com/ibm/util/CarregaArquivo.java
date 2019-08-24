package com.ibm.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CarregaArquivo {
	
	public static List<String> getArquivo(String nomeArquivo) throws IOException {
		Path path = Paths.get(nomeArquivo);
		List<String> arquivo = Files.readAllLines(path);
		return arquivo;
	}
	
	public static String toString(List<String> arquivo) {
		StringBuffer menssagem =  new StringBuffer();
		
		for (String linha : arquivo) {
			menssagem.append(linha);
		}
		
		return menssagem.toString();
	}

}
