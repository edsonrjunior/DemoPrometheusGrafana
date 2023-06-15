package com.example.MonitoringSpringDemoProject.domain;

import com.example.MonitoringSpringDemoProject.dto.CreateClienteDTO;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "TB_CLIENTE")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String telefone;

    public Cliente(CreateClienteDTO createClienteDTO) {
        this.setId(createClienteDTO.getId());;
        this.setNome(createClienteDTO.getNome());
        this.setTelefone(createClienteDTO.getTelefone());
    }


}
