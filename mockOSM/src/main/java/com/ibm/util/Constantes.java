package com.ibm.util;

public final class Constantes {
	/* Arquivo de Propriedade */
	public static final String ARQUIVO_PROPRIEDADES = "./propriedades/dados.properties";
	
	/* Arquivo para conter todas de entrada */
	public static final String FILAS_JNDI = "./propriedades/filas.jndi";
	
	/* XML de retorno de sucesso do Inventario */ 
	public static final String ARQUIVO_INVENTARIO_SUCESSO = "./mensagens/inventario.xml";
	
	/*  Weblogic JMS URL */
	public static final String WEBLOGIC_JMS_URL = "t3://localhost:7101";
    
	/* Weblogic JNDI */
	public static final String WEBLOGIC_JNDI_FACTORY_NAME = "weblogic.jndi.WLInitialContextFactory"; 
    
	/* Weblogic ConnectionFactory JNDI */
	public static final String CONNECTION_FACTORY_JNDI_NAME = "jms/test/TestConnFactory";
    
	/* Weblogic Queue JNDI */
	public static final String QUEUE_JNDI_NAME = "jms/test/TestQueue";
	
	/* Weblogic User */
	public static final String WEBLOGIC_USER = "OSM";
	
	/* Weblogic Pass */
	public static final String WEBLOGIC_PASSWD = "OSM"; 
	
	/* Produto */
	public static final String TYPE_PRODUTOR = "produtor";
	
	/* Consumidor */
	public static final String TYPE_CONSUMIDOR = "consumidor";
}
