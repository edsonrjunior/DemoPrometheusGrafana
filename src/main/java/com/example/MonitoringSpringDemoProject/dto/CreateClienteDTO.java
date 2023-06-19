package com.example.MonitoringSpringDemoProject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateClienteDTO {

    private @NotNull Integer id;
    private @NotBlank String nome;
    private @NotBlank String telefone;

}
