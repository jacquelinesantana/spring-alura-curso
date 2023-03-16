package com.tijacque.clinicaMedica.model;

import com.tijacque.clinicaMedica.endereco.Endereco;
import com.tijacque.clinicaMedica.medico.DadosCadastroMedico;
import com.tijacque.clinicaMedica.medico.Especialidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="tb_medicos")
@Entity(name="tb_medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String crm;
    private String email;

    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded //os campos no banco será na mesma table do medico e não uma table nova
    private DadosEndereco endereco;

    public Medico(DadosCadastroMedico dados){
        this.crm = dados.crm();
        this.nome = dados.nome();
        this.email = dados.email();
        this.especialidade = dados.especialidade();
        this.endereco = new DadosEndereco(dados.endereco());
        this.telefone = dados.telefone();

    }
}
