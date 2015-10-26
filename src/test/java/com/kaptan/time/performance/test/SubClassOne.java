package com.kaptan.time.performance.test;

import com.kaptan.service.logger.PerformanceTimeLogger;

public class SubClassOne {

	public void doSomeSubthing() throws InterruptedException {

		PerformanceTimeLogger.getChronometer().startStep();
		System.out.println("You are here : " + this.getClass().getSimpleName());
		Thread.sleep(1000);
		PerformanceTimeLogger.getChronometer().stepElapsedTime(SubClassOne.class.getSimpleName());
	}
}
