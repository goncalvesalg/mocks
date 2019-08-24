package mockOSM;

import java.io.IOException;
import java.util.List;

import com.ibm.util.CarregaArquivo;
import com.ibm.util.Constantes;

public class TestCarregaArquivo {

	public static void main(String[] args) {
		try {
			List<String> teste = CarregaArquivo.getArquivo(Constantes.ARQUIVO_INVENTARIO_SUCESSO);
			
			for (String linha : teste) {
	            System.out.println( linha );
	        }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
