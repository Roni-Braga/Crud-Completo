package br.com.gerenciador.tarefas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.gerenciador.tarefas.model.*;
import br.com.gerenciador.tarefas.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository UsuarioRepository;

		
	@PostMapping
	@Transactional
	public ResponseEntity<Usuario>  cadastrarUsuario(@RequestBody Usuario usuario) {
		
		var usuarioCadastrado = UsuarioRepository.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCadastrado);
		
	}
	@GetMapping
	public ResponseEntity<List<Usuario>>  listAllUsuarios() {
		
		List<Usuario> usuarios = UsuarioRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(usuarios);
	}
	
	@DeleteMapping
	public ResponseEntity excluirUsuario(@RequestParam String id) {
		UsuarioRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com Sucesso");
		
	}
	@GetMapping("buscarPorId")
	public ResponseEntity buscarUsuarioPorId(@RequestParam String id) {
		Optional<Usuario> usuario = UsuarioRepository.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}
	@PutMapping
	@Transactional
	public ResponseEntity<?>  atualizarUsuario(@RequestBody Usuario usuario) {
		if(usuario.getId() == null) {
			return ResponseEntity.status(HttpStatus.OK).body("Informe o usuário que você deseja excluir");
		}
		var usuarioAtualizado = UsuarioRepository.saveAndFlush(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioAtualizado);
		
	}
	@GetMapping("BuscarPorNome")
	public ResponseEntity<List<Usuario>> buscarUsuarioPorNome(@RequestParam String name){
		
		List<Usuario> usuario = UsuarioRepository.findByName(name.trim().toUpperCase());
		
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}
		
	}
	
