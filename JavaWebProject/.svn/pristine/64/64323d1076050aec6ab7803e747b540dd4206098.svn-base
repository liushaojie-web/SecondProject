package cn.news.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	private static ConfigManager configManager;
	private Properties properties;
	// 饿汉模式，立即加载，线程安全
	/*
	 * static{ configManager = new ConfigManager(); }
	 */

	private ConfigManager() {
		// 配置文件名
		String configFile = "database.properties";
		properties = new Properties();
		InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
		try {
			// 将输入流中的配置内容加载到properties中
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 单例模式加载ConfigManager
	public static synchronized ConfigManager getInstance() {
		// 懒汉模式，延迟加载，线程不安全，使用同步处理
		if (configManager == null) {
			configManager = new ConfigManager();
		}
		return configManager;
	}

	// 通过key获取对应的value
	public String getString(String key) {
		return properties.getProperty(key);
	}

}
