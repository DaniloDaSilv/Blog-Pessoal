package org.genration.blogPessoal.controller;


import java.util.Optional;

import org.genration.blogPessoal.model.USerLogin;
import org.genration.blogPessoal.model.Usuario;
import org.genration.blogPessoal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/usuarios")
public class UsuarioController {
	
		@Autowired
		private UsuarioService usuarioService;
		
		@PostMapping("/logar")
		public ResponseEntity<USerLogin> Autentication(@RequestBody Optional<USerLogin>user){
			return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
		}
		@PostMapping("/cadastrar")
		public ResponseEntity<Usuario>Post(@RequestBody Usuario usuario){
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(usuarioService.CadastrarUsuario(usuario));
		}
		
}
