package com.corssover.service;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.corssover.domain.Log;
import com.corssover.rest.errors.RestApiException;
import com.google.code.ssm.Cache;
import com.google.code.ssm.providers.CacheException;

@Component
public class RateLimitService {

	private final Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

	//@Autowired
	private Cache cache;

	public static int timeToNextQuarterInSeconds = 60; 
	public final int LIMIT = 60;

	private Calendar calendar = Calendar.getInstance();

	@Scheduled(cron = "0/10 * * * * *")
	public void updateExpireTimeForCache() {
		int currentSeconds = calendar.get(Calendar.SECOND);

		int mod = currentSeconds % 60;

		calendar.set(Calendar.MINUTE, 1);
		calendar.set(Calendar.SECOND, currentSeconds - mod + 60);
		calendar.set(Calendar.MILLISECOND, 0);

		timeToNextQuarterInSeconds = (int) ((calendar.getTime().getTime() - new Date().getTime()) / 1000);
	}

	public long incrementLimit(String userKey) throws Exception {
		return cache.incr(userKey, 1, 1, timeToNextQuarterInSeconds);
	}

	public long holdApplication(String userKey, int period) throws Exception {
		return cache.incr(userKey, 1, 1, period);
	}

	public void checkRateLimit(Log logRequest) throws Exception {

		long count = 0;
		try {

			count = incrementLimit(logRequest.getApplicationId());

		} catch (Exception e) {
			throw e;
		}

		if (count == LIMIT) {

			logger.info("Rate limited exceeded " + count);
			holdApplication(logRequest.getApplicationId(), 5 * 60);

			throw new RestApiException("403", "Rate limited exceeded ");
		}

		if (count > LIMIT) {

			logger.info("Rate limited exceeded " + count);
			throw new RestApiException("403", "You should wait for 5 mintues to resume requests");
		}

	}
}
