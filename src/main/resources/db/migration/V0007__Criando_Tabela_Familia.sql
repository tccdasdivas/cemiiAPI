create table tb_familia(
id bigint not null auto_increment,
nome varchar (100),
email varchar (100),
telefone varchar(12),
cpf varchar (11),
grauparentesco_id not null,
estado_id not null,
data_nascimento date not null
) engine=InnoDB default charset=utf8;;