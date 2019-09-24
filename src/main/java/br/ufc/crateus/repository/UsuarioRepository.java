package br.ufc.crateus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.crateus.model.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Usuario findByLogin(String login);

}
