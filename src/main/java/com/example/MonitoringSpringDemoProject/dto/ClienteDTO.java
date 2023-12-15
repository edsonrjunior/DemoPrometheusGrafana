package com.example.MonitoringSpringDemoProject.dto;

import com.example.MonitoringSpringDemoProject.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable {

    //Classe DTO

    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private String telefone;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.dataNascimento = cliente.getDataNascimento();
        this.telefone = cliente.getTelefone();
    }


}
