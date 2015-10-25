package com.kaptan.time.performance.test;

import com.kaptan.service.logger.PerformanceTimeLogger;

public class SubClassTwo {

	public void doSomeSubliminalThings() throws InterruptedException {
		System.out.println("You are here : " + this.getClass().getSimpleName());
		Thread.sleep(3000);
		PerformanceTimeLogger.getChronometer().stepElapsedTime(SubClassTwo.class.getSimpleName());
	}
}
