package com.example.MonitoringSpringDemoProject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateClienteDTO {

    @NotNull(message = "O Id não pode ser nulo")
    private  Integer id;

    @NotBlank(message = "O Nome não pode ser vazio")
    private  String nome;

    @Size(min = 11, max = 11, message = "O telefone deve ter 11 dígitos")
    @NotBlank(message = "O telefone não pode ser vazio")
    private String telefone;

}
