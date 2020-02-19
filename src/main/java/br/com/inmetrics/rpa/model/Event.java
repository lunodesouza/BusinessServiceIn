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
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"ROBOT_NAME",
"BUSINESS_DESCRIPTION",
"VALUE",
"BUSINESS_DATETIME"
})
public class Event implements Serializable {
	@JsonProperty("ROBOT_NAME")
	private String robotName;
	@JsonProperty("BUSINESS_DESCRIPTION")
	private String businessDescription;
	@JsonProperty("VALUE")
	private Integer value;
	@JsonProperty("BUSINESS_DATETIME")
	private String businessDateTime;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -5707070398248172942L;

	/**
	 * No args constructor for use in serialization
	 */
	public Event() {
	}

	
	public Event(String robotName, String businessDescription, Integer value, String businessDateTime) {
		super();
		this.robotName = robotName;
		this.businessDescription = businessDescription;
		this.value = value;
		this.businessDateTime = businessDateTime;
	}

	@JsonProperty("ROBOT_NAME")
	public String getRobotName() {
		return robotName;
	}

	@JsonProperty("ROBOT_NAME")
	public void setRobotName(String robotName) {
		this.robotName = robotName;
	}

	public Event withRobotName(String robotName) {
		this.robotName = robotName;
		return this;
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
	public Integer getVALUE() {
		return value;
	}

	@JsonProperty("VALUE")
	public void setVALUE(Integer value) {
		this.value = value;
	}

	public Event withValue(Integer value) {
		this.value = value;
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

	public Event withDateTime(String businessDateTime) {
		this.businessDateTime = businessDateTime;
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

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("robotName", robotName)
				.append("businessDescription", businessDescription).append("value", value)
				.append("businessDateTime", businessDateTime).append("additionalProperties", additionalProperties)
				.toString();
	}
}