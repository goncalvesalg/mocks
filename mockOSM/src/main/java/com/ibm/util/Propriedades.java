package com.ibm.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propriedades {

	private static Properties properties = null;
	private static FileInputStream file = null; 
	
	public static Properties getProp() throws IOException {
		properties = new Properties();
		file = new FileInputStream(Constantes.ARQUIVO_PROPRIEDADES);
		
		properties.load(file);
		return properties;
	}
}
