set foreign_key_checks = 0;

create table category
(
    category_id        int auto_increment
        primary key,
    name               varchar(64)                              not null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null
);

create table role
(
    role_id            int auto_increment
        primary key,
    role               varchar(64)                              not null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null
);

create table tag
(
    tag_id             int auto_increment
        primary key,
    name               varchar(64)                              not null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null,
    constraint name
        unique (name)
);

create table user
(
    user_id            int auto_increment
        primary key,
    username           varchar(64)                              not null,
    password           varchar(64)                              not null,
    first_name         varchar(64)                              null,
    last_name          varchar(64)                              null,
    display_name       varchar(64)                              null,
    email              varchar(64)                              null,
    about              text                                     null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null,
    constraint username
        unique (username)
);

create table post
(
    post_id            int auto_increment
        primary key,
    user_fk            int                                      null,
    category_fk        int                                      null,
    title              varchar(96)                              null,
    content            text                                     null,
    excerpt            text                                     null,
    published          tinyint(1)   default 0                   null,
    url_slug           varchar(512)                             null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null,
    constraint fk_category
        foreign key (category_fk) references category (category_id)
            on update cascade,
    constraint fk_post_user
        foreign key (user_fk) references user (user_id)
            on update cascade on delete set null
);

create table comment
(
    comment_id         int auto_increment
        primary key,
    content            text                                     not null,
    post_fk            int                                      not null,
    user_fk            int                                      not null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null,
    constraint fk_post_user_comment
        foreign key (post_fk) references post (post_id)
            on update cascade on delete cascade,
    constraint fk_user_post_comment
        foreign key (user_fk) references user (user_id)
            on update cascade on delete cascade
);

create table post_tag
(
    post_tag_id        int auto_increment
        primary key,
    tag_fk             int                                      not null,
    post_fk            int                                      not null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null,
    constraint fk_post
        foreign key (post_fk) references post (post_id)
            on update cascade on delete cascade,
    constraint fk_tag
        foreign key (tag_fk) references tag (tag_id)
            on update cascade on delete cascade
);

create table user_role
(
    user_role_id       int auto_increment
        primary key,
    role_fk            int                                      not null,
    user_fk            int                                      not null,
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null,
    constraint fk_role
        foreign key (role_fk) references role (role_id)
            on update cascade on delete cascade,
    constraint fk_user
        foreign key (user_fk) references user (user_id)
            on update cascade on delete cascade
);

create table media
(
    media_id           int auto_increment primary key           not null,
    uri                varchar(512),
    last_modified_date timestamp    default current_timestamp() null,
    last_modified_by   varchar(128) default 'system'            null,
    created_date       timestamp    default current_timestamp() null,
    record_status      int          default 1                   null
);

set foreign_key_checks = 1;
