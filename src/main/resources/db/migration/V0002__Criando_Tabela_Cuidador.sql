create table tb_cuidador(
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

primary key (id)
) engine=InnoDB default charset=utf8;

