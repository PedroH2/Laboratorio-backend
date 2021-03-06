package com.lab.laboratorio.business;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.lab.laboratorio.utils.TrabalhoUtils;
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

	TrabalhoUtils trabalhoUtils;

	public TrabalhoResponseDTO cadastra(Trabalho trabalho) {
		Trabalho save = repository.save(trabalho);
		return MontaDtoUtils.entidadeParaResponseDTO(save);
	}

	public List<Trabalho> busca() {
		return repository.findAll();
	}

	public Trabalho altera(Trabalho trabalho) {
		trabalhoUtils.verificaSeTrabExiste(trabalho.getId());
		return repository.save(trabalho);
	}

	public void deleta(Long id) {
		trabalhoUtils.verificaSeTrabExiste(id);
		repository.deleteById(id);
	}

	public Trabalho buscaPorId(Long id) {
		trabalhoUtils.verificaSeTrabExiste(id);
		return repository.findById(id).get();
	}
}