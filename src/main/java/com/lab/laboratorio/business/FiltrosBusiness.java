package com.lab.laboratorio.business;

import com.lab.laboratorio.enums.SituacaoTrabalho;
import com.lab.laboratorio.model.Trabalho;
import com.lab.laboratorio.repository.FiltrosRepository;
import com.lab.laboratorio.utils.TrabalhoUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class FiltrosBusiness {

    FiltrosRepository repository;

    FiltrosBusiness (FiltrosRepository repository){this.repository = repository;}

    TrabalhoUtils trabalhoUtils;

    public Trabalho buscaPorId(Long id) {
        trabalhoUtils.verificaSeTrabExiste(id);
        return repository.findById(id).get();
    }


    public List<Trabalho> buscaEntreDatas(LocalDate dtEntrada, LocalDate dataParam) {
        return repository.buscaEntreDatasParam(dtEntrada, dataParam);
    }

    public List<Trabalho> buscaPorSituacaoTrabalho(SituacaoTrabalho situacao) {
        return repository.findBySituacaoTrabalho(situacao);
    }

    public List<Trabalho> buscaPorDataDeEntregaDesejada(LocalDate data) {
        return repository.buscaPorDataDeEntregaDesejada(data);
    }

    public List<Trabalho> buscaPorDataDeEntrada(LocalDate data) {
        return repository.buscaPorDataDeEntrada(data);
    }
}
