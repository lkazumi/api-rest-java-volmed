package com.estudo.volmed.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.volmed.controller.DadosListagemMedico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{

    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
    
}
