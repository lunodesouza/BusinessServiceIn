package com.github.lunodesouza.enums;

import com.github.lunodesouza.util.ConfigReader;

public enum ConfigEnum {
	/* Properties de configuração */
	CONFIG_PROPERTIES(System.getProperty("BusinessServiceInConfig")),
	
	/* Service config */
	SERVICE_URI(ConfigReader.read("business.service.URI")),
	SERVICE_USER(ConfigReader.read("business.service.USER")),
	SERVICE_HASH(ConfigReader.read("business.service.HASH")),
	
	LOG_TYPE(ConfigReader.read("business.service.LOG_TYPE")),
	CLIENT_NAME(ConfigReader.read("business.service.CLIENT_NAME")),
	SERVICE_TYPE(ConfigReader.read("business.service.SERVICE_TYPE"));
	
	/* Variavel e construtor padrao deste enum */
	private String _value;
	private ConfigEnum(String descricao) {
		this._value = descricao;
	}
	
	public String getValue() {
		return _value;
	}
}
