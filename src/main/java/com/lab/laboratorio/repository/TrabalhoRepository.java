package com.lab.laboratorio.repository;

import com.lab.laboratorio.enums.SituacaoTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lab.laboratorio.model.Trabalho;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {

}
