package br.com.fiap.cliente.main.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.cliente.core.domain.mappers.ClienteMapper;
import br.com.fiap.cliente.core.usecases.cliente.CreateClienteUsecase;
import br.com.fiap.cliente.core.usecases.cliente.RetrieveClienteUsecase;
import br.com.fiap.cliente.infra.db.postgresql.ClientePostgresqlRepository;

@Configuration
public class ClienteUsecaseConfiguration {

	@Autowired
	private ClientePostgresqlRepository clientePostgresqlRepository;

	@Autowired
	private ClienteMapper clienteMapper;

	@Bean
	CreateClienteUsecase constructCreateClienteUsecase() {
		return new CreateClienteUsecase(clientePostgresqlRepository, clienteMapper);
	}
	
	@Bean
	RetrieveClienteUsecase constructRetrieveClienteDbUsecase() {
		return new RetrieveClienteUsecase(clientePostgresqlRepository, clienteMapper);
	}
	
}
