--
--------------------------------------------------------------------------------
-- ISSUED BONDS
--------------------------------------------------------------------------------
--
create table issued_bonds
(id_issued_bond number GENERATED ALWAYS AS IDENTITY,
 id_bond_type   number constraint fk_issued_bonds_bond_type references bondtype not null,
 maturity_date  date         not null,
 code           varchar2(24) not null,
 constraint pk_issued_bonds primary key (id_issued_bond)
);
--
alter table issued_bonds add constraint uk_issued_bonds_code unique (code);
--
comment on table issued_bonds is 'Issued bonds';
comment on column issued_bonds.id_issued_bond is '[PK]';
comment on column issued_bonds.id_bond_type   is '[FK] Bond type';
comment on column issued_bonds.maturity_date  is 'Maturity date';
comment on column issued_bonds.code           is 'Code';