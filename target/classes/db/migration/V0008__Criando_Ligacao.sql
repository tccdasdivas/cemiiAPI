alter table tb_cidade add constraint fk_cidade_estado foreign key (estado_id) references tb_estado(id);
alter table tb_idoso add constraint fk_idoso_cidade foreign key (cidade_id) references tb_cidade(id);
alter table tb_familia add constraint fk_familia_cidade foreign key (cidade_id) references tb_familia(id);
alter table tb_cuidador add constraint fk_cuidador_profissao foreign key (profissao_id) references tb_profissao(id);
alter table tb_cuidador add constraint fk_cuidador_cidade foreign key (cidade_id) references tb_cidade(id);