package com.tijacque.clinicaMedica.repository;

import com.tijacque.clinicaMedica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
