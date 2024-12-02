package br.com.fiap.cliente.core.usecases.cliente;

import br.com.fiap.cliente.core.domain.dto.ClienteDto;
import br.com.fiap.cliente.core.domain.entities.Cliente;
import br.com.fiap.cliente.core.domain.mappers.ClienteMapper;
import br.com.fiap.cliente.infra.ports.repositories.ClienteRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Transactional
public class RetrieveClienteUsecase {

	private final ClienteRepositoryPort clientePort;

	private final ClienteMapper clienteMapper;

	public RetrieveClienteUsecase(ClienteRepositoryPort clientePort, ClienteMapper clienteMapper) {
		this.clientePort = clientePort;
		this.clienteMapper = clienteMapper;
	}

	public ClienteDto retrieveCliente(String cpf) {
		Cliente cliente = clientePort.findByCpf(cpf);

		if (cliente == null) {
			throw new EntityNotFoundException("Cliente nao encontrado para o cpf :: " + cpf);
		}

		return clienteMapper.toDTO(cliente);
	}

}
