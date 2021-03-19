package com.lab.laboratorio.business;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.lab.laboratorio.utils.MontaDtoUtils;
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
		return MontaDtoUtils.entidadeParaResponseDTO(save);
	}

	public List<Trabalho> busca() {
		return repository.findAll();
	}

	public Trabalho altera(Trabalho trabalho) {
		if (repository.findById(trabalho.getId()).isPresent())
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

	public List<Trabalho> buscaPorSituacaoTrabalho(SituacaoTrabalho situacao) {
		return repository.findBySituacaoTrabalho(situacao);
	}

	public List<Trabalho> buscaPorDataDeEntrada(LocalDate data) {
		return repository.buscaPorDataDeEntrada(data);
	}

	public List<Trabalho> buscaPorDataDeEntregaDesejada(LocalDate data) {
		return repository.buscaPorDataDeEntregaDesejada(data);
	}

	public List<Trabalho> buscaEntreDatas(LocalDate dtEntrada, LocalDate dtEntregaDesejada) {
		return repository.buscaEntreDatas(dtEntrada, dtEntregaDesejada);
	}
}