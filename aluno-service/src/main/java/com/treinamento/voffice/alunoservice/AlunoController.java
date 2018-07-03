package com.treinamento.voffice.alunoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	DisciplinaClient disciplinaClient;

	@Autowired
	AlunoRepository alunoRepository;

	@GetMapping
	public ResponseEntity<List<AlunoDTO>> getAlunos() {

		List<Aluno> alunos = alunoRepository.findAll();

		List<AlunoDTO> response = new ArrayList<>();

		alunos.forEach(aluno -> response.add(AlunoDTO.builder()
				.nome(aluno.getNome())
				.matricula(aluno.getMatricula())
				.email(aluno.getEmail())
				.disciplinas(new ArrayList<>())
				.build()));

		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AlunoDTO> getAluno(@PathVariable("id") Long id) {

		Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RestClientException("Aluno id not found"));

		List<String> disciplinas = disciplinaClient.getAllDisciplinas().getBody().stream().map(Disciplina::getNome)
				.collect(Collectors.toList());

		return ResponseEntity.ok(AlunoDTO.builder()
				.nome(aluno.getNome())
				.matricula(aluno.getMatricula())
				.email(aluno.getEmail())
				.disciplinas(disciplinas)
				.build());

	}

}
