--
--------------------------------------------------------------------------------
-- LINKS TO DOWNLOAD HISTORIC DATA
--------------------------------------------------------------------------------
--
create table bonds_history_link
(idbond_hist_link number generated always as identity,
 year             number(4)          not null,
 id_bond_type     number             not null,
 link             varchar2(255 char) not null,
 constraint pk_bonds_history_link primary key(idbond_hist_link),
 constraint fk_bonds_history_link_bond_type foreign key (id_bond_type) references bondtype
);
--
comment on table bonds_history_link is 'Links to download historic files';
comment on column bonds_history_link.idbond_hist_link is '[PK]';
comment on column bonds_history_link.year             is 'Year';
comment on column bonds_history_link.id_bond_type     is '[FK] Bond type';
comment on column bonds_history_link.link             is 'Link for download';
--
insert into bonds_history_link(year, id_bond_type, link) values (2002,1,'https://www.tesourodireto.com.br/data/files/21/C6/E7/61/28E4C6100F9094C6518E28A8/historicoLFT_2002.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2002,2,'https://www.tesourodireto.com.br/data/files/AF/B6/D6/61/28E4C6100F9094C6518E28A8/historicoLTN_2002.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2002,3,'https://www.tesourodireto.com.br/data/files/3E/B6/24/61/28E4C6100F9094C6518E28A8/historicoNTNC_2002.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2003,1,'https://www.tesourodireto.com.br/data/files/6B/D6/57/15/48E4C6100F9094C6518E28A8/historicoLFT_2003.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2003,2,'https://www.tesourodireto.com.br/data/files/E9/D6/95/15/48E4C6100F9094C6518E28A8/historicoLTN_2003.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2003,3,'https://www.tesourodireto.com.br/data/files/F6/D6/CF/05/48E4C6100F9094C6518E28A8/historicoNTNB_2003.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2003,4,'https://www.tesourodireto.com.br/data/files/68/D6/13/15/48E4C6100F9094C6518E28A8/historicoNTNC_2003.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2004,1,'https://www.tesourodireto.com.br/data/files/93/F6/94/E7/58E4C6100F9094C6518E28A8/historicoLFT_2004.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2004,2,'https://www.tesourodireto.com.br/data/files/15/F6/87/E7/58E4C6100F9094C6518E28A8/historicoLTN_2004.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2004,3,'https://www.tesourodireto.com.br/data/files/12/F6/E1/E7/58E4C6100F9094C6518E28A8/historicoNTNC_2004.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2004,4,'https://www.tesourodireto.com.br/data/files/96/F6/3A/E7/58E4C6100F9094C6518E28A8/historicoNTNB_2004.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2004,6,'https://www.tesourodireto.com.br/data/files/A0/F6/ED/D7/58E4C6100F9094C6518E28A8/historicoNTNF_2004.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2005,1,'https://www.tesourodireto.com.br/data/files/39/17/F4/A6/88E4C6100F9094C6518E28A8/historicoLFT_2005.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2005,2,'https://www.tesourodireto.com.br/data/files/B7/17/04/A6/88E4C6100F9094C6518E28A8/historicoLTN_2005.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2005,3,'https://www.tesourodireto.com.br/data/files/36/17/23/A6/88E4C6100F9094C6518E28A8/historicoNTNC_2005.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2005,4,'https://www.tesourodireto.com.br/data/files/B4/17/12/A6/88E4C6100F9094C6518E28A8/historicoNTNB_2005.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2005,5,'https://www.tesourodireto.com.br/data/files/33/17/01/A6/88E4C6100F9094C6518E28A8/historicoNTNBPrincipal_2005.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2005,6,'https://www.tesourodireto.com.br/data/files/C1/17/2F/96/88E4C6100F9094C6518E28A8/historicoNTNF_2005.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2006,1,'https://www.tesourodireto.com.br/data/files/CD/37/0B/A9/A8E4C6100F9094C6518E28A8/historicoLFT_2006.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2006,2,'https://www.tesourodireto.com.br/data/files/4C/37/1A/A9/A8E4C6100F9094C6518E28A8/historicoLTN_2006.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2006,3,'https://www.tesourodireto.com.br/data/files/CA/37/19/A9/A8E4C6100F9094C6518E28A8/historicoNTNC_2006.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2006,4,'https://www.tesourodireto.com.br/data/files/49/37/37/A9/A8E4C6100F9094C6518E28A8/historicoNTNB_2006.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2006,5,'https://www.tesourodireto.com.br/data/files/C7/37/C5/A9/A8E4C6100F9094C6518E28A8/historicoNTNBPrincipal_2006.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2006,6,'https://www.tesourodireto.com.br/data/files/56/37/04/A9/A8E4C6100F9094C6518E28A8/historicoNTNF_2006.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2007,1,'https://www.tesourodireto.com.br/data/files/72/67/70/B4/C8E4C6100F9094C6518E28A8/historicoLFT_2007.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2007,2,'https://www.tesourodireto.com.br/data/files/F0/67/CE/A4/C8E4C6100F9094C6518E28A8/historicoLTN_2007.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2007,3,'https://www.tesourodireto.com.br/data/files/7F/57/3D/A4/C8E4C6100F9094C6518E28A8/historicoNTNC_2007.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2007,4,'https://www.tesourodireto.com.br/data/files/FD/57/7B/A4/C8E4C6100F9094C6518E28A8/historicoNTNB_2007.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2007,5,'https://www.tesourodireto.com.br/data/files/7C/57/B9/A4/C8E4C6100F9094C6518E28A8/historicoNTNBPrincipal_2007.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2007,6,'https://www.tesourodireto.com.br/data/files/0B/57/97/A4/C8E4C6100F9094C6518E28A8/historicoNTNF_2007.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2008,1,'https://www.tesourodireto.com.br/data/files/9F/77/10/51/F8E4C6100F9094C6518E28A8/historicoLFT_2008.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2008,2,'https://www.tesourodireto.com.br/data/files/01/87/32/51/F8E4C6100F9094C6518E28A8/historicoLTN_2008.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2008,3,'https://www.tesourodireto.com.br/data/files/82/87/B3/51/F8E4C6100F9094C6518E28A8/historicoNTNC_2008.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2008,4,'https://www.tesourodireto.com.br/data/files/04/87/25/51/F8E4C6100F9094C6518E28A8/historicoNTNB_2008.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2008,5,'https://www.tesourodireto.com.br/data/files/85/87/E6/51/F8E4C6100F9094C6518E28A8/historicoNTNBPrincipal_2008.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2008,6,'https://www.tesourodireto.com.br/data/files/07/87/88/51/F8E4C6100F9094C6518E28A8/historicoNTNF_2008.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2009,1,'https://www.tesourodireto.com.br/data/files/0D/A7/21/00/49E4C6100F9094C6518E28A8/historicoLFT_2009.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2009,2,'https://www.tesourodireto.com.br/data/files/95/A7/D4/FF/39E4C6100F9094C6518E28A8/historicoLTN_2009.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2009,3,'https://www.tesourodireto.com.br/data/files/8B/A7/1D/FF/39E4C6100F9094C6518E28A8/historicoNTNC_2009.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2009,4,'https://www.tesourodireto.com.br/data/files/0A/A7/8A/FF/39E4C6100F9094C6518E28A8/historicoNTNB_2009.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2009,5,'https://www.tesourodireto.com.br/data/files/88/A7/E8/FF/39E4C6100F9094C6518E28A8/historicoNTNBPrincipal_2009.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2009,6,'https://www.tesourodireto.com.br/data/files/07/A7/17/FF/39E4C6100F9094C6518E28A8/historicoNTNF_2009.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2010,1,'https://www.tesourodireto.com.br/data/files/32/E7/09/0F/F9E4C6100F9094C6518E28A8/historicoLFT_2010.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2010,2,'https://www.tesourodireto.com.br/data/files/B0/E7/27/0F/F9E4C6100F9094C6518E28A8/historicoLTN_2010.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2010,3,'https://www.tesourodireto.com.br/data/files/3F/D7/25/0F/F9E4C6100F9094C6518E28A8/historicoNTNC_2010.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2010,4,'https://www.tesourodireto.com.br/data/files/CA/D7/5E/FE/F9E4C6100F9094C6518E28A8/historicoNTNB_2010.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2010,5,'https://www.tesourodireto.com.br/data/files/BD/D7/D2/0F/F9E4C6100F9094C6518E28A8/historicoNTNBPrincipal_2010.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2010,6,'https://www.tesourodireto.com.br/data/files/3C/D7/11/0F/F9E4C6100F9094C6518E28A8/historicoNTNF_2010.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2011,1,'https://www.tesourodireto.com.br/data/files/B6/00/A4/94/5AE4C6100F9094C6518E28A8/historicoLFT_2011.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2011,2,'https://www.tesourodireto.com.br/data/files/35/00/23/94/5AE4C6100F9094C6518E28A8/historicoLTN_2011.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2011,3,'https://www.tesourodireto.com.br/data/files/B3/00/51/94/5AE4C6100F9094C6518E28A8/historicoNTNC_2011.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2011,4,'https://www.tesourodireto.com.br/data/files/B0/00/5E/84/5AE4C6100F9094C6518E28A8/historicoNTNB_2011.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2011,5,'https://www.tesourodireto.com.br/data/files/32/00/9F/84/5AE4C6100F9094C6518E28A8/historicoNTNBPrincipal_2011.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2011,6,'https://www.tesourodireto.com.br/data/files/4F/F7/6C/84/5AE4C6100F9094C6518E28A8/historicoNTNF_2011.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2012,1,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2012/LFT_2012.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2012,2,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2012/LTN_2012.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2012,3,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2012/NTN-C_2012.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2012,4,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2012/NTN-B_2012.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2012,5,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2012/NTN-B_Principal_2012.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2012,6,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2012/NTN-F_2012.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2013,1,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2013/LFT_2013.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2013,2,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2013/LTN_2013.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2013,3,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2013/NTN-C_2013.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2013,4,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2013/NTN-B_2013.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2013,5,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2013/NTN-B_Principal_2013.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2013,6,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2013/NTN-F_2013.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2014,1,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2014/LFT_2014.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2014,2,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2014/LTN_2014.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2014,3,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2014/NTN-C_2014.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2014,4,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2014/NTN-B_2014.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2014,5,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2014/NTN-B_Principal_2014.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2014,6,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2014/NTN-F_2014.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2015,1,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2015/LFT_2015.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2015,2,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2015/LTN_2015.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2015,3,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2015/NTN-C_2015.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2015,4,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2015/NTN-B_2015.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2015,5,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2015/NTN-B_Principal_2015.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2015,6,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2015/NTN-F_2015.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2016,1,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2016/LFT_2016.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2016,2,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2016/LTN_2016.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2016,3,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2016/NTN-C_2016.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2016,4,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2016/NTN-B_2016.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2016,5,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2016/NTN-B_Principal_2016.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2016,6,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2016/NTN-F_2016.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2017,1,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2017/LFT_2017.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2017,2,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2017/LTN_2017.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2017,3,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2017/NTN-C_2017.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2017,4,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2017/NTN-B_2017.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2017,5,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2017/NTN-B_Principal_2017.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2017,6,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2017/NTN-F_2017.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2018,1,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2018/LFT_2018.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2018,2,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2018/LTN_2018.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2018,3,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2018/NTN-C_2018.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2018,4,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2018/NTN-B_2018.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2018,5,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2018/NTN-B_Principal_2018.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2018,6,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2018/NTN-F_2018.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2019,1,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2019/LFT_2019.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2019,2,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2019/LTN_2019.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2019,3,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2019/NTN-C_2019.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2019,4,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2019/NTN-B_2019.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2019,5,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2019/NTN-B_Principal_2019.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2019,6,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2019/NTN-F_2019.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2020,1,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2020/LFT_2020.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2020,2,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2020/LTN_2020.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2020,3,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2020/NTN-C_2020.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2020,4,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2020/NTN-B_2020.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2020,5,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2020/NTN-B_Principal_2020.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2020,6,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2020/NTN-F_2020.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2021,1,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2021/LFT_2021.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2021,2,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2021/LTN_2021.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2021,3,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2021/NTN-C_2021.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2021,4,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2021/NTN-B_2021.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2021,5,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2021/NTN-B_Principal_2021.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2021,6,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2021/NTN-F_2021.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2022,1,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2022/LFT_2022.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2022,2,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2022/LTN_2022.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2022,3,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2022/NTN-C_2022.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2022,4,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2022/NTN-B_2022.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2022,5,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2022/NTN-B_Principal_2022.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2022,6,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2022/NTN-F_2022.xls');

insert into bonds_history_link(year, id_bond_type, link) values (2023,1,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2023/LFT_2023.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2023,2,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2023/LTN_2023.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2023,3,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2023/NTN-C_2023.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2023,4,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2023/NTN-B_2023.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2023,5,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2023/NTN-B_Principal_2023.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2023,6,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2023/NTN-F_2023.xls');
insert into bonds_history_link(year, id_bond_type, link) values (2023,7,'https://cdn.tesouro.gov.br/sistemas-internos/apex/producao/sistemas/sistd/2023/NTN-B1_2023.xls');

commit;