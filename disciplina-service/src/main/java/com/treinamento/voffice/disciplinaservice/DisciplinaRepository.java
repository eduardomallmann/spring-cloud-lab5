package com.treinamento.voffice.disciplinaservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/disciplina", collectionResourceRel = "disciplina")
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

}
