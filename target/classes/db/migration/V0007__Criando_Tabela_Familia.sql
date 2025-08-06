create table tb_familia(
id bigint not null auto_increment,
nome varchar (100),
email varchar (100),
telefone varchar(12),
cpf varchar (11),
grauparentesco_id bigint not null,
cidade_id bigint not null,
data_nascimento date not null,

primary key (id)
) engine=InnoDB default charset=utf8;

