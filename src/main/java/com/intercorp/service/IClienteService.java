package com.intercorp.service;

import java.util.List;

import com.intercorp.model.Cliente;



public interface IClienteService  {
    
	
	public Cliente saveCliente(Cliente customerNew);
	
	public List<Cliente> promedEdadClientes();
	
    public List<Cliente> listar();
	
	public Cliente desviacionClientes();
}
