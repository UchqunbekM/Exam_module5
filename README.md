# Exam_module5
User tableda roleda ADMIN berish kere 
Login parol bilan 


Database table's :

create table users
(
    id       bigserial
        primary key,
    username varchar,
    password varchar,
    email    varchar,
    role     varchar
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
