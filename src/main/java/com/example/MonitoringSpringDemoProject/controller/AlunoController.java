package com.example.MonitoringSpringDemoProject.controller;

import com.example.MonitoringSpringDemoProject.dto.ClienteDTO;
import com.example.MonitoringSpringDemoProject.dto.CreateClienteDTO;
import com.example.MonitoringSpringDemoProject.metrics.MetricsService;
import com.example.MonitoringSpringDemoProject.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"clientes"})
public class AlunoController {

    private final ClienteService clienteService;
    private final MetricsService metricsService;

    public AlunoController(ClienteService clienteService, MetricsService metricsService) {
        this.clienteService = clienteService;
        this.metricsService = metricsService;
    }

    @GetMapping(value = "{id}", produces = "application/json")
    public ClienteDTO findById(@PathVariable Integer id) {
        return clienteService.findById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO create(@RequestBody @Valid CreateClienteDTO createClienteDTO) {
        ClienteDTO clienteDTO = clienteService.create(createClienteDTO);
        this.metricsService.incrementPostRequests();
        return clienteDTO;
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Valid int id) {
        this.clienteService.delete(id);
    }

    @PutMapping(value = "{id}", produces = "application/json", consumes = "application/json")
    public ClienteDTO update(@PathVariable Integer id, @RequestBody CreateClienteDTO createClienteDTO) {
        return this.clienteService.update(id, createClienteDTO);
    }

    @GetMapping(produces = "application/json")
    public List<ClienteDTO> getAll() {
        return clienteService.findAll();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Map<String, String> handlerValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }

}
