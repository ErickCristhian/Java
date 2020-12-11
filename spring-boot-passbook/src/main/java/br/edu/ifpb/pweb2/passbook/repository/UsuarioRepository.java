package br.edu.ifpb.pweb2.passbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.pweb2.passbook.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByEmail(String email);

}
