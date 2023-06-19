package com.example.MonitoringSpringDemoProject.domain;

import com.example.MonitoringSpringDemoProject.dto.CreateClienteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "TB_CLIENTE")
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String telefone;

    public Cliente(CreateClienteDTO createClienteDTO) {
        this.setId(createClienteDTO.getId());
        this.setNome(createClienteDTO.getNome());
        this.setTelefone(createClienteDTO.getTelefone());
    }

}
