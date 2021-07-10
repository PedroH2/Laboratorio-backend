package com.lab.laboratorio.repository;

import com.lab.laboratorio.model.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FaturamentoRepository extends JpaRepository<Trabalho, Long> {

    @Query("select t from Trabalho t where dtFinalizacao between :dtEntrada and :dataParametroFat ")
    List<Trabalho> buscaEntreDatas(@Param("dtEntrada") LocalDate dtEntrada, @Param("dataParametroFat")LocalDate dataParametroFat);
}