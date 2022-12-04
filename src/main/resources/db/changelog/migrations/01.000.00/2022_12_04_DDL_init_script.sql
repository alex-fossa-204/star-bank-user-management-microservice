--liquibase formatted sql
--changeset alex-fossa-204:2

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS public.passport
(
    id	uuid	DEFAULT uuid_generate_v4(),
    lastname        character varying(64),
    firstname       character varying(64),
    surname         character varying(64),
    birthday_date   timestamp without time zone,
    issue_date      timestamp without time zone,
    passport_serial character varying(64),
    expiration_date timestamp without time zone,
    is_us_resident  boolean,
    public_uuid         uuid NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT serial_identifier_ct UNIQUE (passport_serial),
    CONSTRAINT passport_uid_unique_ct UNIQUE (public_uuid)
);

CREATE TABLE IF NOT EXISTS public.api_user
(
    id          uuid	DEFAULT uuid_generate_v4(),
    public_uuid         uuid	NOT NULL,
    role_id     uuid,
    passport_id uuid,
    image_url   character varying(128),
    PRIMARY KEY (id),
    CONSTRAINT api_user_uid_unique_ct UNIQUE (public_uuid)
);

ALTER TABLE IF EXISTS public.api_user
    ADD CONSTRAINT passport_passports_fk FOREIGN KEY (passport_id)
        REFERENCES public.passport (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID;
