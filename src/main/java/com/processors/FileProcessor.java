package com.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

public class FileProcessor implements Processor{
	final static Logger log = Logger.getLogger(FileProcessor.class);
	
	@Override 
	public void process(Exchange ex) throws Exception {
		log.info("Nombre de archivo: " + ex.getIn().getHeader("CamelFileName") + "; Carpeta destino: " + ex.getIn().getHeader("countryCode", String.class));
	}

}
