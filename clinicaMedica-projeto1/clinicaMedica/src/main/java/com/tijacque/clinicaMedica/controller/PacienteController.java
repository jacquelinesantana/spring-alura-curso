package com.tijacque.clinicaMedica.controller;

import ch.qos.logback.core.CoreConstants;
import com.tijacque.clinicaMedica.model.Paciente;
import com.tijacque.clinicaMedica.paciente.DadosPaciente;
import com.tijacque.clinicaMedica.repository.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("paciente")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosPaciente dadosPaciente){

        System.out.println(dadosPaciente);
    }
    @PostMapping("/cad")
    @Transactional
    public void cadastrarPac(@RequestBody @Valid DadosPaciente dadosPaciente){
        pacienteRepository.save(new Paciente(dadosPaciente));
    }

    @DeleteMapping("{id}")
    @Transactional
    public void deletar(@PathVariable Long id ){
        pacienteRepository.deleteById(id);

    }
}
