package com.cadastrocliente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastrocliente.model.Cliente;
import com.cadastrocliente.services.ClienteService;

@CrossOrigin("*")
@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService service;

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		return new ResponseEntity<List<Cliente>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		return new ResponseEntity<Cliente>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
		return new ResponseEntity<Cliente>(service.create(cliente), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<String>("Cliente com id: " + id + " deletado com sucesso", HttpStatus.OK);
	}
}
