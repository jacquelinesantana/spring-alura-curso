package com.tijacque.clinicaMedica.medico;

import com.tijacque.clinicaMedica.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(
        @NotBlank
        String nome,
        @NotBlank @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank @Pattern(regexp = "\\d{4,6}")//de quatro a 6 digitos
        String crm,
        @NotNull
        Especialidade especialidade,

        @NotNull @Valid
        Endereco endereco) {

}
