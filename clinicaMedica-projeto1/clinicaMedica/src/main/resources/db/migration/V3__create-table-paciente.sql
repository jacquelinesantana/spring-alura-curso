CREATE TABLE tb_pacientes(
id bigint not null auto_increment,
nome varchar(200) not null,
cpf varchar(14) not null unique,
telefone varchar (20) not null,
logradouro varchar(200),
bairro  varchar(200),
cep varchar(9),
complemento varchar(200),
numero varchar(10),
uf varchar(2),
cidade varchar (200),
primary key(id)

);