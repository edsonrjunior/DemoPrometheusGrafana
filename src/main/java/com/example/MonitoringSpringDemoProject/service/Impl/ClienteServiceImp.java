package com.example.MonitoringSpringDemoProject.service.Impl;

import com.example.MonitoringSpringDemoProject.domain.Cliente;
import com.example.MonitoringSpringDemoProject.dto.ClienteDTO;
import com.example.MonitoringSpringDemoProject.dto.CreateClienteDTO;
import com.example.MonitoringSpringDemoProject.repository.ClienteRepository;
import com.example.MonitoringSpringDemoProject.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteDTO findById(Integer id) {
        Cliente cliente = getClienteById(id);
        log.info("Cliente {} encontrado", id);
        return new ClienteDTO(cliente);
    }

    @Override
    public List<ClienteDTO> findAll() {
        List<Cliente> clienteList;
        clienteList = clienteRepository.findAll();
        return clienteList
                .stream()
                .map(ClienteDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO create(CreateClienteDTO createClienteDTO) {
        Cliente cliente = new Cliente(createClienteDTO);
        log.info("Cliente {} salvo", cliente.getId());
        return new ClienteDTO(clienteRepository.save(cliente));
    }

    @Override
    public ClienteDTO update(Integer id, CreateClienteDTO createClienteDTO) {
        Cliente cliente = getClienteById(id);
        cliente.setId(id);
        cliente.setNome(createClienteDTO.getNome());
        cliente.setTelefone(createClienteDTO.getTelefone());
        log.info("Cliente {} atualizado", cliente.getId());
        return new ClienteDTO(clienteRepository.save(cliente));
    }

    @Override
    public void delete(Integer id) {
        clienteRepository.deleteById(id);
        log.info("Cliente {} excluido", id);
    }

    private Cliente getClienteById(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> {
                    log.info("Cliente {} não encontrado", id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND);
                });
    }

}
