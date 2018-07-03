package com.treinamento.voffice.disciplinaservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "aluno-service", configuration = FeignConfiguration.class)
public interface AlunoClient {

	@RequestMapping(value = "/alunos", method = RequestMethod.GET)
	ResponseEntity<List<Aluno>> getAllAlunos();

	@RequestMapping(value = "/alunos/{id}", method = RequestMethod.GET)
	ResponseEntity<Aluno> getAluno(@PathVariable("id") Long id);

}
