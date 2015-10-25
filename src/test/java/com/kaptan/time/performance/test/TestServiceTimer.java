package com.kaptan.time.performance.test;

import com.kaptan.service.logger.LogTimeLevel;
import com.kaptan.service.logger.PerformanceTimeLogger;

public class TestServiceTimer {

	public static void main(String[] args) {

		String logLevelStr = System.getProperty("log.level");
		LogTimeLevel logLevel = LogTimeLevel.getByName(logLevelStr);
		
		PerformanceTimeLogger.setLogTimeLevel(logLevel);
		PerformanceTimeLogger.getChronometer().start();

		long sleepTime = 1000;

		try {
			System.out.println("***************** Timer Logger Starts ******************");
			sleepMyThread(sleepTime);
			System.out.println(PerformanceTimeLogger.getChronometer().stepElapsedTime("Mustafa"));
			sleepTime = 2000;
			sleepMyThread(sleepTime);
			PerformanceTimeLogger.setLogTimeLevel(LogTimeLevel.HOURS);

			System.out.println(PerformanceTimeLogger.getChronometer().stepElapsedTime("Kaptan"));
			sleepTime = 3000;
			sleepMyThread(sleepTime);

			System.out.println(PerformanceTimeLogger.getChronometer().stepElapsedTime("Melike"));
			sleepTime = 5000;
			sleepMyThread(sleepTime);

			System.out.println(PerformanceTimeLogger.getChronometer().stepElapsedTime("Yigit"));
			System.out.println("***************** Timer Logger Step Logs ******************");
			System.out.println(PerformanceTimeLogger.getChronometer().getLinearizedLogs());
			System.out.println("***************** Timer Logger Final Time ******************");
			System.out.println(PerformanceTimeLogger.getChronometer().elapsedTime());
			System.out.println("***************** Timer Logger Ends ******************");
			System.out.println(PerformanceTimeLogger.getChronometer().getLinearizedLogs());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void sleepMyThread(long sleepTime) throws InterruptedException {
		Thread.sleep(sleepTime);
	}

}
