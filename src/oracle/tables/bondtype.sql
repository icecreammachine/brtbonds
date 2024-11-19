--------------------------------------------------------------------------------
-- BOND TYPES
--------------------------------------------------------------------------------
drop table bondtype;
create table bondtype
(id_bond_type number GENERATED ALWAYS AS IDENTITY,
 code         varchar2(5)  not null,
 smalldesc    varchar2(15) not null,
 fulldesc     varchar2(40) not null,
 constraint pk_bondtype primary key (id_bond_type)
);
--
comment on table bondtype is 'Treasury bond types';
comment on column bondtype.id_bond_type is '[PK]';
comment on column bondtype.code         is 'Code';
comment on column bondtype.smalldesc    is 'Small description';
comment on column bondtype.fulldesc     is 'Full description';
--
insert into bondtype(code, smalldesc, fulldesc) values ('LFT', 'LFT', 'Tesouro Selic');
insert into bondtype(code, smalldesc, fulldesc) values ('LTN', 'LTN', 'Tesouro Prefixado');
insert into bondtype(code, smalldesc, fulldesc) values ('NTNC', 'NTN-C', 'Tesouro IGP-M');
insert into bondtype(code, smalldesc, fulldesc) values ('NTNB', 'NTN-B', 'Tesouro IPCA+ com Juros Semestrais');
insert into bondtype(code, smalldesc, fulldesc) values ('NTNBP', 'NTN-B Principal', 'Tesouro IPCA+');
insert into bondtype(code, smalldesc, fulldesc) values ('NTNF', 'NTN-F', 'Tesouro Prefixado com Juros Semestrais');
insert into bondtype(code, smalldesc, fulldesc) values ('NTNB1', 'NTN-B1', 'Tesouro RendA+');
commit;