package com.tijacque.clinicaMedica.medico;

import com.tijacque.clinicaMedica.model.Medico;

public record DadosListagemMedico(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {
    public DadosListagemMedico(Medico medico){
        //método construtor para permitir consumo dos dados na controller
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
