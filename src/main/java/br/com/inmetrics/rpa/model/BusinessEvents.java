package br.com.inmetrics.rpa.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.inmetrics.rpa.enums.ConfigEnum;
import br.com.inmetrics.rpa.service.BusinessServiceIn;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ 
	"LOG_TYPE", 
	"CLIENT_NAME", 
	"SERVICE_TYPE", 
	"EVENTS" 
})
public class BusinessEvents implements Serializable {
	@JsonProperty("LOG_TYPE")
	private String logType;
	@JsonProperty("CLIENT_NAME")
	private String clientName;
	@JsonProperty("SERVICE_TYPE")
	private String serviceType;
	@JsonProperty("EVENT")
	private Event event;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 3546277791998097865L;

	/**
	 * Set config propertie params
	 */
	public BusinessEvents() {
		this.logType = ConfigEnum.SERVICE_TYPE.getValue();
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
		new BusinessServiceIn().sendBusinessEvents(this);
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

	@JsonProperty("EVENTS")
	public Event getEvent() {
		return event;
	}

	@JsonProperty("EVENTS")
	public void setEvent(Event event) {
		this.event = event;
	}

	public BusinessEvents withEvent(Event event) {
		this.event = event;
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

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("logType", logType).append("clientName", clientName)
				.append("serviceType", serviceType).append("event", event)
				.append("additionalProperties", additionalProperties).toString();
	}

}