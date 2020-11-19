package br.com.brasilprev.desafio.Services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasilprev.desafio.Repository.ClienteRepository;
import br.com.brasilprev.desafio.model.Clientes;

@Service
public class ClienteServices {

	@Autowired
	private ClienteRepository repo;
	
	public List<Clientes> listAll(){
		return repo.findAll();
	}
	
	public Clientes getClientesById(long id) {
		return repo.findById(id);
	}
	
	public void save(Clientes clientes) {
		repo.save(clientes);
	}
	
	public Clientes get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) throws Exception {
		Clientes clientes = repo.findById(id);
		if (Objects.nonNull(clientes)) {
			repo.deleteById(id);
		} else {
			throw new Exception("Id nao encontrado");
		}
	}
	
}
