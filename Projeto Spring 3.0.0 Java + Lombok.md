# Projeto Spring 3.0.0 Java + Lombok

O objetivo desse projeto é criar uma api explorando os recursos do Spring 3.0.0 e Lombok, essa api será uma clinica médica com cadastro de pacientes e médicos.

## Criando o projeto no start.spring.io

Como escolher/ preencher o formulário do Start.apring.io?

- **Project** - escolher o Maven
- **Language** - escolher Java
- **Sprint Boot** - versão 3.0.0
- **Group** - informar domínio da empresa 
- **Artifact** - nome do projeto
- **Name** - podemos repetir nome do projeto
- **Description** - descrição do projeto que esta sendo trabalhado
- **Package name** - nome do pacote principal/ raiz para o projeto
- **Packaging** - jar
- **Java** - 17 ou 19
- **Dependencies** - selecionar as dependências necessárias para o projeto no caso vou incluir: 
  - **Spring Boot Dev Tools** - nos ajuda no desenvolvimento permitindo que o projeto seja automaticamente reiniciado no servidor local, sempre que salvarmos alguma alteração.
  - **Spring Web** - para uma aplicação Restfull e utilizando o modelo MVC
  - **Lombok** - reduz a escrita do código (exemplo Getteres and Setteres e construtores) utilizando-se de anotações
  - **Spring Data JPA** - persiste dados, convertendo modelos do projeto(classes entity) para modelo de domínio(tabelas no banco)
  - **MYSQL Driver** - permite conexão e uso de banco de dados Mysql
  - **Validation** - permite o uso de anotações que vão realizar validações para os dados que serão aqui trabalhado
- Clicar no botão `Generate` para gerar o projeto que poderá ser importado em sua **IDE**

## Abrindo o projeto no Intellij

Para abrir o projeto extraído no site Start.spring.io no intellij vamos seguir os passos a seguir:

1. clique no menu **File**;
2. clique na opção **Open**...
3. selecionar o projeto na pasta onde este foi descompactado o arquivo zip;
4. clique no botão **OK**
5. na janela de confirmação para abrir o projeto vamos clicar em **Trust Project**
6. selecionar a opção **This Window**, para abrir o projeto nessa mesma janela do Intellij ou **New Window** para abrir em uma janela nova;
7. clique no item lateral **Maven**
8. clique no nome do seu projeto e verifique na barra de status se ainda esta sendo feito o download das dependências do seu projeto ou se já temos todas no item Dependencies;
9. Caso necessário você pode dar uma opção reflesh para recarregar os arquivos do Maven do seu projeto, mas isso apenas se tiver algum problema notando a falta de dependências;

## Entendendo a estrutura do projeto

Quando seu projeto for aberto na IDE, poderá explorar a sua estrutura para melhor compreender os próximos passos.

Nessa lateral da sua IDE você deve estar visualizando seu projeto, você pode clicar na seta lateral ao nome do projeto para abrir a estrutura do mesmo ou fechar.

Abrindo o diretório do `projeto/ src/ main/ java/ dominio.nomedoprojeto` vamos ter acesso a um arquivo chamado: `NomeDoProjeto.Application` - esse é o arquivo responsável por executar seu projeto, é o arquivo com o `Main` e neste não iremos realizar mudanças.

Já no diretório `resources`, vamos encontrar o arquivo `application.properties` que é onde vamos incluir as configurações para conexão com banco de dados mais adiante nesse projeto.

No diretório `src/ test` ficam os arquivos para configurações de testes automatizados da aplicação. 

Voltando para a raiz do projeto, temos o arquivo `pom.xml` com as configurações de todas as dependências que incluímos no projeto e também a versão do Java e do Springboot que estamos fazendo uso para o mesmo. Caso necessário ainda podemos mudar versão ou adicionar dependências diretamente nesse arquivo.

## Executando a aplicação

Já podemos executar a aplicação para pela primeira vez, então siga os processos a seguir para ver sua aplicação executando.

1. clique com botão direito do mouse sobre o arquivo `.application` de sua aplicação, aquele que possui o método main

2. clique na opção `Run NomeDoProjeto`

3. de o aceite para a execução da dependência Lombok clicando no botão `enable`

4. se tudo ocorrer bem, você terá no console informações como data-hora, código info : serviço iniciado. Conforme imagem a seguir.

5. abra o navegador e digite o endereço http://localhost:8080/ endereço da sua aplicação enquanto ela estiver sendo executada localmente pela sua IDE.

6. mensagem esperada é: "Whitelabel Error Page

   This application has no explicit mapping for /error, so you are seeing this as a fallback.", pois não configuramos nenhuma saída para essa aplicação.

## Criando um novo controlador de rotas

Ao realizarmos o teste acessando o endereço da api pelo navegador, recebemos como retorno uma mensagem indicando erro ao tentar localizar a pagina pois a mesma não havia sido mapeada pela aplicação, para resolver isso vamos agora trabalhar a controladora de rotas da aplicação, definindo assim endereços acessíveis dentro da mesma.

Para manter a organização dentro da api, vamos nos atentar em criar um pacote para essa finalidade, receber as classes responsáveis pelo controle de rotas/ endereços dentro da aplicação.

1. clique com botão direito do mouse, sobre o pacote onde esta o seu método main, aquele que tem nomeApplication;
2. vá até a opção `New` -> `Package`
3. digite o nome `controller` e pressione o `Enter` do seu teclado.
4. clique com botão direito sobre o pacote `controller`
5. vá na opção `New` -> `Java Class`
6. digite o nome da classe como OlaController e digite o `Enter` do seu teclado
7. confira no novo arquivo o endereço do pacote, ele deve terminar com a palavra controller;

Agora temos o arquivo, mas vamos trabalhar as programações para que o mesmo se comporte como uma controladora de endereços/ rotas.

1. Na linha acima do public class OlaController{} vamos adicionar a seguinte anotação: @RestController que é a anotação responsável em "comunicar ao Springboot" que esta é uma classe controladora de rotas
2. ainda na linha acima do public class OlaController{} vamos adicionar também a anotação @RequestMapping("/hello") que é a anotação responsável em falar qual é a rota/ endereço responsável por entregar as requisições escritas nesse arquivo. Então toda requisição desse arquivo vai iniciar com http://localhost:8080/hello, note que /hello é o dado que incluímos dentro dos parentes na anotação RequestMapping.
3. Note que também foi necessário importar as dependências que tratam essas anotações para que as mesmas funcionem, a sua ide provavelmente já vai sugerir esses imports, você pode incluir os mesmos ou permitir.

## Ajustar o Intelij para atualizar o projeto sem precisar reiniciar o mesmo

1. `CTRL` + `ALT` + `S`
2. Na tela de `settings`
3. Menu lateral opção `Build, Execution, Deployment`
4. opção `Compiler`
5. marcar a opção `Build project Automatically`
6. clicar no botão `apply`
7. Novamente no Menu lateral -> opção`Advanced Settings`
8. marcar a opção `Compiler` -> `Allow auto-make to start even if developed application is currently running`
9.  clicar na opção `apply`

## Json

JavaScript Object Notation é um formato utilizado para representar informações, lembrando que também temos o XML e CSV.

Exemplo:

```css
{
    “nome” : “Mochila”,
    “preco” : 89.90,
    “descricao” : “Mochila para notebooks de até 17 polegadas”
}
```

## CORS

Cross- Origin Resource Sharing (compartilhamento de recursos com origens diferentes), é um mecanismo do cabeçalho HTTP que permite que uma aplicação Web seja executada em uma origem e acesse recursos de uma origem diferente. Ou seja, quando não configuramos os CORS, ele assume que ninguém de origem diferente do seu próprio servidor pode acessar os recursos da aplicação, mas podemos ajustar permitindo que uma determinada origem acesse ou que qualquer um acesse.

Como ficaria essa configuração:

Permitir a uma origem em específico o acesso:

`Access-Control-Allow-Origin: http://localhost:3000`

Permitir a toda e quaisquer origem o acesso:

`Access-Control-Allow-Origin: *`

Origem aplicado ao controller do projeto:

```typescript
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}
```

## Escrevendo método Post

Aqui vamos escrever progressivamente o código até o ponto de ter esse método composto e atendendo a sua finalizada, assim como termos o método bem compreendido. Vamos iniciar a escrita do método como void(sem retorno), apenas como forma de entender o mesmo, aqui vamos receber o objeto Json e vamos exibir no console o mesmo.

```
@PostMapping
public void cadastrar(@RequestBody String json){
    System.out.println(json);

}
```

Para o método acima podemos notar 2 pontos:

1. **@PostMapping** - indica que o método escrito atende ao verbo Post no momento que for consumido esse serviço. Verbo Post é utilizado para cadastros, então entende-se que o método deve receber um cadastro.
2. **@RequestBody** - indica que o método deve receber dados do body da requisição.  Essa notação é fundamental para podermos receber os dados de um cadastro.

Objeto Json da requisição acima:

```perl
{
"nome": "Jacqueline",
"email": "ti.jacque@gmail.com",
"crm": "123456",
"especialidade": "Pediatria",
"endereco": {
    "logradouro": "rua ...",
    "bairro": "bairro",
    "cep": "12345678",
    "cidade": "Guarulhos",
    "uf": "SP",
    "numero": "1",
    "complemento": "complemento"
    }
}
```

### Classe `record` - *DTO - Data Transfer Object* ("Objeto de transferência de dados")

O Record é um recurso que permite representar uma classe imutável,  com atributos, construtor e métodos de leitura, de maneira simples.

O DTO vai ter alguns papéis importantes em um projeto, já que pode evitar que um parâmetro seja passado, de forma mal intencionada pelo consumidor da api. Exemplo: 

*Uma api tem níveis de acesso e foi definido pelo dev backend que o atributo admin informe true para usuários com nível de acesso Administradore, ou false para os usuários comuns. Para isso foi criada a Model dos usuários com o atributo admin = false. Na controller por não ter uso de um DTO o usuário vai afetar diretamente esses atributos do usuário e pode intencionalmente ou não, fazer a seguinte requisição:*

requisição tipo: POST

```graphql
{
    “nome” : “Jacqueline”,
    “email” : “email@email.com”,
    “admin” : true
}
```



*Se não tivermos a proteção devida a api, pode sim simplesmente persistir no banco esse usuário já com o atributo admin setado como true, e esse usuário ter poderes de um administrador nesse sistema.*

Documentação oficial: https://docs.oracle.com/en/java/javase/16/language/records.html

Aqui vamos realizar alguns ajustes para passar nossos dados de forma mais assertiva no projeto 

Para tal vamos criar um arquivo Record com os dados do cadastro do médico

1. vamos reescrever o método anterior que agora ficará assim:

```
@PostMapping
public void cadastrar(@RequestBody DadosCadastroMedico dados){
    System.out.println(dados);

}
```

2. agora precisamos criar o DadosCadastroMedico que será feito da seguinte maneira:
   1. clique no nome da classe que esta com erro
   2. alt + ENTER
   3. escolher a opção Create Record
   4. trocar o nome do pacote para Medico
   5. dentro do Record vamos incluir os dados do médico

```
public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco){

}
```

3. definir o enum especialidade:
   1. clicar em especialidade que esta nesse momento com erro
   2. ir na opção criar enum Especialidade dentro do pacote medico
   3. declarar as opções de especialidades

```
public enum Especialidade{
	ORTOPEDIA,
	CARDIOLOGIA,
	GINECOLOGIA,
	DERMATOLOGIA;
}
```

4. agora vamos ajustar o Endereço que também estará acusando erro, criando um novo Record para o mesmo dentro do pacote endereço.
   1. clique no nome da classe que esta com erro
   2. alt + ENTER
   3. escolher a opção Create Record
   4. trocar o nome do pacote para endereço
   5. dentro do Record vamos incluir os dados do endereço

```
public record DadosEndereco(String logradouro, String bairro, String cep, String cidade, String uf, String complemento, String numero){

}
```

Exemplo do Json enviado:

```
{
	"nome": "Jacqueline",
	"email": "ti.jacque@gmail.com",
	"crm": "123456",
	"especialidade":"CARDIOLOGia",
	"endereco":{
		"rua": "rua Antonio Jaime Sapata ",
		"bairro": "jd Leda",
		"cep": "07060-010"
	}

}
```

## Persistir dados no Mysql

Para persistir os dados em banco de dados, precisamos incluir as devidas dependências. Podemos ainda utilizar do **Spring Initializr** para esse apoio evitando digitar incorretamente os dados.

As dependências necessárias são as seguintes:

- Validation (I/O)  - para validar os dados formato de dados
- Mysql Driver (SQL) - dar apoio para o banco de dados
- Spring Data JPA (SQL) - criar as queries
- Flyway Migration (SQL) - ferramentas para migrations

No Spring Initializr você vai incluir essas dependências apenas, sem se preocupar em informar dados do projeto. Após isso apenas clique no botão explorar para visualizar o arquivo Pom.xml e copiar as dependências que serão as informadas acima.



```xml
<dependency>      <groupId>org.springframework.boot</groupId>      <artifactId>spring-boot-starter-data-jpa</artifactId>    </dependency>    <dependency>      <groupId>org.springframework.boot</groupId>      <artifactId>spring-boot-starter-validation</artifactId>    </dependency>    <dependency>      <groupId>org.flywaydb</groupId>      <artifactId>flyway-core</artifactId>    </dependency>    <dependency>      <groupId>org.flywaydb</groupId>      <artifactId>flyway-mysql</artifactId>    </dependency>
    <dependency>      <groupId>com.mysql</groupId>      <artifactId>mysql-connector-j</artifactId>      <scope>runtime</scope>    </dependency>
```

> Após incluir as novas dependências no projeto atualize o seu projeto. Pare o servidor e reinicie o mesmo.

Note que ao tentar iniciar o projeto novamente, teremos um erro pela falta de configurações do banco de dados:

```
Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.

Reason: Failed to determine a suitable driver class


Action:

Consider the following:
	If you want an embedded database (H2, HSQL or Derby), please put it on the classpath.
	If you have database settings to be loaded from a particular profile you may need to activate it (no profiles are currently active).


Process finished with exit code 0
```

### Configurar banco de dados

Para solucionar vamos adicionar as configurações no arquivo:

Resources/ application.properties

Aqui vamos colocar:

1. URL do banco de dados;
2. login;
3. senha do banco de dados;

```
spring.datasource.url=jdbc:mysql://localhost/db_sismedico?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=senha
```

> Você pode remover a parte 
>
> ```
> ?createDatabaseIfNotExist=true
> ```
>
>  caso já tenha um banco de dados criado para se conectar, lembre-se de passar corretamente o nome do banco existente.

### Usando a JPA para persistir no banco

Para começarmos a colocar essa parte da persistência precisamos criar as Models do médico e paciente para ter a estrutura do banco de dados garantida. 

1. crie a model de Médico com os atributos do Record médico
2. crie a model da endereço com os atributos do Record DadosEndereço
3. incluir as anotações para garantir que o Lombok e o Entity atue para as classes 

Código da model Medico

```
package com.tijacque.clinicaMedica.model;

import com.tijacque.clinicaMedica.endereco.DadosEndereco;
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

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded //os campos no banco será na mesma table do medico e não uma table nova
    private DadosEndereco endereco;
}
```

Código da model endereço

```
package com.tijacque.clinicaMedica.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DadosEndereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;
}
```

Agora vamos criar a Interface Repository para o médico

```
package com.tijacque.clinicaMedica.repository;


import com.tijacque.clinicaMedica.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicoRepository extends JpaRepository <Medico, Long> {
}
```

Agora vamos alterar a classe controller para incluir a JPA e realizar a persistência no banco de dados:

```
@PostMapping("/cadastrarmed")
public void cadastrarMed(@RequestBody DadosCadastroMedico dados){
    //forma de trabalhar sem o construtor
    //medicoRepository.save(new Medico(null, dados.nome(), dados.email(), dados.crm(), new DadosEndereco()));
    medicoRepository.save(new Medico(dados));
}
```

> Atenção crie os construtores para a classe Medico e Endereço
>
> model de médicos - método construtor

```
public Medico(DadosCadastroMedico dados){
    this.crm = dados.crm();
    this.nome = dados.nome();
    this.email = dados.email();
    this.especialidade = dados.especialidade();
    this.endereco = new DadosEndereco(dados.endereco());
    this.telefone = dados.telefone();

}
```



Model de endereço

```
public DadosEndereco(Endereco dados){
    this.bairro = dados.bairro();
    this.cep = dados.cep();
    this.uf = dados.uf();
    this.cidade = dados.cidade();
    this.complemento = dados.complemento();
    this.logradouro = dados.logradouro();
    this.numero = dados.numero();
}
```

Agora vamos criar as Migrations

1. criar a estrutura db/migration dentro de resources
2. para o seu projeto
3. criar um file dentro do diretório migration com nome V1__create-table-medicos.sql (é necessário sempre iniciar o nome do arquivo com V e numero da versão)
4. digite o SQL para formar a estrutura da tabela 

```
CREATE TABLE tb_medicos(
id bigint not null auto_increment,
nome varchar(200) not null,
email varchar(200) not null,
crm varchar(8) not null unique,
especialidade varchar(100) not null,
logradouro varchar(200),
bairro  varchar(200),
cep varchar(9),
complemento varchar(200),
numero varchar(10),
uf varchar(2),
cidade varchar (200),
primary key(id)
);
```

5. volte a rodar o projeto e faça um teste tentando persistir um dado no banco de dados.

Controller versão final 

```
@PostMapping
@Transactional // anotação para transicionar dados com o banco de dados
public void cadastrar(@RequestBody DadosPaciente dadosPaciente){
    System.out.println(dadosPaciente);
}
```

### validar dados antes de enviar para o banco - validation (i/o)

Para criar algumas validações para os atributos cadastrados, exemplo formato do dado ou ainda a obrigatoriedade do dado ou não iremos alterar o arquivo Record do médico e do endereço

vamos adicionar algumas anotações nesses arquivos para os atributos para indicar quando ele não pode ser null, não pode ser vazio, não pode ter formato diferente do indicado.

Código do Record Medico:

```
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
        @NotBlank @Pattern(regexp = "\\d{4,6}")//de quatro a 6 digitos
        String crm,
        @NotNull
        Especialidade especialidade,

        @NotNull @Valid
        Endereco endereco) {

}
```

Código do record Endereço

```
package com.tijacque.clinicaMedica.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record Endereco(
        @NotBlank
        String logradouro,
        String bairro,
        @Pattern(regexp = "\\d{8}")
        String cep,
        String cidade,
        String uf,
        String complemento,
        String numero) {
}
```

A classe controller do médico também vai receber uma nova anotação para o seu corpo da requisição

```
@PostMapping("/cadastrarmed")
public void cadastrarMed(@RequestBody @Valid DadosCadastroMedico dados){
    //@Valid é para obrigar o Spring a usar as validações colocadas na record ao realizar essa operação
    medicoRepository.save(new Medico(dados));
}
```

sobre as validações temos a documentação oficial https://jakarta.ee/specifications/bean-validation/3.0/jakarta-bean-validation-spec-3.0.html#builtinconstraints

## Método Listar em médicos

Aqui vamos escrever mais um método dentro do MedicoController para listar todos os médicos cadastrados, temos aqui duas formas de trabalhar: 

1. para a primeira apenas listar todos os dados sem tratar; 
2. para a segunda forma vamos trazer apenas alguns dados necessários, não vamos trazer todos os dados. Para isso vamos precisar criar um Record para filtrar quais dados vamos entregar para essa requisição;

```
@GetMapping
public List<Medico> listarTodosDados(){
    return medicoRepository.findAll();
}
```



Vamos agora conhecer a segunda forma de se fazer, usando uma abordagem mais assertiva já que não vamos retornar dados desnecessário do médico

1. primeiro vamos criar um record / DTO com os dados que realmente precisamos retornar:
 ```
   package com.tijacque.clinicaMedica.medico;
   
   public record DadosListagemMedico(
           String nome,
           String email,
           String crm,
           Especialidade especialidade
   ) {
   }
 ```

Aqui ainda não temos a estrutura completa para atender a necessidade, precisaremos criar aqui um método construtor para permitir o acesso a essas informações, assim o DTO ficará:

```
package com.tijacque.clinicaMedica.medico;

import com.tijacque.clinicaMedica.model.Medico;

public record DadosListagemMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {
    public DadosListagemMedico(Medico medico){
        //método construtor para permitir consumo dos dados na controller
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
```

2. vamos criar o método dentro do controller

```
@GetMapping("dados-medico")
    public List<DadosListagemMedico> listar(){
        //o retorno faz um map para trazer os dados do DTO DadosListagemMedico
        //tolist é para ele converter para uma lista que é o esperado List<> na assinatura do metodo
        return medicoRepository.findAll().stream().map(DadosListagemMedico::new).toList();
    }
```

### Incluir paginação e ordenação aos dados

```
@GetMapping("dados-medico")
public Page<DadosListagemMedico> listar(Pageable paginacao){
    //o retorno faz um map para trazer os dados do DTO DadosListagemMedico
    //Aqui ajustamos o método para retornar um Page com a paginação
    //para o return a gente incluiu a paginação no medoto findAll e deixamos o metodo menor pq não é mais necessário converter para lista
    return medicoRepository.findAll(paginacao).map(DadosListagemMedico::new);
    //
}
```

Essa alteração fez o retorno do método incluir informações da paginação, isso fica no final da lista com os registros médicos:

```
"pageable": {
		"sort": {
			"empty": true,
			"sorted": false,
			"unsorted": true
		},
		"offset": 0,
		"pageNumber": 0,
		"pageSize": 20,
		"paged": true,
		"unpaged": false
	},
	"last": true,
	"totalPages": 1,
	"totalElements": 7,
	"size": 20,
	"number": 0,
	"sort": {
		"empty": true,
		"sorted": false,
		"unsorted": true
	},
	"first": true,
	"numberOfElements": 7,
	"empty": false
```

Ainda podemos controlar a quantidade de registros que iremos entregar para o consumo:

1. ```
   localhost:8080/medicos/dados-medico?size=1
   ```

    sendo size indicador da quantidade de registros

2. ```
   localhost:8080/medicos/dados-medico?size=1&page=6
   ```

    sendo o page o número da pagina que desejamos retornar para quem consome nossa api

3. ```
   localhost:8080/medicos/dados-medico?sort=nome
   ```

    sendo o sort o parâmetro que define a ordenação e o nome o atributo nome. Podemos mudar o atributo do parâmetro para usar outros atributos também 

4. ```
   localhost:8080/medicos/dados-medico?sort=nome,desc
   ```

    ainda podemos ordenar de forma decrescente usando o complemento para o atributo que é ,desc

Também podemos deixar alguns parâmetros como default para a nossa aplicação, com a anotação @PageableDefault:

```
@GetMapping("dados-medico")
public Page<DadosListagemMedico> listar(@PageableDefault(size = 5, sort = {"nome"}) Pageable paginacao){
//aqui temos o size = 5 e o sort = nome por default
    //o retorno faz um map para trazer os dados do DTO DadosListagemMedico
    //Aqui ajustamos o método para retornar um Page com a paginação
    //para o return a gente incluiu a paginação no medoto findAll e deixamos o metodo menor pq não é mais necessário converter para lista
    return medicoRepository.findAll(paginacao).map(DadosListagemMedico::new);
    //
}
```

Uma alteração que talvez possa te ajudar a entender a sua api é a de exibir as consultar (Querys) no console, para isso vamos adicionar mais parâmetros no arquivo application.properties

```
spring.jpa.show-sql = true
spring.jpa.properties.hibernate.format_sql = true
```

A primeira linha exibe o query no console e a segunda cria uma formatação para esse query para facilitar a sua leitura.

Ainda podemos traduzir essas propriedades a serem passadas para a paginação incluindo mais 3 linhas no arquivo application.properties, seguem então as linhas:

```ini
spring.data.web.pageable.page-parameter=pagina
spring.data.web.pageable.size-parameter=tamanho
spring.data.web.sort.sort-parameter=ordem
```

Uma vez feita essa alteração a consulta fica:

```bash
http://localhost:8080/medicos?tamanho=5&pagina=1&ordem=email,desc
```

## Atualizar dados do médico

Para colocar em prática esse processo precisaremos ajustar as classes: MedicoController, model do Médico, DTO DadosListagemMedico e o Dados endereço. Com essas alterações teremos métodos construtores e outros para entregar e realizar as ações necessárias para a atualização dos dados mantendo a integridade dos mesmos.

Nesse momento, vamos criar o DTO responsável por definir os campos que podem ser atualizados removendo a obrigatoriedade de se informar todos os dados para atualizar, já que podemos ter a necessidade de passar apenas algumas informações para atualização, sem perder os "campos" que não demandam a necessidade de atualização. Note no código a seguir que o único atributo obrigatório será o ID.

### DTO DadosAtualizaMedico

```
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
```

Vamos fazer é adicionar o ID na listagem dos dados dos médicos, isso será na classe DadosListagemMedico - DTO que retornar os dados dos médicos precisa de ID, para conseguirmos informar o id da linha que deve ser afetada no update.

Note no código a seguir que incluímos o ID dentro da Record como um dado Long, seguindo a configuração do dado na Model. Esse atributo também esta dentro do construtor(medico.getId), para permitir trazer esse dado da Model Medico.

### Mudança da DTO DadosListagemMedico

```
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
```

Para a classe record DadosEndereço teremos que adicionar também um método atualizarInformacoes, que vai permitir preencher apenas os dados os quais queremos atualizar do endereço, sem ter a necessidade de passar todos os dados para essa ação.

### Alteração para a DTO DadosEndereço

O código a ser adicionado será:

```
public void atualizarInformacoes(DadosEndereco dados) {
    if(dados.logradouro != null) this.logradouro = dados.logradouro;
    if(dados.numero != null) this.numero = dados.numero;
    if(dados.complemento != null) this.complemento = dados.complemento;
    if(dados.bairro != null) this.bairro = dados.bairro;
    if(dados.cidade != null) this.cidade = dados.cidade;
    if(dados.uf != null) this.uf = dados.uf;
    if(dados.cep != null) this.cep = dados.cep;
}
```

## Requisição de delete - inativar registro no banco

Chegamos em um ponto onde o caminho a ser seguido pode ser dois, uma deleção real no banco de dados e a exclusão lógica que é muito praticada. Vamos entender as duas formas antes de colocar em prática.

### Deletar diretamente no banco

Para realizar a função apagando o dado no banco podemos usar um simples método, chamando a repository, vamos ver a seguir o código e entender.

```
@DeleteMapping("/{id}") //anotação para o verbo http responsável por deletar
@Transactional 
public void excluir(@PathVariable Long id){ //a anotação PathVariable da suporte a passar o id pela URL como variavel
    medicoRepository.deleteById(id); //o metodo deleteById vem da JPA e da suporte a ação deletar pelo ID
}
```

### Desativar apenas

Essa segundo opção é um pouco mais segura já que não afeta o banco de dados de forma irreversível, os dados continuam ali porém inativados.

Para isso vamos acrescentar a coluna que diz se o registro esta ativo ou inativo no banco de dados, em uma nova versão do 

db.migration.

arquivo V4__adicionar-campo-cad-ativo.sql

```
alter table tb_medicos add ativo tinyint;
update tb_medicos set ativo =1;
```

> Atenção: para a alteração do banco ser realizada com sucesso, pare e inicie novamente o servidor.

Vamos incluir esse atributo na model, atributo ativo do tipo boolean:

```
private Boolean ativo;
```

Agora vamos criar no model Medico, o método que realizar a ação de passar o valor false para o campo quando necessário:

```
public void inativar() {
    this.ativo = false;
}
```

Além disso, vamos garantir que o cadastro médico ao ser inserido no banco entre como true, essa alteração/método também ficará na model Medico, método construtor:

```
public Medico(DadosCadastroMedico dados){
    this.ativo = true;
    this.crm = dados.crm();
    this.nome = dados.nome();
    this.email = dados.email();
    this.especialidade = dados.especialidade();
    this.endereco = new DadosEndereco(dados.endereco());
    this.telefone = dados.telefone();

}
```

Agora na camada controller, vamos escrever o método que torna o registro false/inativo:

```
@DeleteMapping("/inativar/{id}") //mudei a rota para evitar ambiguidade 
@Transactional
public void inativar(@PathVariable Long id){
    var medico= medicoRepository.getReferenceById(id); //defino o registro que deve ser afetado referenciando pelo ID
    medico.inativar(); para o registro localizado, executamos o método inativar que esta na model Médico.
}
```

