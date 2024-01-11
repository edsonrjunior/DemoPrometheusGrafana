package com.example.MonitoringSpringDemoProject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateClienteDTO {

    //Classe para fazer as validações dos dados informados na requisição

    @NotNull(message = "O Id não pode ser nulo")
    private Integer id;

    @NotBlank(message = "O Nome não pode ser vazio")
    private String nome;

    @NotBlank(message = "O Sobrenome não pode ser vazio")
    private String sobrenome;

    // @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "A data de nascimento deve estar no formato yyyy-MM-dd")
    private LocalDate dataNascimento;

    @Size(min = 11, max = 11, message = "O telefone deve ter 11 dígitos")
    @NotBlank(message = "O telefone não pode ser vazio")
    private String telefone;
}
