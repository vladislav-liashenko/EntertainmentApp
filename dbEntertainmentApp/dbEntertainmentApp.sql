--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.16
-- Dumped by pg_dump version 9.6.16

-- Started on 2020-02-28 16:20:36

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

--
-- TOC entry 2142 (class 1262 OID 16684)
-- Name: dbEntertainmentApp; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "dbEntertainmentApp" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Ukrainian_Ukraine.1251' LC_CTYPE = 'Ukrainian_Ukraine.1251';


ALTER DATABASE "dbEntertainmentApp" OWNER TO postgres;

\connect "dbEntertainmentApp"

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

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2145 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 16685)
-- Name: entertainments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.entertainments (
    id bigint NOT NULL,
    address character varying(255),
    date date,
    description character varying(255),
    name character varying(255)
);


ALTER TABLE public.entertainments OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 16691)
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
-- TOC entry 187 (class 1259 OID 16693)
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
-- TOC entry 188 (class 1259 OID 16699)
-- Name: users_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_roles (
    users_id bigint NOT NULL,
    role character varying(255)
);


ALTER TABLE public.users_roles OWNER TO postgres;

--
-- TOC entry 2133 (class 0 OID 16685)
-- Dependencies: 185
-- Data for Name: entertainments; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.entertainments (id, address, date, description, name) VALUES (5, 'Zologichna 12', '2020-03-08', 'Good zoopark!', 'ZooPark');
INSERT INTO public.entertainments (id, address, date, description, name) VALUES (6, 'Bohdana Hmel 1', '2020-03-08', 'Good bowling.', 'Bowling');
INSERT INTO public.entertainments (id, address, date, description, name) VALUES (7, 'Browarska 19/1', '2020-03-08', 'Good zoopark!', 'Aquapark');
INSERT INTO public.entertainments (id, address, date, description, name) VALUES (8, 'poliska 10', '2020-03-08', 'Good cinema.', 'Cinema');
INSERT INTO public.entertainments (id, address, date, description, name) VALUES (11, 'Verbitskogo 15', '2020-03-08', 'No bad cinema', 'Cinema');
INSERT INTO public.entertainments (id, address, date, description, name) VALUES (12, 'Revutskogo 46', '2020-03-09', 'Goog billiards', 'Billiards');
INSERT INTO public.entertainments (id, address, date, description, name) VALUES (13, 'Zoologichna 119', '2020-10-03', 'Good zoopark!', 'ZooPark');
INSERT INTO public.entertainments (id, address, date, description, name) VALUES (14, 'Airfield "Kiev-South"', '2020-05-09', 'The best parachute jumps', 'Skydiving');


--
-- TOC entry 2146 (class 0 OID 0)
-- Dependencies: 186
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 14, true);


--
-- TOC entry 2135 (class 0 OID 16693)
-- Dependencies: 187
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users (id, active, password, username) VALUES (1, true, '$2a$10$PMOT0Hjji9bKravJHfCvUeqWb/qoSWoO9NgnXhWrGNdhUqPdZxOgG', 'User1');
INSERT INTO public.users (id, active, password, username) VALUES (2, true, '$2a$10$mOc80yC8rBIVFRS7SwQ.YO3HCGN0Y3UH8VMxPHRoQczGgWk.6VVY.', 'Vladik');
INSERT INTO public.users (id, active, password, username) VALUES (3, true, '$2a$10$5JOHFCn2a4jkc70zSWM2jOh/9RHmFzsXxEz3oFRxLx3dGpeYg7HDu', 'Sergey');
INSERT INTO public.users (id, active, password, username) VALUES (4, true, '$2a$10$uNwH6CrIO7VXZ5raUeognuUvXTemuOgtpxqiYhEGU9LjZMluooyeu', 'Agent007');


--
-- TOC entry 2136 (class 0 OID 16699)
-- Dependencies: 188
-- Data for Name: users_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users_roles (users_id, role) VALUES (1, 'USER');
INSERT INTO public.users_roles (users_id, role) VALUES (2, 'USER');
INSERT INTO public.users_roles (users_id, role) VALUES (3, 'USER');
INSERT INTO public.users_roles (users_id, role) VALUES (4, 'ADMIN');


--
-- TOC entry 2012 (class 2606 OID 16703)
-- Name: entertainments entertainments_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entertainments
    ADD CONSTRAINT entertainments_pkey PRIMARY KEY (id);


--
-- TOC entry 2014 (class 2606 OID 16705)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2015 (class 2606 OID 16706)
-- Name: users_roles fkml90kef4w2jy7oxyqv742tsfc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fkml90kef4w2jy7oxyqv742tsfc FOREIGN KEY (users_id) REFERENCES public.users(id);


--
-- TOC entry 2144 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2020-02-28 16:20:36

--
-- PostgreSQL database dump complete
--
