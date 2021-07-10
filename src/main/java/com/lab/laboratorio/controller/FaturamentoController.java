package com.lab.laboratorio.controller;

import com.lab.laboratorio.service.FaturamentoService;
import com.lab.laboratorio.utils.TotalFatObj;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("api/v1/trabalho/faturamento")
@Slf4j
public class FaturamentoController {

    private FaturamentoService service;

    public FaturamentoController(FaturamentoService service) {
        this.service = service;
    }

    @GetMapping("/buscaFaturamentoDeTrabsFinalizados/{dataParamInicial}/{dataParam}")
    public ResponseEntity<TotalFatObj> buscaFaturamentoDeTrabsFinalizados(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataParamInicial,
                                                                          @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataParam){
        log.debug("Iniciando processo de GET no endpoint: /buscaFaturamentoDeTrabsFinalizados/{}/{}");
        TotalFatObj valTotal = service.buscaFaturamentoTotalDeTrabsFinalizados(dataParamInicial, dataParam);
        log.debug("Finalizando processo de GET no endpoint: /buscaFaturamentoDeTrabsFinalizados/{}/{}" );
        return ResponseEntity.ok().body(valTotal);
    }
}
