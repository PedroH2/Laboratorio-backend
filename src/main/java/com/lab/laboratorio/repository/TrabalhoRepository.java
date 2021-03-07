package com.lab.laboratorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.laboratorio.model.Trabalho;

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {
}
