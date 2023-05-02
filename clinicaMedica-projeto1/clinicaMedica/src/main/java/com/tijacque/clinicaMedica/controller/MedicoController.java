package com.tijacque.clinicaMedica.controller;

import com.tijacque.clinicaMedica.medico.DadosAtualizaMedico;
import com.tijacque.clinicaMedica.medico.DadosCadastroMedico;
import com.tijacque.clinicaMedica.medico.DadosListagemMedico;
import com.tijacque.clinicaMedica.model.Medico;
import com.tijacque.clinicaMedica.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;
    @PostMapping
    public void cadastrar(@RequestBody String json){
        System.out.println(json);

    }

    @PostMapping("/link2")
    public void cadastrar(@RequestBody DadosCadastroMedico dados){

        System.out.println(dados);

    }

    @PostMapping("/cadastrarmed")
    public void cadastrarMed(@RequestBody @Valid DadosCadastroMedico dados){
        //forma de trabalhar sem o construtor
        //medicoRepository.save(new Medico(null, dados.nome(), dados.email(), dados.crm(), new DadosEndereco()));
        medicoRepository.save(new Medico(dados));
    }
    @GetMapping
    public List<Medico> listarTodosDados(){

        return medicoRepository.findAll();
    }

    @GetMapping("dados-medico-todos")
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 5, sort = {"nome"}) Pageable paginacao){
        //o retorno faz um map para trazer os dados do DTO DadosListagemMedico
        //Aqui ajustamos o método para retornar um Page com a paginação
        //para o return a gente incluiu a paginação no medoto findAll e deixamos o metodo menor pq não é mais necessário converter para lista
        return medicoRepository.findAll(paginacao).map(DadosListagemMedico::new);
        //
    }

    @GetMapping("dados-medico-ativos")
    public Page<DadosListagemMedico> listarAtivos(@PageableDefault(size = 5, sort = {"nome"}) Pageable paginacao){
        //o retorno faz um map para trazer os dados do DTO DadosListagemMedico
        //Aqui ajustamos o método para retornar um Page com a paginação
        //para o return a gente incluiu a paginação no medoto findAll e deixamos o metodo menor pq não é mais necessário converter para lista
        return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
        //
    }

    /*public List<DadosCadastroMedico> dadosCadastroMedicos (){
        return List<>=medicoRepository.findAll();
    }*/

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaMedico dados){
        var medico= medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        medicoRepository.deleteById(id);
    }

    @DeleteMapping("/inativar/{id}")
    @Transactional
    public void inativar(@PathVariable Long id){
        var medico= medicoRepository.getReferenceById(id);
        medico.inativar();
    }
}
