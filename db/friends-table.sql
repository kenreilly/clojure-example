-- SEQUENCE: public.friends_id_seq

-- DROP SEQUENCE public.friends_id_seq;

CREATE SEQUENCE public.friends_id_seq;

ALTER SEQUENCE public.friends_id_seq
    OWNER TO clojure_pg_user;


-- Table: public.friends

-- DROP TABLE public.friends;

CREATE TABLE public.friends
(
    id integer NOT NULL DEFAULT nextval('friends_id_seq'::regclass),
    name character varying(16) COLLATE pg_catalog."default" NOT NULL,
	nickname character varying(16) COLLATE pg_catalog."default",
    occupation character varying(32) COLLATE pg_catalog."default",
    create_timestamp timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT friends_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.friends
    OWNER to clojure_pg_user;