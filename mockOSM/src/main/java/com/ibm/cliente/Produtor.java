package com.ibm.cliente;

import javax.jms.JMSException;
import javax.naming.NamingException;

import com.ibm.conexao.Conexao;
import com.ibm.util.Constantes;

public class Produtor {
	
	public static void sendMessage(String mensagem, String fila) throws JMSException {
		Conexao conexao = new Conexao();
		
		try {
			conexao.initConnection(fila, Constantes.TYPE_PRODUTOR);
			conexao.send(mensagem);
						
		} catch (NamingException nex) {
			nex.printStackTrace();
						
		} finally {
			conexao.closeSender();
		}
	}

}
