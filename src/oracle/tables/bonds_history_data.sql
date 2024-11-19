--
--------------------------------------------------------------------------------
-- PRICE AND RATE HISTORY
--------------------------------------------------------------------------------
--
create table bonds_history_data
(id_bond_history  number generated always as identity,
 id_issued_bond   number constraint fk_bonds_history_data_issued_bond references issued_bonds not null,
 hist_date        date          not null,
 rate_buy         number(5, 2)  not null,
 rate_sell        number(5, 2)  not null,
 pu_buy           number(15, 2) not null,
 pu_sell          number(15, 2) not null,
 pu_base          number(15, 2),
 constraint bonds_history_data primary key (id_bond_history)
);
--
alter table bonds_history_data add constraint uk_bonds_history_data_hist_date unique (id_issued_bond, hist_date);
--
comment on table bonds_history_data is 'Price and rate history';
comment on column bonds_history_data.id_bond_history is '[PK]';
comment on column bonds_history_data.id_issued_bond  is '[FK] Issued bond';
comment on column bonds_history_data.hist_date       is 'Date';
comment on column bonds_history_data.rate_buy        is 'Rate buy (%)';
comment on column bonds_history_data.rate_sell       is 'Rate sell (%)';
comment on column bonds_history_data.pu_buy          is 'PU buy';
comment on column bonds_history_data.pu_sell         is 'PU sell';
comment on column bonds_history_data.pu_base         is 'PU base';