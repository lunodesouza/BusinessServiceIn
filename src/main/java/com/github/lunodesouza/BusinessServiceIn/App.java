package com.github.lunodesouza.BusinessServiceIn;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.github.lunodesouza.enums.ConfigEnum;
import com.github.lunodesouza.model.BusinessEvents;
import com.github.lunodesouza.model.Event;

/**
 * Hello world!
 * App test class
 */
public class App {
	private final static Logger log = Logger.getLogger(App.class);
	
	public static void main(String[] args) {
		log.info("Service Configured: "+ ConfigEnum.SERVICE_URI.getValue());
		
		/**
		 * Enviando 1 EVENTO
		 */
		Event event  = new Event()
				.withBusinessDescription("ENVIDOS")
				.withValue(2200);
		
		new BusinessEvents().withRobotName("ROBO 1")
							.withDateTimeNow()
							.withEvent(event)
							.send();
		
		/**
		 * Enviando uma lista de eventos
		 */
		List<Event> eventList = new ArrayList<>();
		
		eventList.add(new Event()
				.withBusinessDescription("ENVIADO")
				.withValue(5523)
		);
		
		eventList.add(new Event()
					.withBusinessDescription("ERRO")
					.withValue(80)
		);
		
		eventList.add(new Event()
					.withBusinessDescription("CPF NAO EXISTE")
					.withValue(55)
		);
		
		new BusinessEvents().withRobotName("ROBO 2")
					.withDateTimeNow()
					.withEvents(eventList)
					.send();
		
	}

}
