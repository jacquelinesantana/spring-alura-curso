package com.tijacque.clinicaMedica.paciente;

import com.tijacque.clinicaMedica.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosPaciente(
        @NotBlank
        String nome,

        @NotBlank
        String cpf,

        String telefone,
        @Valid
                @NotNull
        Endereco endereco) {
}
