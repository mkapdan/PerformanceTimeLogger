package com.kaptan.service.logger;

public class PerformanceTimeLogger {

	private static final ThreadLocal<Chronometer> chronometer = new ThreadLocal<Chronometer>() {
		@Override
		protected Chronometer initialValue() {
			return new Chronometer();
		}
	};

	public static Chronometer getChronometer() {
		return chronometer.get();
	}

	public static void setLogTimeLevel(LogTimeLevel logTimeLevel) {
		getChronometer().setDEFAULT_LEVEL(logTimeLevel);
	}

}
