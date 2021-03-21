package com.lab.laboratorio.business;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.lab.laboratorio.dto.response.TrabalhoResponseDTO;
import com.lab.laboratorio.enums.SituacaoTrabalho;
import com.lab.laboratorio.error.ResourceNotFoundException;
import com.lab.laboratorio.model.Trabalho;
import com.lab.laboratorio.repository.TrabalhoRepository;
import com.lab.laboratorio.utils.MontaDtoUtils;

@Component
public class TrabalhoBusiness {

	private TrabalhoRepository repository;

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
		verificaSeTrabExiste(trabalho.getId());		
		return repository.save(trabalho);
	}

	public void deleta(Long id) {
		verificaSeTrabExiste(id);
		repository.deleteById(id);
	}

	public Trabalho buscaPorId(Long id) {
		verificaSeTrabExiste(id);
		return repository.findById(id).get();
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
	
	private void verificaSeTrabExiste(Long id) {
		Optional<Trabalho> findById = repository.findById(id);
		if(!findById.isPresent())
			throw new ResourceNotFoundException("Nenhum trabalho encontrado para realizar a operação");
	}
}