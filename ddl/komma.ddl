set foreign_key_checks = 0;

drop table if exists user;
create table user
(
    user_id            int                                      not null auto_increment primary key,
    username           varchar(64)                              not null unique,
    password           varchar(64)                              not null,
    first_name         varchar(64)                              null,
    last_name          varchar(64)                              null,
    display_name       varchar(64)                              null,
    email              varchar(64)                              null,
    about              text                                     null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null
);

drop table if exists role;
create table role
(
    role_id            int                                      not null auto_increment primary key,
    role               varchar(64)                              not null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null
);

drop table if exists user_role;
create table user_role
(
    user_role_id       int                                      not null auto_increment primary key,
    role_fk            int                                      not null,
    user_fk            int                                      not null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null,

    constraint fk_role foreign key (role_fk) references role (role_id)
        on update cascade on delete cascade,
    constraint fk_user foreign key (user_fk) references user (user_id)
        on update cascade on delete cascade
);

drop table if exists category;
create table category
(
    category_id        int                                      not null auto_increment primary key,
    name               varchar(64)                              not null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null
);

drop table if exists post;
create table post
(
    post_id            int                                      not null auto_increment primary key,
    user_fk            int                                      null,
    category_fk        int                                      null,
    title              varchar(128)                             null,
    content            text                                     null,
    excerpt            text                                     null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null,

    constraint fk_post_user foreign key (user_fk) references user (user_id)
        on update cascade on delete set null,
    constraint fk_category foreign key (category_fk) references category (category_id)
        on update cascade on delete restrict
);

drop table if exists comment;
create table comment
(
    comment_id         int                                      not null auto_increment primary key,
    content            text                                     not null,
    post_fk            int                                      not null,
    user_fk            int                                      not null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null,

    constraint fk_post_user_comment foreign key (post_fk) references post (post_id)
        on update cascade on delete cascade,
    constraint fk_user_post_comment foreign key (user_fk) references user (user_id)
        on update cascade on delete cascade
);

drop table if exists tag;
create table tag
(
    tag_id             int                                      not null auto_increment primary key,
    name               varchar(64)                              not null unique,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null
);

drop table if exists post_tag;
create table post_tag
(
    post_tag_id        int                                      not null auto_increment primary key,
    tag_fk             int                                      not null,
    post_fk            int                                      not null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null,

    constraint fk_tag foreign key (tag_fk) references tag (tag_id)
        on update cascade on delete cascade,
    constraint fk_post foreign key (post_fk) references post (post_id)
        on update cascade on delete cascade
);
set foreign_key_checks = 1;
