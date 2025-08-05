create table tb_cidade(
id bigint not null auto_increment,
nome varchar(100),
estado_id not null
) engine=InnoDB default charset=utf8;