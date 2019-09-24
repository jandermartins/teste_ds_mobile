package br.ufc.crateus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.crateus.model.Usuario;
import br.ufc.crateus.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario getUsuarioById(Integer id) {
		return usuarioRepository.findById(id).get();		
	}
	
	public Usuario getUsuarioByLogin(String login) {
		return usuarioRepository.findByLogin(login);
	}

	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario addUsuario(Usuario usuario) {
		System.out.println(usuario.toString());
		return usuarioRepository.saveAndFlush(usuario);
		
	}

	public Usuario editUsuario(Usuario usuario) {
		return usuarioRepository.saveAndFlush(usuario);
	}

	public void deleteUsuario(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
}
