package com.lab.laboratorio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lab.laboratorio.business.TrabalhoBusiness;
import com.lab.laboratorio.dto.request.TrabalhoRequestDTO;
import com.lab.laboratorio.dto.response.TrabalhoResponseDTO;
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

		Trabalho trabalho = dtoParaEntidade(trabalhoRequestDTO, new Trabalho());
		return business.cadastra(trabalho);
	}

	public List<TrabalhoResponseDTO> busca() {
		List<Trabalho> trabalhos = business.busca();
		List<TrabalhoResponseDTO> trabalhoResponseDTO = new ArrayList<>();

		trabalhos.forEach(trab -> trabalhoResponseDTO.add(entidadeParaResponseDTO(trab)));

		return trabalhoResponseDTO;
	}

	public void altera(Long id, TrabalhoRequestDTO trabalhoRequestDTO) {

		Trabalho trabalho = business.buscaPorId(id);

		Trabalho alteraTrab = dtoParaEntidade(trabalhoRequestDTO, trabalho);

		business.altera(alteraTrab);
	}

	public void deleta(Long id) {
		business.deleta(id);
	}

	public TrabalhoResponseDTO buscaPorId(Long id) throws Exception {
		Trabalho trabalho = business.buscaPorId(id);
		return entidadeParaResponseDTO(trabalho);
	}

	private Trabalho dtoParaEntidade(TrabalhoRequestDTO trabalhoRequestDTO, Trabalho trabalho) {
		trabalho.setCidade(trabalhoRequestDTO.getCidade());
		trabalho.setCor(trabalhoRequestDTO.getCor());
		trabalho.setDentista(trabalhoRequestDTO.getDentista());
		trabalho.setMetal(trabalhoRequestDTO.getMetal());
		trabalho.setObservacoes(trabalhoRequestDTO.getObservacoes());
		trabalho.setPaciente(trabalhoRequestDTO.getPaciente());
		trabalho.setTrabalhoAExecutar(trabalhoRequestDTO.getTrabalhoAExecutar());

		return trabalho;
	}

	private TrabalhoResponseDTO entidadeParaResponseDTO(Trabalho trabalho) {
		return TrabalhoResponseDTO.builder().id(trabalho.getId()).cidade(trabalho.getCidade())
				.paciente(trabalho.getPaciente()).cor(trabalho.getCor()).dentista(trabalho.getDentista())
				.metal(trabalho.getMetal()).observacoes(trabalho.getObservacoes())
				.trabalhoAExecutar(trabalho.getTrabalhoAExecutar()).build();
	}
}