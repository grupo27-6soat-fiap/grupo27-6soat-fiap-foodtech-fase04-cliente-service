package br.com.fiap.cliente.core.domain.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.fiap.cliente.core.domain.dto.ClienteDto;
import br.com.fiap.cliente.core.domain.entities.Cliente;

@Component
public class ClienteMapper {

	private final ModelMapper modelMapper;

	public ClienteMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public Cliente toDomain(ClienteDto dto) {
		return modelMapper.map(dto, Cliente.class);
	}

	public ClienteDto toDTO(Cliente cliente) {
		return modelMapper.map(cliente, ClienteDto.class);
	}

}
