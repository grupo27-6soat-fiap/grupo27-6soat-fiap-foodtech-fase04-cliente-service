package br.com.fiap.cliente.infra.db.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.fiap.cliente.core.domain.entities.Cliente;
import br.com.fiap.cliente.infra.db.entities.ClienteEntity;

@Component
public class ClienteDataMapper {

	private final ModelMapper modelMapper;

	public ClienteDataMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public Cliente toDomain(ClienteEntity data) {

		return modelMapper.map(data, Cliente.class);
	}

	public ClienteEntity toData(Cliente cliente) {

		return modelMapper.map(cliente, ClienteEntity.class);
	}
	
}


