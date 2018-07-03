package com.treinamento.voffice.disciplinaservice;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlunoClientFallback implements AlunoClient {

	@Override
	public ResponseEntity<List<Aluno>> getAllAlunos() {

		List<Aluno> alunos = new ArrayList<>();

		alunos.add(Aluno.builder()
				.nome("Eduardo Mallmann")
				.email("mallmann.edu@gmail.com")
				.matricula("123456")
				.build());

		alunos.add(Aluno.builder()
				.nome("Joana silva")
				.matricula("22213551")
				.email("joana.silva@gmail.com")
				.build());

		return ResponseEntity.ok(alunos);
	}

	@Override
	public ResponseEntity<Aluno> getAluno(Long id) {
		return ResponseEntity.ok(Aluno.builder()
				.nome("Eduardo Mallmann")
				.email("mallmann.edu@gmail.com")
				.matricula("123456")
				.build());
	}
}
