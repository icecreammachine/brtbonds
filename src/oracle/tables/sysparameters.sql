--
--------------------------------------------------------------------------------
-- SYSTEM PARAMETERS
--------------------------------------------------------------------------------
--
create table sysparameters
(code        varchar2(30) constraint pk_sysparameters primary key,
 value       varchar2(30),
 description varchar2(255)
);
--
comment on table sysparameters is 'System parameters';
comment on column sysparameters.code  is '[PK] Code';
comment on column sysparameters.value is 'Value';
comment on column sysparameters.description is 'Description';
--
insert into sysparameters values ('FIRST_RUN', 'Y', 'Perform operations needed for the first run');
commit;