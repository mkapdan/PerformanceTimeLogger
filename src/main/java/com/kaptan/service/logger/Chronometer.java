package com.kaptan.service.logger;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Chronometer {

	private LogTimeLevel DEFAULT_LEVEL;

	private Map<String, Long> stepTimerMap;

	private long start;

	private long stepStart;

	private long end;

	private boolean lockTimeLevelChange = false;

	public Chronometer() {
		stepTimerMap = new LinkedHashMap<String, Long>();
		DEFAULT_LEVEL = LogTimeLevel.MILISECONDS;

	}

	public long elapsedTime() {
		lockTimeLevel();
		end = System.currentTimeMillis();
		long totalTime = (end - start) / DEFAULT_LEVEL.getValue();
		return totalTime;
	}

	public void start() {
		start = System.currentTimeMillis();
		stepStart = start;

	}

	public long stepElapsedTime(String stepName) {
		lockTimeLevel();
		long endStep = System.currentTimeMillis();
		long stepElapsedTime = (endStep - stepStart) / DEFAULT_LEVEL.getValue();
		stepTimerMap.put(stepName, stepElapsedTime);
		stepStart = endStep;
		return stepElapsedTime;
	}

	public String getLinearizedLogs() {
		StringBuilder sb = new StringBuilder();

		sb.append(TimerFormatterConstans.LOG_DATETIME);
		sb.append(TimerFormatterConstans.EQUAL_DELIMETER);
		sb.append(new Date());
		sb.append(TimerFormatterConstans.TAB);
		for (Map.Entry<String, Long> mapEntry : stepTimerMap.entrySet()) {
			sb.append(mapEntry.getKey());
			sb.append(TimerFormatterConstans.EQUAL_DELIMETER);
			sb.append(mapEntry.getValue());
			sb.append(TimerFormatterConstans.TAB);
		}
		sb.append(TimerFormatterConstans.TOTAL_TIME);
		sb.append(TimerFormatterConstans.EQUAL_DELIMETER);
		sb.append(elapsedTime());

		// Clear Results
		clearMap();

		return sb.toString();
	}

	public void setDEFAULT_LEVEL(LogTimeLevel dEFAULT_LEVEL) {
		// Just let the change level before step start
		if (false == lockTimeLevelChange) {
			DEFAULT_LEVEL = dEFAULT_LEVEL;
		}
	}

	private void lockTimeLevel() {
		this.lockTimeLevelChange = true;
	}

	private void clearMap() {
		this.stepTimerMap.clear();
	}
}
