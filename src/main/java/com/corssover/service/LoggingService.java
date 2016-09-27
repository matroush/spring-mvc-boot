package com.corssover.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;
import org.springframework.stereotype.Service;

import com.corssover.domain.Application;
import com.corssover.domain.Log;
import com.corssover.repositories.ApplicationRepository;
import com.corssover.repositories.LogRepository;
import com.corssover.rest.dto.LogResponse;
import com.corssover.rest.errors.RestApiException;

@Service
public class LoggingService {

	private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

	@Autowired
	ApplicationRepository applicationRepository;

	@Autowired
	LogRepository logRepository;

	@Autowired
	RateLimitService rateLimiter;

	@Autowired
	private HttpServletRequest request;

	public Application register(Application application) throws RestApiException {

		if (application.getApplicationId() != null || application.getSecret() != null)
			throw new RestApiException(HttpStatus.BAD_REQUEST.toString(),
					"Application Id And secret shouldn't have value ");

		populateApplicationWithRandomCred(application);

		return applicationRepository.save(application);
	}

	public LogResponse log(Log logRequest) throws Exception {

		
		rateLimiter.checkRateLimit(logRequest);
		
		
		Log savedLog = logRepository.save(logRequest);

		return ((savedLog != null && savedLog.getId() > 0) ? new LogResponse(true) : new LogResponse(false));
	}

	private void populateApplicationWithRandomCred(Application application) {

		RandomValueStringGenerator randomValueStringGenerator = new RandomValueStringGenerator(32);

		application.setApplicationId(randomValueStringGenerator.generate());
		application.setSecret(randomValueStringGenerator.generate());
	}

}
