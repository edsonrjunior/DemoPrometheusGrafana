package com.example.MonitoringSpringDemoProject.controller;

import com.example.MonitoringSpringDemoProject.domain.Cliente;
import com.example.MonitoringSpringDemoProject.dto.ClienteDTO;
import com.example.MonitoringSpringDemoProject.dto.CreateClienteDTO;
import com.example.MonitoringSpringDemoProject.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"clientes"})
public class AlunoController {

    private final ClienteService clienteService;

    public AlunoController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(value = {"{id}"}, produces = {"application/json"})
    public ClienteDTO findById(@PathVariable Integer id) {
        return clienteService.findById(id);
    }

//    @GetMapping(produces = {"application/json"})
//    public List<ClienteDTO> getAll(@RequestParam(required = false, value = "nome") String nome) {
//        return clienteService.findAll(nome);
//    }


    @PostMapping(consumes = {"application/json"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO create(CreateClienteDTO createClienteDTO) {
        return this.clienteService.create(createClienteDTO);
    }

}
