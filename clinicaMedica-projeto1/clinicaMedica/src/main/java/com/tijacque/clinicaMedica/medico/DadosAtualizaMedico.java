package com.tijacque.clinicaMedica.medico;

import com.tijacque.clinicaMedica.model.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco

) {

}
