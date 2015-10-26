package com.kaptan.time.performance.test;

import com.kaptan.service.logger.PerformanceTimeLogger;

public class MainClass {

	public void doSomething() throws InterruptedException {
		System.out.println("********************** Time Profiler Start *******************");
		PerformanceTimeLogger.getChronometer().start();
		System.out.println("You are here : " + this.getClass().getSimpleName());

		Thread.sleep(2000);
		
		SubClassOne subone = new SubClassOne();
		subone.doSomeSubthing();

			
		SubClassTwo subtwo = new SubClassTwo();
		subtwo.doSomeSubliminalThings();

		Thread.sleep(4000);
	

		System.out.println(PerformanceTimeLogger.getChronometer().stopAndGetLogs());
	}

	public static void main(String[] args) {
		MainClass main = new MainClass();
		try {
			main.doSomething();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
