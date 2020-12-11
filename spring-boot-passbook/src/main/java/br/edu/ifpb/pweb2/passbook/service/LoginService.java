package br.edu.ifpb.pweb2.passbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.pweb2.passbook.model.Usuario;
import br.edu.ifpb.pweb2.passbook.repository.UsuarioRepository;
import br.edu.ifpb.pweb2.passbook.util.PasswordUtil;

@Service
public class LoginService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public boolean isValido(Usuario usuario) {
		Usuario usuarioBD = usuarioRepository.findByEmail(usuario.getEmail());
		boolean valido = false;
		if (usuarioBD != null) {
			if (PasswordUtil.checkPass(usuario.getSenha(), usuarioBD.getSenha())) {
				valido = true;
			}
		} 
		return valido;
	}
	

}