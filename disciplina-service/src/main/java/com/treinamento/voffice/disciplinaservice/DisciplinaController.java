package com.treinamento.voffice.disciplinaservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

	@Autowired
	AlunoClient alunoClient;

	@Autowired
	DisciplinaRepository disciplinaRepository;

	@PostConstruct
	public void init() {
		this.disciplinaRepository.save(Disciplina.builder()
				.nome("Workshop Microservices")
				.cargaHoraria(40)
				.dataInicio(new Date(2018, 06, 05))
				.build());
		this.disciplinaRepository.save(Disciplina.builder()
				.nome("Java Web")
				.cargaHoraria(80)
				.dataInicio(new Date(2018, 07, 27))
				.build());
	}

	@GetMapping
	public ResponseEntity<List<DisciplinaDTO>> getDisciplinas() {

		List<DisciplinaDTO> response = new ArrayList<>();

		List<Disciplina> disciplinas = disciplinaRepository.findAll();

		disciplinas.forEach(disciplina -> response.add(DisciplinaDTO.wrapper(disciplina,
				alunoClient.getAllAlunos().getBody().stream().map(Aluno::getNome).collect(Collectors.toList()))));

		return ResponseEntity.ok(response);

	}

	@GetMapping("/{id}")
	public ResponseEntity<DisciplinaDTO> getDisciplina(@PathVariable("id") Long id) {

		return ResponseEntity.ok(DisciplinaDTO.wrapper(disciplinaRepository.getOne(id),
				alunoClient.getAllAlunos().getBody().stream().map(Aluno::getNome).collect(Collectors.toList())));
	}

}
