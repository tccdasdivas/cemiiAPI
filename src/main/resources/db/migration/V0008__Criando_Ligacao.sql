alter table tb_cidade add constraint fk_cidade_estado foreign key (estado_id) references tb_estado(id);
alter table tb_idoso add constraint fk_idoso_cidade foreign key (cidade_id) references tb_cidade(id);
alter table tb_responsavel add constraint fk_responsavel_cidade foreign key (cidade_id) references tb_cidade(id);
alter table tb_profissional add constraint fk_profissional_profissao foreign key (profissao_id) references tb_profissao(id);
alter table tb_profissional add constraint fk_profissional_cidade foreign key (cidade_id) references tb_cidade(id);
alter table tb_idoso add constraint fk_idoso_grauparentesco foreign key (grauparentesco_id) references tb_grauparentesco(id);
alter table tb_idoso add constraint fk_idoso_responsavel foreign key (responsavel_id) references tb_responsavel(id);
