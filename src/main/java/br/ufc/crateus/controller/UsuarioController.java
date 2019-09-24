package br.ufc.crateus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.crateus.model.Usuario;
import br.ufc.crateus.service.UsuarioService;

@RestController
@RequestMapping(value = "/teste/usuario")
@CrossOrigin
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> getUsuarios() {
		return new ResponseEntity<List<Usuario>>((List<Usuario>) usuarioService.getUsuarios(), HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Usuario getUsuarioById(Integer id) {
		return usuarioService.getUsuarioById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Usuario> addUsuario(Usuario usuario) {
		return new ResponseEntity<Usuario>((Usuario)usuarioService.addUsuario(usuario), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public Usuario editUsuario(Usuario usuario) {
		return usuarioService.editUsuario(usuario);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUsuario(Usuario usuario) {
		usuarioService.deleteUsuario(usuario);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Usuario> logar(String login, String senha) {

		System.out.println(login + senha);

		Usuario aux = usuarioService.getUsuarioByLogin(login);
		if (aux == null) {
			System.out.println("recusado");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if (aux.getSenha().equals(senha)) {
			System.out.println("Logou");
			return new ResponseEntity<Usuario>((Usuario) aux, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
