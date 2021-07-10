package com.lab.laboratorio.controller;

import com.lab.laboratorio.dto.response.ResponseDTO;
import com.lab.laboratorio.dto.response.TrabalhoResponseDTO;
import com.lab.laboratorio.enums.SituacaoTrabalho;
import com.lab.laboratorio.service.FiltrosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/v1/trabalho/filtros")
public class FiltrosController {

    FiltrosService service;

    FiltrosController (FiltrosService service){ this.service = service; };

    @GetMapping("/busca/{id}")
    public ResponseEntity<ResponseDTO<TrabalhoResponseDTO>> buscaPorId(@PathVariable Long id) throws Exception{
        log.debug("Iniciando processo de GET no endpoint: /api/v1/trabalho/busca/id");
        TrabalhoResponseDTO trabalhoResponseDTO = service.buscaPorId(id);
        log.debug("Finalizando processo de GET no endpoint: /api/v1/trabalho/busca/id");
        return ResponseEntity.ok(new ResponseDTO<>(trabalhoResponseDTO));
    }

    @GetMapping("/buscaEntreDatas/{dataEntrada}/{dataParam}")
    public ResponseEntity<ResponseDTO<List<TrabalhoResponseDTO>>> buscaEntreDatas(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataEntrada,
                                                                                  @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataParam){
        log.debug("Iniciando processo de GET no endpoint: /api/v1/trabalho/buscaPorDataDeEntrada/{}");
        List<TrabalhoResponseDTO> dto = service.buscaEntreDatas(dataEntrada, dataParam);
        log.debug("Finalizando processo de GET no endpoint: /api/v1/trabalho/buscaPorDataDeEntrada/{}" );
        return ResponseEntity.ok(new ResponseDTO<>(dto));
    }

    @GetMapping("/buscaPorSituacaoTrabalho/{situacao}")
    public ResponseEntity<ResponseDTO<List<TrabalhoResponseDTO>>> buscaPorSituacaoTrabalho(@PathVariable SituacaoTrabalho situacao){
        List<TrabalhoResponseDTO> dto = service.buscaPorSituacaoTrabalho(situacao);
        log.debug("Finalizando processo de GET no endpoint: /api/v1/trabalho/busacPorSituacaoTrabalho/{}", situacao);
        return ResponseEntity.ok(new ResponseDTO<>(dto));
    }

    @GetMapping("/buscaPorDataDeEntregaDesejada/{data}")
    public ResponseEntity<ResponseDTO<List<TrabalhoResponseDTO>>> buscaPorDataDeEntregaDesejada(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate data){
        log.debug("Iniciando processo de GET no endpoint: /api/v1/trabalho/buscaPorDataDeEntrada/{}", data);
        List<TrabalhoResponseDTO> dto = service.buscaPorDataDeEntregaDesejada(data);
        log.debug("Finalizando processo de GET no endpoint: /api/v1/trabalho/buscaPorDataDeEntrada/{}", data);
        return ResponseEntity.ok(new ResponseDTO<>(dto));
    }

    @GetMapping("/buscaPorDataDeEntrada/{data}")
    public ResponseEntity<ResponseDTO<List<TrabalhoResponseDTO>>> buscaPorDataDeEntrada(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate data){
        log.debug("Iniciando processo de GET no endpoint: /api/v1/trabalho/buscaPorDataDeEntrada/{}", data);
        List<TrabalhoResponseDTO> dto = service.buscaPorDataDeEntrada(data);
        log.debug("Finalizando processo de GET no endpoint: /api/v1/trabalho/buscaPorDataDeEntrada/{}", data);
        return ResponseEntity.ok(new ResponseDTO<>(dto));
    }

}
