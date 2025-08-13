create table  tb_idoso(
id bigint not null auto_increment,
nome varchar (100),
email varchar (100),
telefone varchar (12),
cpf varchar (11),
necessidades varchar (255),
cidade_id bigint not null,
data_nascimento date not null,

primary key (id)
) engine=InnoDB default charset=utf8;

