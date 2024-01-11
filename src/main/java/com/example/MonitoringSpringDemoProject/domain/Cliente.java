package com.example.MonitoringSpringDemoProject.domain;

import com.example.MonitoringSpringDemoProject.dto.CreateClienteDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


@Entity
@Data
@Table(name = "TB_CLIENTE")
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    //Classe que representa a entidade no banco de dados

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String sobrenome;

    @Column
    private LocalDate dataNascimento;

    @Column
    private String telefone;

    public Cliente(CreateClienteDTO createClienteDTO) {
        this.setId(createClienteDTO.getId());
        this.setNome(createClienteDTO.getNome());
        this.setSobrenome(createClienteDTO.getSobrenome());
        this.setDataNascimento(createClienteDTO.getDataNascimento());
        this.setTelefone(createClienteDTO.getTelefone());
    }
}
