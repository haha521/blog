drop table if exists tb_perm;

/*==============================================================*/
/* Table: tb_perm                                               */
/*==============================================================*/
create table tb_perm
(
   perm_id              int(11) not null auto_increment,
   perm_content         varchar(20) not null,
   insert_time          timestamp default CURRENT_TIMESTAMP,
   update_time          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (perm_id)
);
