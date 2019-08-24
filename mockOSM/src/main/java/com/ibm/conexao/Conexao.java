package com.ibm.conexao;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.helpers.QuietWriter;

import com.ibm.util.Constantes;

public class Conexao {

	protected Hashtable<String, String> wlsEnvParamHashTbl = null;
	protected static InitialContext initialContext = null;
	protected static QueueConnectionFactory queueConnectionFactory = null;
	protected static QueueConnection queueConnection = null;
	protected static QueueSession queueSession = null;
	protected static Queue queue = null;
	protected static QueueSender queueSender = null;
	protected static QueueReceiver queueReceiver = null;
	protected static TextMessage textMessage = null;
	protected boolean quit = false;

	public Conexao() {
		wlsEnvParamHashTbl = new Hashtable<String, String>();
		wlsEnvParamHashTbl.put(Context.PROVIDER_URL, Constantes.WEBLOGIC_JMS_URL);
		wlsEnvParamHashTbl.put(Context.INITIAL_CONTEXT_FACTORY, Constantes.WEBLOGIC_JNDI_FACTORY_NAME);
		wlsEnvParamHashTbl.put(Context.SECURITY_PRINCIPAL, Constantes.WEBLOGIC_USER);
		wlsEnvParamHashTbl.put(Context.SECURITY_CREDENTIALS, Constantes.WEBLOGIC_PASSWD);
	}

	public void initConnection(String queueName, String type) throws NamingException, JMSException {
		initialContext = new InitialContext(wlsEnvParamHashTbl);
		queueConnectionFactory = (QueueConnectionFactory) initialContext.lookup(Constantes.CONNECTION_FACTORY_JNDI_NAME);
		
		queueConnection = queueConnectionFactory.createQueueConnection();
		queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		
		queue = (Queue) initialContext.lookup(queueName);
		
		if (type.equals(Constantes.TYPE_PRODUTOR)) {
			queueSender = queueSession.createSender(queue);
		} else {
			queueReceiver = queueSession.createReceiver(queue);
		}
		
        textMessage = queueSession.createTextMessage(); 
        queueConnection.start(); 
	}
	
    public void send(String message) throws JMSException {
        textMessage.setText(message);
        queueSender.send(textMessage);
    }
    
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
 
    public void closeSender() throws JMSException {
        queueSender.close();
        queueSession.close();
        queueConnection.close();
    }
    
    public void closeReciver() throws JMSException {
        queueReceiver.close();
        queueSession.close();
        queueConnection.close();
    }
 
}
