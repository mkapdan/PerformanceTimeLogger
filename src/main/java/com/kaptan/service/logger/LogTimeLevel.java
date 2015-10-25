package com.kaptan.service.logger;

import java.util.Locale;

/**
 * LogTimeLevel(long value, String name) {value = in miliseconds, name = type
 * name}.
 * 
 * For example = Seconds(1000,"Seconds")
 * 
 * @author kaptan
 *
 */
public enum LogTimeLevel {

	MILISECONDS((long) 1.0, "MILISECONDS"), SECONDS((long) 1000.0, "SECONDS"), MINUTES((long) 60000.0,
			"MINUTES"), HOURS((long) 3600000.0, "HOURS");

	private long value;

	private String name;

	LogTimeLevel(long value, String name) {
		this.value = value;
		this.name = name;
	}

	public long getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public static LogTimeLevel getByName(String name) {
		LogTimeLevel item = null;

		if (null != name && !name.isEmpty()) {
			String queryName = name.toUpperCase(Locale.ENGLISH);
			
			for (LogTimeLevel enumItem : LogTimeLevel.values()) {
				if (enumItem.getName().equals(queryName)) {
					item = enumItem;
					break;
				}
			}
		}
		if (null == item) {
			throw new RuntimeException("LogTimeLevel item could not found by name = " + name);
		}
		return item;
	}
}
