package com.tijacque.clinicaMedica.model;

import com.tijacque.clinicaMedica.endereco.Endereco;
import com.tijacque.clinicaMedica.paciente.DadosPaciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="tb_pacientes")
@Entity(name="tb_paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;
    private String telefone;
    @Embedded //os campos no banco será na mesma table do medico e não uma table nova
    private DadosEndereco endereco;


    public Paciente(DadosPaciente dadosPaciente) {
        this.nome = dadosPaciente.nome();
        this.cpf = dadosPaciente.cpf();
        this.telefone = dadosPaciente.telefone();
        this.endereco = new DadosEndereco(dadosPaciente.endereco());
    }
}
