drop table if exists role;

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   role_id              int(11) not null auto_increment,
   role_content         varchar(11) not null,
   insert_time          timestamp default CURRENT_TIMESTAMP,
   update_time          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (role_id)
);
