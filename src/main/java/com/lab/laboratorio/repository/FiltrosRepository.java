package com.lab.laboratorio.repository;

import com.lab.laboratorio.enums.SituacaoTrabalho;
import com.lab.laboratorio.model.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FiltrosRepository extends JpaRepository<Trabalho, Long> {

    @Query("select t from Trabalho t where dtEntrada between :dtEntrada and :dataParam ")
    List<Trabalho> buscaEntreDatasParam(@Param("dtEntrada") LocalDate dtEntrada, @Param("dataParam")LocalDate dataParam);

    List<Trabalho> findBySituacaoTrabalho(SituacaoTrabalho situacao);

    @Query("select t from Trabalho t where dtEntregaDesejada = :data ")
    List<Trabalho> buscaPorDataDeEntregaDesejada(LocalDate data);

    @Query("select t from Trabalho t where dtEntrada = :data ")
    List<Trabalho> buscaPorDataDeEntrada(LocalDate data);

}
