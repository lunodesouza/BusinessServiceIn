package com.github.lunodesouza.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.lunodesouza.enums.ConfigEnum;
import com.github.lunodesouza.model.BusinessEvents;

/**
 * Simple BusinessServiceIn Service JAX-RS client using Jersey implementation
 * 
 * @author lunodesouza
 * @since 19/02/2020
 */
public class BusinessServiceIn {
	private final Logger log = Logger.getLogger(BusinessServiceIn.class);
	
	/**
	 * Send BusinessEvents Entity
	 * 
	 * @param businessEvents
	 */
	public void sendBusinessData(BusinessEvents businessEvents) {
		log.info("# Sending Business Event");
		
		Client client = null;
		WebTarget webTarget = null;
		Response response = null;
		
		try {
			client = ClientBuilder.newClient();
			
			HttpAuthenticationFeature feature = 
						HttpAuthenticationFeature.basic(ConfigEnum.SERVICE_USER.getValue(), ConfigEnum.SERVICE_HASH.getValue());
			
			client.register(feature);
			
			String serviceUri = getServiceURIPropertie();
			
			webTarget = client.target(serviceUri);
			
			Invocation.Builder invocationBuilder 
						= webTarget.request(MediaType.APPLICATION_JSON)
									.header("Content-Type", "application/json;charset=UTF-8")
								    .header("Accept", "application/json");
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			response = invocationBuilder.post(Entity.entity(objectMapper.writeValueAsString(businessEvents), MediaType.APPLICATION_JSON_TYPE));
			
			log.info("Response: "+ response);
			log.info(objectMapper.writeValueAsString(businessEvents));
			
			if(response.getStatus() >= HttpStatus.SC_BAD_REQUEST ) {
				log.error("# Business Event sender FAIL: "+ response);
			}
			if(response.getStatus() == HttpStatus.SC_OK ) {
				log.info("# Business Event sent with success! "+ response.getStatusInfo());
			}
			
			log.info("# Finished");
			
		} catch(Exception e) {
			log.error("Business service error: ", e.getCause());
		} finally {
			if(response != null) {
				response.close();
			}
			client.close();
			webTarget = null;
		}
	}

	
	/**
	 * @return ServiceURIPropertie
	 */
	private String getServiceURIPropertie() {
		StringBuilder sb = new StringBuilder();
		try {
			
			if(null != ConfigEnum.SERVICE_URI.getValue()) {
				sb.append(ConfigEnum.SERVICE_URI.getValue());
			} else {
				throw new Exception("SERVICE_URI not found!");
			}
			
			if(null != ConfigEnum.SERVICE_USER.getValue()) {
				sb.append(ConfigEnum.SERVICE_USER.getValue());
			} else {
				throw new Exception("SERVICE_USER not found!");
			}
			
			sb.append("/log");
					
		} catch (Exception e) {
			log.error("Incorrect config properties: ", e);
		}
		return sb.toString();
	}
	
}
