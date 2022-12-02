CREATE SEQUENCE IF NOT EXISTS author_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE IF NOT EXISTS "public"."author" (
                                   "id" integer DEFAULT nextval('author_id_seq') NOT NULL,
                                   "name" character varying(255),
                                   "password" character varying(255),
                                   CONSTRAINT "author_pkey" PRIMARY KEY ("id"),
                                   CONSTRAINT "uk_or6k6jmywerxbme223c988bmg" UNIQUE ("name")
) ;


CREATE SEQUENCE IF NOT EXISTS message_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE IF NOT EXISTS "public"."message" (
                                    "id" integer DEFAULT nextval('message_id_seq') NOT NULL,
                                    "message" character varying(255),
                                    "author_id" integer REFERENCES author(id),
                                    CONSTRAINT "message_pkey" PRIMARY KEY ("id")
) ;


