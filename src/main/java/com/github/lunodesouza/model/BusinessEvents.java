package com.github.lunodesouza.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.lunodesouza.enums.ConfigEnum;
import com.github.lunodesouza.service.BusinessServiceIn;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ 
	"LOG_TYPE", 
	"CLIENT_NAME", 
	"SERVICE_TYPE", 
	"ROBOT_NAME",
	"BUSINESS_DATETIME",
	"EVENTS" 
})
public class BusinessEvents implements Serializable {
	@JsonProperty("LOG_TYPE")
	private String logType;
	@JsonProperty("CLIENT_NAME")
	private String clientName;
	@JsonProperty("SERVICE_TYPE")
	private String serviceType;
	@JsonProperty("ROBOT_NAME")
	private String robotName;
	@JsonProperty("BUSINESS_DATETIME")
	private String businessDateTime;
	
	@JsonProperty("EVENTS")
	private Event event;
	
	@JsonProperty("EVENTS")
	private List<Event> eventList;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 3546277791998097865L;

	/**
	 * Set config propertie params
	 */
	public BusinessEvents() {
		this.logType = ConfigEnum.LOG_TYPE.getValue();
		this.clientName = ConfigEnum.CLIENT_NAME.getValue();
		this.serviceType = ConfigEnum.SERVICE_TYPE.getValue();
	}

	public BusinessEvents(String logType, String clientName, String serviceType, Event event) {
		super(); 
		this.logType = logType;
		this.clientName = clientName;
		this.serviceType = serviceType;
		this.event = event;
	}
	
	/**
	 * Call to service sender
	 */
	public void send() {
		new BusinessServiceIn().sendBusinessData(this);
	}
	
	public List<Event> asList(){
		eventList.add(event);
		return eventList;
	}


	@JsonProperty("LOG_TYPE")
	public String getLogType() {
		return logType;
	}

	@JsonProperty("LOG_TYPE")
	public void setLogType(String logType) {
		this.logType = logType;
	}

	public BusinessEvents withLogType(String logType) {
		this.logType = logType;
		return this;
	}

	@JsonProperty("CLIENT_NAME")
	public String getClientName() {
		return clientName;
	}

	@JsonProperty("CLIENT_NAME")
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public BusinessEvents withClientName(String clientName) {
		this.clientName = clientName;
		return this;
	}

	@JsonProperty("SERVICE_TYPE")
	public String getServiceType() {
		return serviceType;
	}

	@JsonProperty("SERVICE_TYPE")
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public BusinessEvents withServiceType(String serviceType) {
		this.serviceType = serviceType;
		return this;
	}
	
	@JsonProperty("ROBOT_NAME")
	public String getRobotName() {
		return robotName;
	}

	@JsonProperty("ROBOT_NAME")
	public void setRobotName(String robotName) {
		this.robotName = robotName;
	}

	public BusinessEvents withRobotName(String robotName) {
		this.robotName = robotName;
		return this;
	}
	
	@JsonProperty("BUSINESS_DATETIME")
	public String getDateTime() {
		return businessDateTime;
	}

	@JsonProperty("BUSINESS_DATETIME")
	public void setDateTime(String businessDateTime) {
		this.businessDateTime = businessDateTime;
	}

	public BusinessEvents withDateTime(String businessDateTime) {
		this.businessDateTime = businessDateTime;
		return this;
	}
	
	public BusinessEvents withDateTimeNow() {
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.businessDateTime = sdf.format(new Date());
		return this ;
	}

//	@JsonProperty("EVENT") 
//	public Event getEvent() {
//		return event;
//	}
//
//	@JsonProperty("EVENT")
//	public void setEvent(Event event) {
//		eventList.add(event);
//	}
	
	@JsonProperty("EVENTS")
	public List<Event> getEvents() {
		return eventList;
	}

	@JsonProperty("EVENTS")
	public void setEvents(Event event) {
		eventList.add(event);
	}
	
	public BusinessEvents withEvents(List<Event> events) {
		eventList = events;
		return this;
	}

	public BusinessEvents withEvent(Event event) {
		eventList = new ArrayList<>();
		eventList.add(event);
		return this;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public BusinessEvents withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}	

}