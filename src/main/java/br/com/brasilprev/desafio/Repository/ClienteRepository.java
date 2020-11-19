package br.com.brasilprev.desafio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brasilprev.desafio.model.Clientes;

public interface ClienteRepository extends JpaRepository<Clientes, Long>  {

	Clientes findById(long id);
	
}
