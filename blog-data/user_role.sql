drop table if exists tb_user_role;

/*==============================================================*/
/* Table: tb_user_role                                          */
/*==============================================================*/
create table tb_user_role
(
   ur_id                int(11) not null auto_increment,
   user_id              int(11) not null,
   role_id              int(11) not null,
   insert_time          timestamp default CURRENT_TIMESTAMP,
   update_time          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (ur_id)
);
