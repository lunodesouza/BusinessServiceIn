package br.com.inmetrics.rpa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Classe responsável pela leitura da configuração no .properties
 * 
 * @author lunodesouza
 * @since 03/12/2019
 */
public class ConfigReader {
	private static Logger log = Logger.getLogger(ConfigReader.class);
	
	private static Properties props;
	private static final String FIXED_CONFIG_PROPERTIES = "BusinessServiceIn.properties";

	public ConfigReader() {
		try {
			props = new Properties();
			InputStream input = new FileInputStream(FIXED_CONFIG_PROPERTIES);
			props.load(input);
		} catch(FileNotFoundException fnf ) {
			log.error("Properties can't be found!", fnf);
		} catch (IOException io) {
			log.error("Properties can't be read!", io);
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
		try {
			if (null == props) {
				new ConfigReader();
			}
			
			if (null == key) {
				throw new Exception("Config propertie key cant be null");
			}
			
			return null != props ? props.getProperty(key) : null;
			
		}catch(Exception e) {
			log.error("ConfigReader FAIL: ", e);
		}
		return null;
	}
}
