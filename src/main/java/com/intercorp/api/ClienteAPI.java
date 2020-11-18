package com.intercorp.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.intercorp.model.Cliente;
import com.intercorp.service.IClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteAPI {
	
	@Autowired
	private IClienteService iClienteService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping(value = "/creacliente", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Cliente> crearcliente(@RequestBody Cliente cliente) {
		logger.info("Entro a crearCliente [creacliente]");
		
	
		try {
			Cliente cli= iClienteService.saveCliente(cliente);
		}catch(Exception e) {
			logger.error("Error -> ", e);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("Salio a crearClienteSSSSSSS [creaclienteSSSSSSS]");
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/kpideclientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll() {
		logger.info("Entro getAll [kpideclientes]");
           ResponseServicio response = new ResponseServicio();
		List<Cliente> list = new ArrayList<Cliente>();
		double media;
		double varianza = 0;
		double desviacion = 0;
		try {
			
			list = iClienteService.promedEdadClientes();
			int sum = 0;
			for(Cliente cli : list )
			{
				
				sum+=Integer.parseInt(cli.getEdad());
				
			}
			
			media = Math.round(sum/(float)list.size());
			double sumatoria;
			for (int i = 0; i < list.size() ; i++) {
				sumatoria = Math.pow(Double.parseDouble(list.get(i).getEdad()) - media, 2);
				varianza = varianza + sumatoria;

			}
			varianza = varianza /(list.size()-1); 
			//Desviacion
			
			desviacion = Math.sqrt(varianza);
			double redondeo = Math.rint(desviacion*100)/100;
			
			
			
			 if(list.isEmpty()){
				 System.out.println("List is empty");
			 } else {
				 response.setCodEjecucion(0);
				 System.out.println("Average found is " + Math.round(sum/(float)list.size()));
				 response.setPromedio("El Promedio de edad entre los clientes es : " + Math.round(sum/(float)list.size()));
				 response.setDesviacion("La Desviacion estandar es : " + redondeo);
			  } 
			
           
		
		} catch (Exception e) {
			logger.error("Error ->", e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("Salio getAll [kpi]");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/listclientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> listar() {
		logger.info("Entro getAll [listclientes]");
		 List<Cliente> list = new ArrayList<Cliente>();
	
		try {
			
	
			list = iClienteService.listar();
			 
			if (list == null) {
				list = new ArrayList<Cliente>();
			}
           
		
		} catch (Exception e) {
			logger.error("Error ->", e);
			return new ResponseEntity<List<Cliente>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("Salio getAll [listclientes]");
		return new ResponseEntity<List<Cliente>>(list, HttpStatus.OK);
	}

}
