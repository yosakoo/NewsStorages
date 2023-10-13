create table news
(
    id          bigserial primary key,
    company_tag      text not null,
    content          text not null
);