package br.com.gerenciador.tarefas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.gerenciador.tarefas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	@Query("SELECT u  FROM Usuario u WHERE upper(trim(u.name)) like %?1%")
	List<Usuario> findByName(String name);
}
