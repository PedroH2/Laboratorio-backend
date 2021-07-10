package com.lab.laboratorio.utils;

import com.lab.laboratorio.error.ResourceNotFoundException;
import com.lab.laboratorio.model.Trabalho;
import com.lab.laboratorio.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TrabalhoUtils {

    @Autowired
    TrabalhoRepository repository;

    public void verificaSeTrabExiste(Long id) {
        Optional<Trabalho> findById = repository.findById(id);
        if(!findById.isPresent())
            throw new ResourceNotFoundException("Nenhum trabalho encontrado para realizar a operação");
    }
}
