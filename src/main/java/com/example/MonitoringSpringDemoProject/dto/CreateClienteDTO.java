package com.example.MonitoringSpringDemoProject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateClienteDTO {


    private @NotNull(message = "O Id não pode ser nulo") Integer id;
    private @NotBlank(message = "O Nome não pode ser vazio") String nome;

    @Size(min = 11, max = 11, message = "O telefone deve ter 11 dígitos")
    private @NotBlank(message = "O telefone não pode ser vazio") String telefone;

}
