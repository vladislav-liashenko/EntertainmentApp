toc.dat                                                                                             0000600 0004000 0002000 00000013353 13676643735 0014470 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP       %    
                x           MyEntertainmentApp    9.6.16    9.6.16     c           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false         d           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false         e           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false         f           1262    17200    MyEntertainmentApp    DATABASE     �   CREATE DATABASE "MyEntertainmentApp" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Ukrainian_Ukraine.1251' LC_CTYPE = 'Ukrainian_Ukraine.1251';
 $   DROP DATABASE "MyEntertainmentApp";
             postgres    false                     2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false         g           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                     3079    12387    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false         h           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1         �            1259    17201    category    TABLE     Z   CREATE TABLE public.category (
    id bigint NOT NULL,
    name character varying(255)
);
    DROP TABLE public.category;
       public         postgres    false    3         �            1259    17206    entertainments    TABLE     �   CREATE TABLE public.entertainments (
    id bigint NOT NULL,
    address character varying(255),
    date date,
    description character varying(255),
    filename character varying(255),
    name character varying(255),
    category_id bigint
);
 "   DROP TABLE public.entertainments;
       public         postgres    false    3         �            1259    17225    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public       postgres    false    3         �            1259    17214    users    TABLE     �   CREATE TABLE public.users (
    id bigint NOT NULL,
    active boolean,
    password character varying(255),
    username character varying(255)
);
    DROP TABLE public.users;
       public         postgres    false    3         �            1259    17222    users_roles    TABLE     c   CREATE TABLE public.users_roles (
    users_id bigint NOT NULL,
    role character varying(255)
);
    DROP TABLE public.users_roles;
       public         postgres    false    3         \          0    17201    category 
   TABLE DATA               ,   COPY public.category (id, name) FROM stdin;
    public       postgres    false    185       2140.dat ]          0    17206    entertainments 
   TABLE DATA               e   COPY public.entertainments (id, address, date, description, filename, name, category_id) FROM stdin;
    public       postgres    false    186       2141.dat i           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 14, true);
            public       postgres    false    189         ^          0    17214    users 
   TABLE DATA               ?   COPY public.users (id, active, password, username) FROM stdin;
    public       postgres    false    187       2142.dat _          0    17222    users_roles 
   TABLE DATA               5   COPY public.users_roles (users_id, role) FROM stdin;
    public       postgres    false    188       2143.dat �           2606    17205    category category_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.category DROP CONSTRAINT category_pkey;
       public         postgres    false    185    185         �           2606    17213 "   entertainments entertainments_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.entertainments
    ADD CONSTRAINT entertainments_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.entertainments DROP CONSTRAINT entertainments_pkey;
       public         postgres    false    186    186         �           2606    17221    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public         postgres    false    187    187         �           2606    17227 *   entertainments fk5t0ohlr4p0691fbqi8y5ndtm2    FK CONSTRAINT     �   ALTER TABLE ONLY public.entertainments
    ADD CONSTRAINT fk5t0ohlr4p0691fbqi8y5ndtm2 FOREIGN KEY (category_id) REFERENCES public.category(id);
 T   ALTER TABLE ONLY public.entertainments DROP CONSTRAINT fk5t0ohlr4p0691fbqi8y5ndtm2;
       public       postgres    false    2016    186    185         �           2606    17232 '   users_roles fkml90kef4w2jy7oxyqv742tsfc    FK CONSTRAINT     �   ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fkml90kef4w2jy7oxyqv742tsfc FOREIGN KEY (users_id) REFERENCES public.users(id);
 Q   ALTER TABLE ONLY public.users_roles DROP CONSTRAINT fkml90kef4w2jy7oxyqv742tsfc;
       public       postgres    false    187    188    2020                                                                                                                                                                                                                                                                                             2140.dat                                                                                            0000600 0004000 0002000 00000000042 13676643735 0014260 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        2	Cinema
3	Bowling
4	ZooPark
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              2141.dat                                                                                            0000600 0004000 0002000 00000001537 13676643735 0014273 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        5	Bohdana Hmel 1	2020-07-21	Good cinema.	0cb62482-1a75-4b25-896f-22b75b149f06.1.jpg	Cinema	2
7	Zologichna 12	2020-07-27	Good zoopark!	0e367ee9-97ec-4793-817b-be60ac081848.2.jpg	ZooPark	4
8	Browarska 19/1	2020-07-30	Good bowling.	44c92422-1152-446d-98c0-966f4c955538.3.jpg	Bowling	3
9	Verbitskogo 15	2020-08-10	Very good cinema.	95c92338-3232-45dd-b430-892bb7dc93a4.1.jpg	Cinema	2
10	Volinska 1	2020-07-12	No bad bowling!	2f62238f-b599-4eda-80a9-05c93961113c.3.jpg	Bowling	3
11	Zoologichna 111	2020-09-28	Good zoopark!	4272e350-c447-4214-83ea-ddc5012c4339.2.jpg	ZooPark	4
6	Bohdana Hmel 1	2020-03-08	Good bowling.	\N	Bowling	\N
12	Revutskogo 46	2020-03-09	Goog billiards	\N	Billiards	\N
13	Zoologichna 119	2020-10-03	Good zoopark!	\N	ZooPark	\N
14	Airfield "Kiev-South"	2020-05-09	The best parachute jumps	\N	Skydiving	\N
3	pol	2020-01-01	trewcs	\N	Cinema	\N
\.


                                                                                                                                                                 2142.dat                                                                                            0000600 0004000 0002000 00000000556 13676643735 0014274 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	t	$2a$10$etSivsrXd0nSy.YKQ1taWeaNmBiCKzj/WHLq17qIpLl4LkpF/.CnK	admin
12	t	$2a$10$zbntm4w2pXGj4NE4f5fnGurSY9U5xuIkEbztTkkFSg55VE1xu9Ck6	User1
2	t	$2a$10$mOc80yC8rBIVFRS7SwQ.YO3HCGN0Y3UH8VMxPHRoQczGgWk.6VVY.	Vladik
3	t	$2a$10$5JOHFCn2a4jkc70zSWM2jOh/9RHmFzsXxEz3oFRxLx3dGpeYg7HDu	Sergey
4	t	$2a$10$uNwH6CrIO7VXZ5raUeognuUvXTemuOgtpxqiYhEGU9LjZMluooyeu	Agent007
\.


                                                                                                                                                  2143.dat                                                                                            0000600 0004000 0002000 00000000062 13676643735 0014265 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	ADMIN
12	USER
1	USER
2	USER
3	USER
4	ADMIN
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                              restore.sql                                                                                         0000600 0004000 0002000 00000012251 13676643735 0015411 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.16
-- Dumped by pg_dump version 9.6.16

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

ALTER TABLE ONLY public.users_roles DROP CONSTRAINT fkml90kef4w2jy7oxyqv742tsfc;
ALTER TABLE ONLY public.entertainments DROP CONSTRAINT fk5t0ohlr4p0691fbqi8y5ndtm2;
ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
ALTER TABLE ONLY public.entertainments DROP CONSTRAINT entertainments_pkey;
ALTER TABLE ONLY public.category DROP CONSTRAINT category_pkey;
DROP TABLE public.users_roles;
DROP TABLE public.users;
DROP SEQUENCE public.hibernate_sequence;
DROP TABLE public.entertainments;
DROP TABLE public.category;
DROP EXTENSION plpgsql;
DROP SCHEMA public;
--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.category OWNER TO postgres;

--
-- Name: entertainments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.entertainments (
    id bigint NOT NULL,
    address character varying(255),
    date date,
    description character varying(255),
    filename character varying(255),
    name character varying(255),
    category_id bigint
);


ALTER TABLE public.entertainments OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    active boolean,
    password character varying(255),
    username character varying(255)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_roles (
    users_id bigint NOT NULL,
    role character varying(255)
);


ALTER TABLE public.users_roles OWNER TO postgres;

--
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.category (id, name) FROM stdin;
\.
COPY public.category (id, name) FROM '$$PATH$$/2140.dat';

--
-- Data for Name: entertainments; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.entertainments (id, address, date, description, filename, name, category_id) FROM stdin;
\.
COPY public.entertainments (id, address, date, description, filename, name, category_id) FROM '$$PATH$$/2141.dat';

--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 14, true);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, active, password, username) FROM stdin;
\.
COPY public.users (id, active, password, username) FROM '$$PATH$$/2142.dat';

--
-- Data for Name: users_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users_roles (users_id, role) FROM stdin;
\.
COPY public.users_roles (users_id, role) FROM '$$PATH$$/2143.dat';

--
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- Name: entertainments entertainments_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entertainments
    ADD CONSTRAINT entertainments_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: entertainments fk5t0ohlr4p0691fbqi8y5ndtm2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entertainments
    ADD CONSTRAINT fk5t0ohlr4p0691fbqi8y5ndtm2 FOREIGN KEY (category_id) REFERENCES public.category(id);


--
-- Name: users_roles fkml90kef4w2jy7oxyqv742tsfc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fkml90kef4w2jy7oxyqv742tsfc FOREIGN KEY (users_id) REFERENCES public.users(id);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       