package com.lab.laboratorio.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.lab.laboratorio.dto.response.TrabalhoResponseDTO;
import com.lab.laboratorio.enums.SituacaoTrabalho;
import com.lab.laboratorio.model.Trabalho;
import com.lab.laboratorio.repository.TrabalhoRepository;
import com.lab.laboratorio.service.TrabalhoService;

@Component
public class TrabalhoBusiness {

	TrabalhoRepository repository;

	TrabalhoService service;

	public TrabalhoBusiness(TrabalhoRepository repository) {
		this.repository = repository;
	}

	public TrabalhoResponseDTO cadastra(Trabalho trabalho) {
		Trabalho save = repository.save(trabalho);
		return entidadeParaResponseDTO(save);
	}

	public List<Trabalho> busca() {
		return repository.findAll();
	}

	public Trabalho altera(Trabalho trabalho) {
		if (repository.findById(trabalho.getId()) != null)
			return repository.save(trabalho);
		return null;
	}

	public void deleta(Long id) {
		Optional<Trabalho> findById = repository.findById(id);
		if (findById.isPresent())
			repository.deleteById(findById.get().getId());
	}

	public Trabalho buscaPorId(Long id) {
		Trabalho trab = repository.findById(id).get();
		return trab;
	}

	private TrabalhoResponseDTO entidadeParaResponseDTO(Trabalho trabalho) {
		return TrabalhoResponseDTO.builder()
				.id(trabalho.getId())
				.cidade(trabalho.getCidade())
				.paciente(trabalho.getPaciente())
				.cor(trabalho.getCor())
				.dtEntrada(trabalho.getDtEntrada())
				.dtEntregaDesejada(trabalho.getDtEntregaDesejada())
				.metal(trabalho.getMetal())
				.observacoes(trabalho.getObservacoes())
				.trabalhoAExecutar(trabalho.getTrabalhoAExecutar())
				.situacaoTrabalho(trabalho.getSituacaoTrabalho())
				.build();
	}
}