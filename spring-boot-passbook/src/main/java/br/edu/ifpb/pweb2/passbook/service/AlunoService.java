package br.edu.ifpb.pweb2.passbook.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.pweb2.passbook.exception.PassbookException;
import br.edu.ifpb.pweb2.passbook.model.Aluno;
import br.edu.ifpb.pweb2.passbook.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Transactional
	public void saveAluno(Aluno aluno) {
		alunoRepository.save(aluno);
	}
	
	public Optional<Aluno> findById(Integer id) {
		return alunoRepository.findById(id);
	}

	public List<Aluno> findAll() throws PassbookException {
		return alunoRepository.findAll();
	}

	@Transactional
	public void deleteById(Integer id) {
		alunoRepository.deleteById(id);
	}
}