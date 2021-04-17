package com.lab.laboratorio.utils;

import com.lab.laboratorio.dto.request.TrabalhoRequestDTO;
import com.lab.laboratorio.dto.response.TrabalhoResponseDTO;
import com.lab.laboratorio.model.Trabalho;

import java.time.LocalDate;

public class MontaDtoUtils {

    public static Trabalho dtoParaEntidade(TrabalhoRequestDTO trabalhoRequestDTO, Trabalho trabalho) {
        trabalho.setCidade(trabalhoRequestDTO.getCidade());
        trabalho.setCor(trabalhoRequestDTO.getCor());
        trabalho.setDentista(trabalhoRequestDTO.getDentista());
        trabalho.setMetal(trabalhoRequestDTO.getMetal());
        trabalho.setDtEntrada(LocalDate.now());
        trabalho.setDtEntregaDesejada(trabalhoRequestDTO.getDtEntregaDesejada());
        trabalho.setObservacoes(trabalhoRequestDTO.getObservacoes());
        trabalho.setPaciente(trabalhoRequestDTO.getPaciente());
        trabalho.setTrabalhoAExecutar(trabalhoRequestDTO.getTrabalhoAExecutar());
        trabalho.setSituacaoTrabalho(trabalhoRequestDTO.getSituacaoTrabalho());
        trabalho.setValorTrabalho(trabalhoRequestDTO.getValorTrabalho());
        trabalho.setDtFinalizacao(trabalhoRequestDTO.getDtFinalizacao());
        trabalho.setColaboradorResponsavel(trabalhoRequestDTO.getColaboradorResponsavel());
        return trabalho;
    }

    public static TrabalhoResponseDTO entidadeParaResponseDTO(Trabalho trabalho) {
        return TrabalhoResponseDTO.builder()
                .id(trabalho.getId())
                .cidade(trabalho.getCidade())
                .paciente(trabalho.getPaciente())
                .cor(trabalho.getCor())
                .dentista(trabalho.getDentista())
                .metal(trabalho.getMetal())
                .dtEntrada(trabalho.getDtEntrada())
                .dtEntregaDesejada(trabalho.getDtEntregaDesejada())
                .observacoes(trabalho.getObservacoes())
                .trabalhoAExecutar(trabalho.getTrabalhoAExecutar())
                .situacaoTrabalho(trabalho.getSituacaoTrabalho())
                .valorTrabalho(trabalho.getValorTrabalho())
                .dtFinalizacao(trabalho.getDtFinalizacao())
                .colaboradorResponsavel(trabalho.getColaboradorResponsavel())
                .build();
    }
}
