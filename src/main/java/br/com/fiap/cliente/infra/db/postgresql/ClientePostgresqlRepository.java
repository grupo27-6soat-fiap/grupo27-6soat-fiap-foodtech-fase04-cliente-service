package br.com.fiap.cliente.infra.db.postgresql;

import org.springframework.stereotype.Component;

import br.com.fiap.cliente.core.domain.entities.Cliente;
import br.com.fiap.cliente.infra.db.entities.ClienteEntity;
import br.com.fiap.cliente.infra.db.mappers.ClienteDataMapper;
import br.com.fiap.cliente.infra.db.repositories.ClienteRepository;
import br.com.fiap.cliente.infra.ports.repositories.ClienteRepositoryPort;

import java.util.List;

@Component
public class ClientePostgresqlRepository implements ClienteRepositoryPort {

	private final ClienteRepository clienteRepository;

	private final ClienteDataMapper clienteDataMapper;

	public ClientePostgresqlRepository(ClienteRepository clienteRepository, ClienteDataMapper clienteDataMapper) {
		this.clienteRepository = clienteRepository;
		this.clienteDataMapper = clienteDataMapper;
	}

	@Override
	public Cliente save(Cliente cliente) {
		ClienteEntity clienteSchema = clienteDataMapper.toData(cliente);
		clienteSchema = clienteRepository.save(clienteSchema);
		Cliente cli = clienteDataMapper.toDomain(clienteSchema);
		return cli;
	}

	@Override
	public Cliente findByCpf(String cpf) {
		ClienteEntity clienteSchema = clienteRepository.findByCpf(cpf);
		Cliente cli = null;
		if (clienteSchema != null) {
			cli = clienteDataMapper.toDomain(clienteSchema);
		}
		return cli;
	}

	@Override
	public Cliente get(Long id) {
		return clienteRepository.findById(id).map(clienteData -> clienteDataMapper.toDomain(clienteData)).orElse(null);
	}

	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll().stream().map(clienteData -> clienteDataMapper.toDomain(clienteData))
				.toList();
	}
	
}
