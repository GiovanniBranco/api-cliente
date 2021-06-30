package com.cadastrocliente.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastrocliente.model.Cliente;
import com.cadastrocliente.repository.ClienteRepository;

@Service
public class ClienteService {

	
	@Autowired
	ClienteRepository repository;
	
	@Autowired
	EnderecoService endService;
	
	public Cliente findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " não encontrado."));
	}
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	public Cliente create(Cliente cliente) {
		endService.create(cliente.getEndereco());
		return repository.save(cliente);		
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
}
