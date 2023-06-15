package com.example.MonitoringSpringDemoProject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateClienteDTO {

    @NotNull
    private Integer id;

    @NotBlank
    private String nome;

    @NotBlank
    private String telefone;

}
