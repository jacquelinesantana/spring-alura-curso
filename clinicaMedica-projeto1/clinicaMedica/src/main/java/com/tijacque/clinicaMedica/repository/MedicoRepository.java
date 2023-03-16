package com.tijacque.clinicaMedica.repository;


import com.tijacque.clinicaMedica.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicoRepository extends JpaRepository <Medico, Long> {
}