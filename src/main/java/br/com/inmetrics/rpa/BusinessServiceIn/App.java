package br.com.inmetrics.rpa.BusinessServiceIn;

import org.apache.log4j.Logger;

import br.com.inmetrics.rpa.enums.ConfigEnum;
import br.com.inmetrics.rpa.model.BusinessEvents;
import br.com.inmetrics.rpa.model.Event;

/**
 * Hello world!
 * App test class
 */
public class App {
	private final static Logger log = Logger.getLogger(App.class);
	
	public static void main(String[] args) {
		log.info("Service Configured: "+ ConfigEnum.SERVICE_URI.getValue());
		
		Event event  = new Event().withRobotName("RPA BOT")
				.withBusinessDescription("THE BUSINESS DESCRIPTION")
				.withValue("2 units")
				.withDateTime("27/02/2020 14:17");
		
		new BusinessEvents().withEvent(event).send();
		
	}

}
