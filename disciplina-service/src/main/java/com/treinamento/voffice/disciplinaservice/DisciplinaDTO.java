package com.treinamento.voffice.disciplinaservice;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DisciplinaDTO {

	String nome;
	Integer cargaHoraria;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	Date dataInicio;
	List<String> alunosMatriculados;

	public static DisciplinaDTO wrapper(Disciplina disciplina, List<String> alunos) {
		return DisciplinaDTO.builder()
				.nome(disciplina.getNome())
				.cargaHoraria(disciplina.getCargaHoraria())
				.dataInicio(disciplina.getDataInicio())
				.alunosMatriculados(alunos)
				.build();
	}
}
