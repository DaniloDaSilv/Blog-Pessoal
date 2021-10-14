package org.genration.blogPessoal.controller;

import java.util.List;
import java.util.Optional;

import org.genration.blogPessoal.model.USerLogin;
import org.genration.blogPessoal.model.Usuario;
import org.genration.blogPessoal.repository.UsuarioRepository;
import org.genration.blogPessoal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> GetAll() {
		return ResponseEntity.ok(usuarioRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> GetById(@PathVariable long id) {
		return usuarioRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/logar")
	public ResponseEntity<USerLogin> Autentication(@RequestBody Optional<USerLogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.CadastrarUsuario(usuario));
	}

}
