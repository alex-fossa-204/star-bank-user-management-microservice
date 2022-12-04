--liquibase formatted sql
--changeset alex-fossa-204:2

DROP TABLE IF EXISTS api_user;
DROP TABLE IF EXISTS passport;