package br.com.inmetrics.rpa.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"BUSINESS_DESCRIPTION",
	"VALUE"
})
public class Event implements Serializable {
	@JsonProperty("BUSINESS_DESCRIPTION")
	private String businessDescription;
	@JsonProperty("VALUE")
	private String value;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -5707070398248172942L;

	/**
	 * No args constructor for use in serialization
	 */
	public Event() {
	}

	@JsonProperty("BUSINESS_DESCRIPTION")
	public String getBusinessDescription() {
		return businessDescription;
	}

	@JsonProperty("BUSINESS_DESCRIPTION")
	public void setBusinessDescription(String businessDescription) {
		this.businessDescription = businessDescription;
	}

	public Event withBusinessDescription(String businessDescription) {
		this.businessDescription = businessDescription;
		return this;
	}

	@JsonProperty("VALUE")
	public String getVALUE() {
		return value;
	}

	@JsonProperty("VALUE")
	public void setVALUE(String value) {
		this.value = value;
	}

	public Event withValue(String value) {
		this.value = value;
		return this;
	}
	
	public Event withValue(int value) {
		this.value = String.valueOf(value);
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

	public Event withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}
	
}