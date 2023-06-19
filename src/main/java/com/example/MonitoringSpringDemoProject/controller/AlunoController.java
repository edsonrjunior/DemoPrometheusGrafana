package com.example.MonitoringSpringDemoProject.controller;

import com.example.MonitoringSpringDemoProject.dto.ClienteDTO;
import com.example.MonitoringSpringDemoProject.service.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"clientes"})
public class AlunoController {

    private final ClienteService clienteService;

    public AlunoController (ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(value = {"{id}"}, produces = {"application/json"})
    public ClienteDTO findById(@PathVariable Integer id) {
        return clienteService.findById(id);
    }

}
