package com.lab.laboratorio.business;

import com.lab.laboratorio.model.Trabalho;
import com.lab.laboratorio.repository.FaturamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class FaturamentoBusiness {

    public FaturamentoRepository repository;

    public FaturamentoBusiness(FaturamentoRepository repository) {
        this.repository = repository;
    }

    public List<Trabalho> buscaFaturamentoDeTrabsFinalizados(LocalDate dataEntrada, LocalDate dataParametroFat) {
        return repository.buscaEntreDatas(dataEntrada, dataParametroFat);
    }
}
