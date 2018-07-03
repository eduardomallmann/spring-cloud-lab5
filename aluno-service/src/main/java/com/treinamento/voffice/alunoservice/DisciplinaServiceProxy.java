package com.treinamento.voffice.alunoservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisciplinaServiceProxy {

	@Autowired
	DisciplinaClient disciplinaClient;

	@HystrixCommand(fallbackMethod = "getNomesDisciplinasFallback",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
					@HystrixProperty(name = "requestCache.enabled", value = "false"),
			}, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "5"),
			@HystrixProperty(name = "maximumSize", value = "5")
	})
	public List<String> getNomesDisciplinas() {
		return disciplinaClient.getAllDisciplinas().getBody().stream().map(Disciplina::getNome)
				.collect(Collectors.toList());
	}

	public List<String> getNomesDisciplinasFallback() {
		return Arrays.asList("Workshop Microservices", "Java Web");
	}

}
