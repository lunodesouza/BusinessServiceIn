package br.com.inmetrics.rpa.enums;

import br.com.inmetrics.rpa.util.ConfigReader;

public enum ConfigEnum {
	/* Properties de configuração BPOPadrao */
	CONFIG_PROPERTIES(System.getProperty("BusinessServiceInConfig")),
	
	/* Service config */
	SERVICE_URL(ConfigReader.read("business.service.url")),
	SERVICE_USER(ConfigReader.read("business.service.user")),
	SERVICE_HASH(ConfigReader.read("business.service.hash")),
	
	LOG_TYPE(ConfigReader.read("business.service.logtype")),
	CLIENT_NAME(ConfigReader.read("business.service.clientname")),
	SERVICE_TYPE(ConfigReader.read("business.service.type"));
	
	/* Variavel e construtor padrao deste enum */
	private String _value;
	private ConfigEnum(String descricao) {
		this._value = descricao;
	}
	
	public String getValue() {
		return _value;
	}
}
