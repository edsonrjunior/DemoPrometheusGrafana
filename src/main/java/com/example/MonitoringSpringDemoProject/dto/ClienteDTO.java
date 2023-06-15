package com.example.MonitoringSpringDemoProject.dto;

import com.example.MonitoringSpringDemoProject.domain.Cliente;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClienteDTO implements Serializable {


    private Integer id;

    private String nome;

    private String telefone;


    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
    }


}
