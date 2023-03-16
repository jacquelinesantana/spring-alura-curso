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