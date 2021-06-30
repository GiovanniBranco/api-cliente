package com.cadastrocliente.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service ;

import com.cadastrocliente.model.Endereco;
import com.cadastrocliente.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository repository;
	
	public Endereco findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " não encontrado."));
	}
	
	public List<Endereco> findAll(){
		return repository.findAll();
	}
	
	public Endereco create(Endereco endereco) {
		return repository.save(endereco);
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
}
