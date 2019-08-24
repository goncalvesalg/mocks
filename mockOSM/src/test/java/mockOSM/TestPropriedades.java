package mockOSM;

import java.io.IOException;
import java.util.Properties;

import com.ibm.util.Propriedades;

public class TestPropriedades {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String teste = " ";

		try {
			Properties prop = Propriedades.getProp();
			
			teste = prop.getProperty("teste.log");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Teste Log " + teste);
		
	}

}
