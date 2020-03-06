package br.com.inmetrics.rpa.BusinessServiceIn;

import java.util.ArrayList;
import java.util.List;

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
		
		/**
		 * Enviando 1 EVENTO
		 */
		Event event  = new Event()
				.withBusinessDescription("GUIAS_ENVIADAS_ANALISE")
				.withValue(2200);
		
		new BusinessEvents().withRobotName("RPA_SADT")
							.withDateTimeNow()
							.withEvent(event)
							.send();
		
		/**
		 * Enviando uma lista de eventos
		 */
		List<Event> eventList = new ArrayList<>();
		
		eventList.add(new Event()
				.withBusinessDescription("GUIAS_ENVIADAS")
				.withValue(5523)
		);
		
		eventList.add(new Event()
					.withBusinessDescription("GUIAS_COM_ERRO")
					.withValue(80)
		);
		
		eventList.add(new Event()
					.withBusinessDescription("GUIAS_CPF_ERRADO")
					.withValue(55)
		);
		
		new BusinessEvents().withRobotName("RPA_SADT")
					.withDateTimeNow()
					.withEvents(eventList)
					.send();
		
	}

}
