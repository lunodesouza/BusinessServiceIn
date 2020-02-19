package br.com.inmetrics.rpa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import br.com.inmetrics.rpa.enums.ConfigEnum;

/**
 * Classe responsável pela leitura da configuração no .properties
 * 
 * @author lunodesouza
 * @since 03/12/2019
 */
public class ConfigReader {
	private static Logger log = Logger.getLogger(ConfigReader.class);
	
	private static Properties props;
	private static String configProperties = ConfigEnum.CONFIG_PROPERTIES.getValue();

	public ConfigReader() {
		try {
			if(null != configProperties) {
				props = new Properties();
				InputStream input = new FileInputStream(configProperties);
				props.load(input);
			} else {
				log.warn("CONFIG_PROPERTIES: "+ configProperties);
			}
		} catch(FileNotFoundException fnf ) {
			log.warn("Properties can't be fount!", fnf);
		} catch (IOException io) {
			log.warn("Properties can't be read!", io);
		}
	}

	/**
	 * Metodo responsavel por recuperar o valor a partir da chave no .properties
	 * 
	 * @param key - key name
	 * @return value - key value or null
	 * @throws Exception 
	 */
	public static String read(String key) {
		if (null == props) {
			new ConfigReader();
		}
		
		if (null == key) {
			log.error("Config key is null.");
		}
		
		return null != props ? props.getProperty(key) : null;
	}
}
