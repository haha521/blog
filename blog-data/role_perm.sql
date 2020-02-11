drop table if exists tb_role_perm;

/*==============================================================*/
/* Table: tb_role_perm                                          */
/*==============================================================*/
create table tb_role_perm
(
   rp_id                int(11) not null auto_increment,
   role_id              varchar(11) not null,
   perm_id              int(11) not null,
   insert_time          timestamp default CURRENT_TIMESTAMP,
   update_time          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (rp_id)
);
