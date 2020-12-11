package br.edu.ifpb.pweb2.passbook.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.pweb2.passbook.exception.PassbookException;
import br.edu.ifpb.pweb2.passbook.model.Usuario;
import br.edu.ifpb.pweb2.passbook.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public void saveUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public Usuario findByLogin(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public Optional<Usuario> findById(Integer id) {
		return usuarioRepository.findById(id);
	}

	public List<Usuario> findAll() throws PassbookException {
		return usuarioRepository.findAll();
	}

	@Transactional
	public void deleteById(Integer id) {
		usuarioRepository.deleteById(id);
	}

}