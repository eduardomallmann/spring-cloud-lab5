package com.treinamento.voffice.disciplinaservice;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Disciplina implements Serializable {

	private static final long serialVersionUID = -4571763361735883892L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String nome;
	Integer cargaHoraria;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@Temporal(TemporalType.TIMESTAMP)
	Date dataInicio;
}
