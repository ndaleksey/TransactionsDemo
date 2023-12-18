create table if not exists department
(
    id   uuid primary key,
    name text not null unique
);

create table if not exists notification
(
    id   uuid primary key,
    message varchar not null
);