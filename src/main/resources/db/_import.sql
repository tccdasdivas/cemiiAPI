insert into tb_estado(nome) values ('São Paulo');

insert into tb_cidade(nome, estado_id) values ('Lençóis Paulista', 1);
insert into tb_cidade(nome, estado_id) values ('Macatuba', 2);

insert into tb_profissao(profissao) values ('Profissional da saúde');
insert into tb_profissao(profissao) values ('Cuidador');

insert into tb_profissional(nome, email, telefone, cpf, foto, profissao_id, cidade_id, nascimento) values ('Cleide', 'cleide.silva@gmail.com', '1499111111', '12345678901', 'opcional', 1, 2, '1985-06-02');

insert into tb_grauparentesco(parente) values ('Filha');

insert into tb_responsavel(nome, email, telefone, cpf, foto, grauparentesco_id, cidade_id, nascimento) values ('Julia', 'julia.souza@gmail.com', '149999999', '98765432109', 'opcional', 1, 1, '1996-05-12');

insert into tb_idoso(nome, email, telefone, cpf, foto, necessidades, cidade_id, nascimento, grauparentesco_id, responsavel_id) values ('Roger', 'roger.souza@gmail.com', '1499888888', '32165498708', 'opcional', 'demencia', 1, '1953-11-01', 1, )