package com.ibm.cliente;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import com.ibm.conexao.Conexao;

public class Consumidor extends Conexao {
	
	 public void onMessage(Message message) {
	    	String consumidor = null;
	    	
	    	try {
				if (message instanceof TextMessage) {
					textMessage = (TextMessage) message;
					consumidor = textMessage.getText();
				}
				else {
					consumidor = message.toString();
				}
				
				if (consumidor.equalsIgnoreCase("quit")) {
					synchronized (this) {
						quit = true;
						this.notifyAll();
					}
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
	    	
	 }

}
