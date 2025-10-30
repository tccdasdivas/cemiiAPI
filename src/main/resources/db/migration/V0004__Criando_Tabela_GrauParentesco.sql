create table tb_grauparentesco(
id bigint not null auto_increment,
parente varchar (100),
data_cadastro date not null,
data_atualizacao date not null,

primary key (id)
) engine=InnoDB default charset=utf8;