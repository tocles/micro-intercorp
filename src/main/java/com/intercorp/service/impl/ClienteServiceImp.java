package com.intercorp.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intercorp.dao.IClienteDAO;
import com.intercorp.model.Cliente;
import com.intercorp.service.IClienteService;


@Service
public class ClienteServiceImp implements IClienteService  {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired		
	private IClienteDAO IClienteDAO;
	
	
	@Override
	public Cliente saveCliente(Cliente cliente) {
		// TODO Auto-generated method stub	
		logger.info("Entro a al service Dao");
		return IClienteDAO.save(cliente);
	}


	@Override
	public List<Cliente> promedEdadClientes() {
		// TODO Auto-generated method stub

		return  IClienteDAO.findAll();
	}
	
	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub

		return  IClienteDAO.findAll();
	}



	@Override
	public Cliente desviacionClientes() {
		// TODO Auto-generated method stub
		return null;
	}









}
