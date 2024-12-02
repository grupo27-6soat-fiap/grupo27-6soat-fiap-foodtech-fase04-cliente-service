package br.com.fiap.cliente.core.usecases.cliente;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.cliente.core.domain.dto.ClienteDto;
import br.com.fiap.cliente.core.domain.mappers.ClienteMapper;
import br.com.fiap.cliente.infra.ports.repositories.ClienteRepositoryPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class FindAllClientesUsecase {
	
	private final ClienteRepositoryPort clientePort;

	private final ClienteMapper clienteMapper;

	public List<ClienteDto> getAll() {
		return clientePort.findAll().stream().map(clienteData -> clienteMapper.toDTO(clienteData))
				.toList();
	}
	
}
