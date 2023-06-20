package com.example.MonitoringSpringDemoProject.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateClienteDTO {


    private @NotNull(message = "O Id não pode ser nulo") Integer id;
    private @NotBlank(message = "O Nome não pode ser vazio") String nome;
    private @NotBlank(message = "O telefone não pode ser vazio") String telefone;

}
