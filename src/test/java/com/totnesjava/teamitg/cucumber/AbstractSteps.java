package com.totnesjava.teamitg.cucumber;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;

public class AbstractSteps extends CucumberBootstrap {

	protected String baseUrl() {
		return "http://localhost:" + super.port;
	}

	protected <T> T callRestGet(String uri, Class<T> returnClass) {
		ResponseEntity<T> response = super.testRestTemplate.getForEntity(baseUrl() + uri, returnClass);
		lastHttpStatus = response.getStatusCodeValue();
		return response.getBody();
	}

	protected <T> T callRestPost(String uri, Object postObject, Class<T> returnClass) {
		ResponseEntity<T> response = super.testRestTemplate.postForEntity(baseUrl() + uri, postObject, returnClass);
		lastHttpStatus = response.getStatusCodeValue();
		return response.getBody();
	}

	/**
	 * In the case of a 401(Unauthorised) it seems that RestTemplate attempts a
	 * retry. Not desirable in a test, so disable it.
	 * 
	 * @Link https://stackoverflow.com/questions/16748969/java-net-httpretryexception-cannot-retry-due-to-server-authentication-in-strea
	 */
	protected void fixIssueOfRetriesByRestTemplate() {
		testRestTemplate.getRestTemplate().setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		testRestTemplate.getRestTemplate().setErrorHandler(new DefaultResponseErrorHandler() {
			public boolean hasError(ClientHttpResponse response) throws IOException {
				HttpStatus statusCode = response.getStatusCode();
				return statusCode.series() == HttpStatus.Series.SERVER_ERROR;
			}
		});
	}

	protected Integer lastHttpStatus;
	
}
