create user brtbonds identified by "password";

grant connect, resource, create view, unlimited tablespace to brtbonds;

ALTER USER brtbonds QUOTA UNLIMITED ON DATA;
