package com.example.MonitoringSpringDemoProject.service.Impl;

import com.example.MonitoringSpringDemoProject.domain.Cliente;
import com.example.MonitoringSpringDemoProject.dto.ClienteDTO;
import com.example.MonitoringSpringDemoProject.dto.CreateClienteDTO;
import com.example.MonitoringSpringDemoProject.repository.ClienteRepository;
import com.example.MonitoringSpringDemoProject.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService {
    private ClienteRepository clienteRepository;


    public ClienteServiceImp(ClienteRepository clienteRepository ){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDTO findById(Integer id) {
        Cliente cliente = getClienteById(id);
        return new ClienteDTO(cliente);
    }

    @Override
    public List<ClienteDTO> findAll(String nome) {
        return null;
    }



    @Override
    public ClienteDTO create(CreateClienteDTO createClienteDTO) {
        Cliente cliente = new Cliente(createClienteDTO);
        return new ClienteDTO(clienteRepository.save(cliente));
    }

    @Override
    public ClienteDTO update(Integer id, CreateClienteDTO createClienteDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {
    }

    private Cliente getClienteById(Integer id) {
    return clienteRepository.findById(id)
            .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
