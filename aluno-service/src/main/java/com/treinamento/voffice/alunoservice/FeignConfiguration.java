package com.treinamento.voffice.alunoservice;

import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

	int FIVE_SECONDS = 5000; // milliseconds

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	@Bean
	public Request.Options options() {
		return new Request.Options(FIVE_SECONDS, FIVE_SECONDS);
	}
}
