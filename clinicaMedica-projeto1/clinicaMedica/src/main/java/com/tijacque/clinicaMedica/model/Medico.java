package com.tijacque.clinicaMedica.model;

import com.tijacque.clinicaMedica.endereco.Endereco;
import com.tijacque.clinicaMedica.medico.DadosAtualizaMedico;
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


    private Boolean ativo;

    public Medico(DadosCadastroMedico dados){
        this.ativo = true;
        this.crm = dados.crm();
        this.nome = dados.nome();
        this.email = dados.email();
        this.especialidade = dados.especialidade();
        this.endereco = new DadosEndereco(dados.endereco());
        this.telefone = dados.telefone();

    }

    public void atualizarInformacoes(DadosAtualizaMedico dados) {
        if(dados.nome() != null)        this.nome = dados.nome();
        if(dados.telefone() != null)        this.telefone = dados.telefone();
        if(dados.endereco() != null)       this.endereco.atualizarInformacoes(dados.endereco());
    }

    public void inativar() {
        this.ativo = false;
    }
}
