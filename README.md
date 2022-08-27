# Exam_module5

Login for admin panel: admin
Password:   admin


Database table's :

create table users
(
    id       bigserial
        primary key,
    username varchar,
    password varchar,
    email    varchar
);

create table category
(
    id   bigserial
        primary key,
    name varchar
);

create table product
(
    id    bigserial  primary key,
    title       varchar,
    category_id bigint
        constraint product_category_id_fkey
            references category,
    "imgUrl"    varchar,
    description varchar
);
