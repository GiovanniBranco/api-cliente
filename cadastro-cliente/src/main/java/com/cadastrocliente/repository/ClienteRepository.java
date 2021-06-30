package com.cadastrocliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastrocliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
