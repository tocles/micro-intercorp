package com.intercorp.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intercorp.model.Cliente;

public interface IClienteDAO  extends JpaRepository<Cliente, Long> { 
	
	Void save(Optional<Cliente> customerToUpdate);
	
}
