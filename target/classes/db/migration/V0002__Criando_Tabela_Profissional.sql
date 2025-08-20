create table tb_profissional(
id bigint not null auto_increment,
nome varchar(100),
email varchar(100),
telefone varchar (12),
cpf varchar (11),
profissao_id bigint not null,
cidade_id bigint not null,
data_nascimento date not null,
data_cadastro date not null,
data_atualizacao date not null,
foto varchar(255),

endereco_cidade_id bigint,
endereco_cep varchar(9),
endereco_logradouro varchar(100),
endereco_numero varchar(20),
endereco_complemento varchar(60),
endereco_bairro varchar(60),

primary key (id)
) engine=InnoDB default charset=utf8;

