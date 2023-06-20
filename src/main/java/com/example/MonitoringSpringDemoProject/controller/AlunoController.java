package com.example.MonitoringSpringDemoProject.controller;

import com.example.MonitoringSpringDemoProject.dto.ClienteDTO;
import com.example.MonitoringSpringDemoProject.dto.CreateClienteDTO;
import com.example.MonitoringSpringDemoProject.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    public ClienteDTO create(@RequestBody @Valid CreateClienteDTO createClienteDTO) {
        return this.clienteService.create(createClienteDTO);
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
