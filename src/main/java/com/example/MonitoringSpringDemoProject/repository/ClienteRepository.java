package com.example.MonitoringSpringDemoProject.repository;

import com.example.MonitoringSpringDemoProject.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
