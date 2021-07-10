package com.lab.laboratorio.service;

import com.lab.laboratorio.business.FaturamentoBusiness;
import com.lab.laboratorio.model.Trabalho;
import com.lab.laboratorio.utils.TotalFatObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FaturamentoService {

    private FaturamentoBusiness business;

    public FaturamentoService(FaturamentoBusiness business) {
        this.business = business;
    }

    public TotalFatObj buscaFaturamentoTotalDeTrabsFinalizados(LocalDate dataParamInicial, LocalDate dataParametroFat) {
        List<Trabalho> trabalhos = business.buscaFaturamentoDeTrabsFinalizados(dataParamInicial, dataParametroFat);
        Long somaFatTrab = 0l;
        for (Trabalho trab : trabalhos) {
            somaFatTrab += trab.getValorTrabalho().longValue();
        }
        TotalFatObj obj = new TotalFatObj(trabalhos.size(), dataParametroFat.getDayOfYear() - dataParamInicial.getDayOfYear(),
                somaFatTrab,dataParamInicial,dataParametroFat);
        return obj;
    }
}