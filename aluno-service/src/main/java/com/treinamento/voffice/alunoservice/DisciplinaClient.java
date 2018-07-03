package com.treinamento.voffice.alunoservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "disciplina-service", configuration = FeignConfiguration.class)
public interface DisciplinaClient {

	@RequestMapping(value = "/disciplinas", method = RequestMethod.GET)
	ResponseEntity<List<Disciplina>> getAllDisciplinas();

	@RequestMapping(value = "/disciplinas/{id}", method = RequestMethod.GET)
	ResponseEntity<Disciplina> getDisciplina(@PathVariable("id") Long id);
}
