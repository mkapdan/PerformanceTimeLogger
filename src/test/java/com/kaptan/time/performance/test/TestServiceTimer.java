package com.kaptan.time.performance.test;

import com.kaptan.service.logger.PerformanceTimeLogger;
import com.kaptan.service.logger.TimerFormatterConstans;

public class TestServiceTimer {

	public static void main(String[] args) {

		// String logLevelStr = System.getProperty("log.level");
		// LogTimeLevel logLevel = LogTimeLevel.getByName(logLevelStr);
		// PerformanceTimeLogger.setLogTimeLevel(logLevel);

		try {
			System.out.println("***************** Timer Logger Starts ******************");
			PerformanceTimeLogger.getChronometer().start();

			long sleepTime = 1000;
			sleepMyThread(sleepTime);
			PerformanceTimeLogger.getChronometer().stepElapsedTime("Mustafa");

			sleepTime = 1000;
			sleepMyThread(sleepTime);
			PerformanceTimeLogger.getChronometer().stepElapsedTime("Kaptan");

			sleepTime = 10000;
			sleepMyThread(sleepTime);

			PerformanceTimeLogger.getChronometer().startStep();
			sleepTime = 1000;
			sleepMyThread(sleepTime);
			PerformanceTimeLogger.getChronometer().stepElapsedTime("Performance");

			sleepTime = 1000;
			sleepMyThread(sleepTime);
			PerformanceTimeLogger.getChronometer().stepElapsedTime("Tester");

			System.out.println("***************** Print Step Time Logs ******************");
			System.out.println(PerformanceTimeLogger.getChronometer().stopAndGetLogs());

			System.out.println("***************** Timer Logger Final Time ******************");
			System.out.println(
					TimerFormatterConstans.TOTAL_TIME + " : " + PerformanceTimeLogger.getChronometer().elapsedTime());

			System.out.println("***************** Timer Logger Ends ******************");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void sleepMyThread(long sleepTime) throws InterruptedException {
		Thread.sleep(sleepTime);
	}

}
