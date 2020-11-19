package br.com.brasilprev.desafio.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.brasilprev.desafio.Services.ClienteServices;
import br.com.brasilprev.desafio.model.Clientes;

@RestController
public class ClienteController {

	@Autowired
	private ClienteServices services;

	@RequestMapping(value = "/api/clientes", method = RequestMethod.GET)
	public List<Clientes> list() {
		return services.listAll();
	}

	@RequestMapping(value = "/api/clientes/{id}", method = RequestMethod.GET)
	public ResponseEntity<Clientes> get(@PathVariable long id) {
		try {
			Clientes cliente = services.get(id);
			return new ResponseEntity<Clientes>(cliente, HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Clientes>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/api/clientes", method = RequestMethod.POST)
	public void add(@RequestBody Clientes cliente) {
			services.save(cliente);
	}

	
	@RequestMapping(value = "/api/clientes", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Clientes cliente, 
		@PathVariable long id) {
		try {
			Clientes existClientes = services.get(id);
			services.save(cliente);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}

	@RequestMapping(value = "/api/clientes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletaPessoa(@PathVariable(value = "id") Integer id) throws Exception {
    		if (Objects.nonNull(id)) {
    			try {
    				services.delete(id);
    				return new ResponseEntity<>(HttpStatus.ACCEPTED);
    			} catch (Exception e) {
    				System.out.println(e.getMessage());
    				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    			}
    		} else {
    			throw new Exception("Deve passar um id de pessoa");
    		}

    	}
	
}
