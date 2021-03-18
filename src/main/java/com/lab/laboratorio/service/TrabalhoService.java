package com.lab.laboratorio.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.lab.laboratorio.utils.MontaDtoUtils;
import org.springframework.stereotype.Component;

import com.lab.laboratorio.business.TrabalhoBusiness;
import com.lab.laboratorio.dto.request.TrabalhoRequestDTO;
import com.lab.laboratorio.dto.response.TrabalhoResponseDTO;
import com.lab.laboratorio.enums.SituacaoTrabalho;
import com.lab.laboratorio.model.Trabalho;
import com.lab.laboratorio.repository.TrabalhoRepository;

@Component
public class TrabalhoService {

	TrabalhoBusiness business;

	TrabalhoRepository repository;

	public TrabalhoService(TrabalhoBusiness business, TrabalhoRepository repository) {
		this.business = business;
		this.repository = repository;
	}

	public TrabalhoResponseDTO cadastra(TrabalhoRequestDTO trabalhoRequestDTO) {
		Trabalho trabalho = MontaDtoUtils.dtoParaEntidade(trabalhoRequestDTO, new Trabalho());
		return business.cadastra(trabalho);
	}

	public List<TrabalhoResponseDTO> busca() {
		List<Trabalho> trabalhos = business.busca();
		List<TrabalhoResponseDTO> trabalhoResponseDTO = new ArrayList<>();
		trabalhos.forEach(trab -> trabalhoResponseDTO.add(MontaDtoUtils.entidadeParaResponseDTO(trab)));

		return trabalhoResponseDTO;
	}

	public void altera(Long id, TrabalhoRequestDTO trabalhoRequestDTO) {
		Trabalho trabalho = business.buscaPorId(id);
		Trabalho alteraTrab = MontaDtoUtils.dtoParaEntidade(trabalhoRequestDTO, trabalho);
		business.altera(alteraTrab);
	}

	public void deleta(Long id) {
		business.deleta(id);
	}

	public TrabalhoResponseDTO buscaPorId(Long id) throws Exception {
		Trabalho trabalho = business.buscaPorId(id);
		return MontaDtoUtils.entidadeParaResponseDTO(trabalho);
	}

	public TrabalhoResponseDTO alteraSituacao(Long id, SituacaoTrabalho situacao) {
		Trabalho trabalhoAlterado = business.buscaPorId(id);
		trabalhoAlterado.setSituacaoTrabalho(situacao);
		business.altera(trabalhoAlterado);
		return MontaDtoUtils.entidadeParaResponseDTO(trabalhoAlterado);
	}

	public List<TrabalhoResponseDTO> buscaPorSituacaoTrabalho(SituacaoTrabalho situacao) {
		List<Trabalho> trabalhos = business.buscaPorSituacaoTrabalho(situacao);
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

	public List<TrabalhoResponseDTO> buscaPorDataDeEntregaDesejada(LocalDate data) {
		List<Trabalho> trabalhos = business.buscaPorDataDeEntregaDesejada(data);
		List<TrabalhoResponseDTO> trabalhosDTO = new ArrayList<>();
		trabalhos.forEach(trab -> trabalhosDTO.add(MontaDtoUtils.entidadeParaResponseDTO(trab)));

		return trabalhosDTO;
	}
}