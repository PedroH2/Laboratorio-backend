package com.lab.laboratorio.service;

import com.lab.laboratorio.business.FiltrosBusiness;
import com.lab.laboratorio.dto.response.TrabalhoResponseDTO;
import com.lab.laboratorio.enums.SituacaoTrabalho;
import com.lab.laboratorio.model.Trabalho;
import com.lab.laboratorio.utils.MontaDtoUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FiltrosService {

    FiltrosBusiness business;

    FiltrosService (FiltrosBusiness business){ this.business = business; }

    public TrabalhoResponseDTO buscaPorId(Long id) throws Exception {
        Trabalho trabalho = business.buscaPorId(id);
        return MontaDtoUtils.entidadeParaResponseDTO(trabalho);
    }


    public List<TrabalhoResponseDTO> buscaEntreDatas(LocalDate dtEntrada, LocalDate dataParam) {
        List<Trabalho> trabalhos = business.buscaEntreDatas(dtEntrada, dataParam);
        List<TrabalhoResponseDTO> trabalhosDTO = new ArrayList<>();
        trabalhos.forEach(trab -> trabalhosDTO.add(MontaDtoUtils.entidadeParaResponseDTO(trab)));

        return trabalhosDTO;
    }

    public List<TrabalhoResponseDTO> buscaPorSituacaoTrabalho(SituacaoTrabalho situacao) {
        List<Trabalho> trabalhos = business.buscaPorSituacaoTrabalho(situacao);
        List<TrabalhoResponseDTO> trabalhosDTO = new ArrayList<>();
        trabalhos.forEach(trab -> trabalhosDTO.add(MontaDtoUtils.entidadeParaResponseDTO(trab)));

        return trabalhosDTO;
    }

    public List<TrabalhoResponseDTO> buscaPorDataDeEntregaDesejada(LocalDate data) {
        List<Trabalho> trabalhos = business.buscaPorDataDeEntregaDesejada(data);
        List<TrabalhoResponseDTO> trabalhosDTO = new ArrayList<>();
        trabalhos.forEach(trab -> trabalhosDTO.add(MontaDtoUtils.entidadeParaResponseDTO(trab)));

        return trabalhosDTO;
    }


    public List<TrabalhoResponseDTO> buscaPorDataDeEntrada(LocalDate data) {
        List<Trabalho> trabalhos = business.buscaPorDataDeEntrada(data);
        List<TrabalhoResponseDTO> trabalhosDTO = new ArrayList<>();
        trabalhos.forEach(trab -> trabalhosDTO.add(MontaDtoUtils.entidadeParaResponseDTO(trab)));

        return trabalhosDTO;
    }
}
