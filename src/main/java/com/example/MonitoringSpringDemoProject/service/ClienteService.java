package com.example.MonitoringSpringDemoProject.service;

import com.example.MonitoringSpringDemoProject.domain.Cliente;
import com.example.MonitoringSpringDemoProject.dto.ClienteDTO;
import com.example.MonitoringSpringDemoProject.dto.CreateClienteDTO;

import java.util.List;


public interface ClienteService {

    List<ClienteDTO> findAll();
    ClienteDTO findById(Integer id);

    ClienteDTO create( CreateClienteDTO createClienteDTO);

    ClienteDTO update(Integer id, CreateClienteDTO createClienteDTO);

    void delete(Integer id);


}
