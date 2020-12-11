package br.edu.ifpb.pweb2.passbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.pweb2.passbook.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
