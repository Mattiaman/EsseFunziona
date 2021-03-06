PGDMP                          v            robmat56_siwessefunziona    9.6.6    9.6.6 a    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           1262    41302    robmat56_siwessefunziona    DATABASE     �   CREATE DATABASE robmat56_siwessefunziona WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Italian_Italy.1252' LC_CTYPE = 'Italian_Italy.1252';
 (   DROP DATABASE robmat56_siwessefunziona;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12387    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            �           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    41341    admin    TABLE     �   CREATE TABLE admin (
    nomeutente character varying(20) NOT NULL,
    nome character varying(255),
    cognome character varying(255),
    datadinascita date,
    email character varying(255),
    password character varying(20)
);
    DROP TABLE public.admin;
       public         postgres    false    3            �            1259    41449    appartienea    TABLE     e   CREATE TABLE appartienea (
    id bigint NOT NULL,
    idcorso bigint,
    idcorsodilaurea bigint
);
    DROP TABLE public.appartienea;
       public         postgres    false    3            �            1259    41419    appello    TABLE     �   CREATE TABLE appello (
    id bigint NOT NULL,
    dataappello date,
    nomeutenteprofessore character varying(20),
    corsoid bigint
);
    DROP TABLE public.appello;
       public         postgres    false    3            �            1259    41406    bando    TABLE     o   CREATE TABLE bando (
    id bigint NOT NULL,
    contenuto bytea,
    nomeutenteadmin character varying(20)
);
    DROP TABLE public.bando;
       public         postgres    false    3            �            1259    41479    contiene    TABLE     a   CREATE TABLE contiene (
    id bigint NOT NULL,
    idcorso bigint,
    idpianodistudi bigint
);
    DROP TABLE public.contiene;
       public         postgres    false    3            �            1259    41388    corso    TABLE     P   CREATE TABLE corso (
    id bigint NOT NULL,
    nome character varying(255)
);
    DROP TABLE public.corso;
       public         postgres    false    3            �            1259    41305    corsodilaurea    TABLE     }   CREATE TABLE corsodilaurea (
    id bigint NOT NULL,
    nome character varying(255),
    facebook character varying(255)
);
 !   DROP TABLE public.corsodilaurea;
       public         postgres    false    3            �            1259    41434 
   devepagare    TABLE     �   CREATE TABLE devepagare (
    id bigint NOT NULL,
    matricolastudente character(6),
    idtassa bigint,
    pagata boolean
);
    DROP TABLE public.devepagare;
       public         postgres    false    3            �            1259    41524    esame    TABLE     z   CREATE TABLE esame (
    id bigint NOT NULL,
    idappello bigint,
    matricolastudente character(6),
    voto bigint
);
    DROP TABLE public.esame;
       public         postgres    false    3            �            1259    41303 
   idsequenza    SEQUENCE     l   CREATE SEQUENCE idsequenza
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.idsequenza;
       public       postgres    false    3            �            1259    41464    insegna    TABLE     u   CREATE TABLE insegna (
    id bigint NOT NULL,
    idcorso bigint,
    nomeutenteprofessore character varying(20)
);
    DROP TABLE public.insegna;
       public         postgres    false    3            �            1259    41539    libretto    TABLE     }   CREATE TABLE libretto (
    id bigint NOT NULL,
    idappello bigint,
    matricolastudente character(6),
    voto bigint
);
    DROP TABLE public.libretto;
       public         postgres    false    3            �            1259    41393 	   materiale    TABLE     x   CREATE TABLE materiale (
    id bigint NOT NULL,
    contenuto bytea,
    nomeutenteprofessore character varying(20)
);
    DROP TABLE public.materiale;
       public         postgres    false    3            �            1259    41313    pianodistudi    TABLE     s   CREATE TABLE pianodistudi (
    id bigint NOT NULL,
    nome character varying(255),
    corsodilaureaid bigint
);
     DROP TABLE public.pianodistudi;
       public         postgres    false    3            �            1259    41494    prenota    TABLE     }   CREATE TABLE prenota (
    id bigint NOT NULL,
    idappello bigint,
    matricolastudente character(6),
    voto integer
);
    DROP TABLE public.prenota;
       public         postgres    false    3            �            1259    41357 
   professore    TABLE       CREATE TABLE professore (
    nomeutente character varying(20) NOT NULL,
    nome character varying(255),
    cognome character varying(255),
    datadinascita date,
    email character varying(255),
    corsodilaureaid bigint,
    studioid bigint,
    password character varying(20)
);
    DROP TABLE public.professore;
       public         postgres    false    3            �            1259    41554    riceve    TABLE     �   CREATE TABLE riceve (
    id bigint NOT NULL,
    matricolastudente character(6),
    nomeutenteprofessore character varying(20),
    dataricevimento date,
    accettato boolean
);
    DROP TABLE public.riceve;
       public         postgres    false    3            �            1259    41323    studente    TABLE       CREATE TABLE studente (
    matricola character(6) NOT NULL,
    nome character varying(255),
    cognome character varying(255),
    datadinascita date,
    email character varying(255),
    corsodilaureaid bigint,
    pianodistudiid bigint,
    password character varying(20)
);
    DROP TABLE public.studente;
       public         postgres    false    3            �            1259    41349    studio    TABLE     �   CREATE TABLE studio (
    id bigint NOT NULL,
    cubo character varying(255),
    piano character varying(255),
    lat double precision,
    lon double precision
);
    DROP TABLE public.studio;
       public         postgres    false    3            �            1259    41375    tassa    TABLE     �   CREATE TABLE tassa (
    id bigint NOT NULL,
    importo real,
    nome character varying(255),
    descrizione character varying(255),
    nomeutenteadmin character varying(20)
);
    DROP TABLE public.tassa;
       public         postgres    false    3            �            1259    41509    vuolemodificare    TABLE     x   CREATE TABLE vuolemodificare (
    id bigint NOT NULL,
    idpianodistudi bigint,
    matricolastudente character(6)
);
 #   DROP TABLE public.vuolemodificare;
       public         postgres    false    3            �          0    41341    admin 
   TABLE DATA               S   COPY admin (nomeutente, nome, cognome, datadinascita, email, password) FROM stdin;
    public       postgres    false    189   �r       �          0    41449    appartienea 
   TABLE DATA               <   COPY appartienea (id, idcorso, idcorsodilaurea) FROM stdin;
    public       postgres    false    198   �r       �          0    41419    appello 
   TABLE DATA               J   COPY appello (id, dataappello, nomeutenteprofessore, corsoid) FROM stdin;
    public       postgres    false    196   �r       �          0    41406    bando 
   TABLE DATA               8   COPY bando (id, contenuto, nomeutenteadmin) FROM stdin;
    public       postgres    false    195   s       �          0    41479    contiene 
   TABLE DATA               8   COPY contiene (id, idcorso, idpianodistudi) FROM stdin;
    public       postgres    false    200   -s       �          0    41388    corso 
   TABLE DATA               "   COPY corso (id, nome) FROM stdin;
    public       postgres    false    193   Js       �          0    41305    corsodilaurea 
   TABLE DATA               4   COPY corsodilaurea (id, nome, facebook) FROM stdin;
    public       postgres    false    186   gs       �          0    41434 
   devepagare 
   TABLE DATA               E   COPY devepagare (id, matricolastudente, idtassa, pagata) FROM stdin;
    public       postgres    false    197   �s       �          0    41524    esame 
   TABLE DATA               @   COPY esame (id, idappello, matricolastudente, voto) FROM stdin;
    public       postgres    false    203   �s       �           0    0 
   idsequenza    SEQUENCE SET     2   SELECT pg_catalog.setval('idsequenza', 1, false);
            public       postgres    false    185            �          0    41464    insegna 
   TABLE DATA               =   COPY insegna (id, idcorso, nomeutenteprofessore) FROM stdin;
    public       postgres    false    199   �s       �          0    41539    libretto 
   TABLE DATA               C   COPY libretto (id, idappello, matricolastudente, voto) FROM stdin;
    public       postgres    false    204   �s       �          0    41393 	   materiale 
   TABLE DATA               A   COPY materiale (id, contenuto, nomeutenteprofessore) FROM stdin;
    public       postgres    false    194   �s       �          0    41313    pianodistudi 
   TABLE DATA               :   COPY pianodistudi (id, nome, corsodilaureaid) FROM stdin;
    public       postgres    false    187   t       �          0    41494    prenota 
   TABLE DATA               B   COPY prenota (id, idappello, matricolastudente, voto) FROM stdin;
    public       postgres    false    201   2t       �          0    41357 
   professore 
   TABLE DATA               s   COPY professore (nomeutente, nome, cognome, datadinascita, email, corsodilaureaid, studioid, password) FROM stdin;
    public       postgres    false    191   Ot       �          0    41554    riceve 
   TABLE DATA               b   COPY riceve (id, matricolastudente, nomeutenteprofessore, dataricevimento, accettato) FROM stdin;
    public       postgres    false    205   lt       �          0    41323    studente 
   TABLE DATA               v   COPY studente (matricola, nome, cognome, datadinascita, email, corsodilaureaid, pianodistudiid, password) FROM stdin;
    public       postgres    false    188   �t       �          0    41349    studio 
   TABLE DATA               4   COPY studio (id, cubo, piano, lat, lon) FROM stdin;
    public       postgres    false    190   �t       �          0    41375    tassa 
   TABLE DATA               I   COPY tassa (id, importo, nome, descrizione, nomeutenteadmin) FROM stdin;
    public       postgres    false    192   �t       �          0    41509    vuolemodificare 
   TABLE DATA               I   COPY vuolemodificare (id, idpianodistudi, matricolastudente) FROM stdin;
    public       postgres    false    202   �t       ,           2606    41348    admin admin_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (nomeutente);
 :   ALTER TABLE ONLY public.admin DROP CONSTRAINT admin_pkey;
       public         postgres    false    189    189            >           2606    41453    appartienea appartienea_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY appartienea
    ADD CONSTRAINT appartienea_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.appartienea DROP CONSTRAINT appartienea_pkey;
       public         postgres    false    198    198            :           2606    41423    appello appello_pkey 
   CONSTRAINT     K   ALTER TABLE ONLY appello
    ADD CONSTRAINT appello_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.appello DROP CONSTRAINT appello_pkey;
       public         postgres    false    196    196            8           2606    41413    bando bando_pkey 
   CONSTRAINT     G   ALTER TABLE ONLY bando
    ADD CONSTRAINT bando_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.bando DROP CONSTRAINT bando_pkey;
       public         postgres    false    195    195            B           2606    41483    contiene contiene_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY contiene
    ADD CONSTRAINT contiene_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.contiene DROP CONSTRAINT contiene_pkey;
       public         postgres    false    200    200            4           2606    41392    corso corso_pkey 
   CONSTRAINT     G   ALTER TABLE ONLY corso
    ADD CONSTRAINT corso_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.corso DROP CONSTRAINT corso_pkey;
       public         postgres    false    193    193            &           2606    41312     corsodilaurea corsodilaurea_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY corsodilaurea
    ADD CONSTRAINT corsodilaurea_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.corsodilaurea DROP CONSTRAINT corsodilaurea_pkey;
       public         postgres    false    186    186            <           2606    41438    devepagare devepagare_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY devepagare
    ADD CONSTRAINT devepagare_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.devepagare DROP CONSTRAINT devepagare_pkey;
       public         postgres    false    197    197            H           2606    41528    esame esame_pkey 
   CONSTRAINT     G   ALTER TABLE ONLY esame
    ADD CONSTRAINT esame_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.esame DROP CONSTRAINT esame_pkey;
       public         postgres    false    203    203            @           2606    41468    insegna insegna_pkey 
   CONSTRAINT     K   ALTER TABLE ONLY insegna
    ADD CONSTRAINT insegna_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.insegna DROP CONSTRAINT insegna_pkey;
       public         postgres    false    199    199            J           2606    41543    libretto libretto_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY libretto
    ADD CONSTRAINT libretto_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.libretto DROP CONSTRAINT libretto_pkey;
       public         postgres    false    204    204            6           2606    41400    materiale materiale_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY materiale
    ADD CONSTRAINT materiale_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.materiale DROP CONSTRAINT materiale_pkey;
       public         postgres    false    194    194            (           2606    41317    pianodistudi pianodistudi_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY pianodistudi
    ADD CONSTRAINT pianodistudi_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.pianodistudi DROP CONSTRAINT pianodistudi_pkey;
       public         postgres    false    187    187            D           2606    41498    prenota prenota_pkey 
   CONSTRAINT     K   ALTER TABLE ONLY prenota
    ADD CONSTRAINT prenota_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.prenota DROP CONSTRAINT prenota_pkey;
       public         postgres    false    201    201            0           2606    41364    professore professore_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY professore
    ADD CONSTRAINT professore_pkey PRIMARY KEY (nomeutente);
 D   ALTER TABLE ONLY public.professore DROP CONSTRAINT professore_pkey;
       public         postgres    false    191    191            L           2606    41558    riceve riceve_pkey 
   CONSTRAINT     I   ALTER TABLE ONLY riceve
    ADD CONSTRAINT riceve_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.riceve DROP CONSTRAINT riceve_pkey;
       public         postgres    false    205    205            *           2606    41330    studente studente_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY studente
    ADD CONSTRAINT studente_pkey PRIMARY KEY (matricola);
 @   ALTER TABLE ONLY public.studente DROP CONSTRAINT studente_pkey;
       public         postgres    false    188    188            .           2606    41356    studio studio_pkey 
   CONSTRAINT     I   ALTER TABLE ONLY studio
    ADD CONSTRAINT studio_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.studio DROP CONSTRAINT studio_pkey;
       public         postgres    false    190    190            2           2606    41382    tassa tassa_pkey 
   CONSTRAINT     G   ALTER TABLE ONLY tassa
    ADD CONSTRAINT tassa_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.tassa DROP CONSTRAINT tassa_pkey;
       public         postgres    false    192    192            F           2606    41513 $   vuolemodificare vuolemodificare_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY vuolemodificare
    ADD CONSTRAINT vuolemodificare_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.vuolemodificare DROP CONSTRAINT vuolemodificare_pkey;
       public         postgres    false    202    202            Y           2606    41454 $   appartienea appartienea_idcorso_fkey    FK CONSTRAINT     u   ALTER TABLE ONLY appartienea
    ADD CONSTRAINT appartienea_idcorso_fkey FOREIGN KEY (idcorso) REFERENCES corso(id);
 N   ALTER TABLE ONLY public.appartienea DROP CONSTRAINT appartienea_idcorso_fkey;
       public       postgres    false    2100    198    193            Z           2606    41459 ,   appartienea appartienea_idcorsodilaurea_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY appartienea
    ADD CONSTRAINT appartienea_idcorsodilaurea_fkey FOREIGN KEY (idcorsodilaurea) REFERENCES corsodilaurea(id);
 V   ALTER TABLE ONLY public.appartienea DROP CONSTRAINT appartienea_idcorsodilaurea_fkey;
       public       postgres    false    186    198    2086            V           2606    41429    appello appello_corsoid_fkey    FK CONSTRAINT     m   ALTER TABLE ONLY appello
    ADD CONSTRAINT appello_corsoid_fkey FOREIGN KEY (corsoid) REFERENCES corso(id);
 F   ALTER TABLE ONLY public.appello DROP CONSTRAINT appello_corsoid_fkey;
       public       postgres    false    196    193    2100            U           2606    41424 )   appello appello_nomeutenteprofessore_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY appello
    ADD CONSTRAINT appello_nomeutenteprofessore_fkey FOREIGN KEY (nomeutenteprofessore) REFERENCES professore(nomeutente);
 S   ALTER TABLE ONLY public.appello DROP CONSTRAINT appello_nomeutenteprofessore_fkey;
       public       postgres    false    2096    196    191            T           2606    41414     bando bando_nomeutenteadmin_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY bando
    ADD CONSTRAINT bando_nomeutenteadmin_fkey FOREIGN KEY (nomeutenteadmin) REFERENCES admin(nomeutente);
 J   ALTER TABLE ONLY public.bando DROP CONSTRAINT bando_nomeutenteadmin_fkey;
       public       postgres    false    189    2092    195            ]           2606    41484    contiene contiene_idcorso_fkey    FK CONSTRAINT     o   ALTER TABLE ONLY contiene
    ADD CONSTRAINT contiene_idcorso_fkey FOREIGN KEY (idcorso) REFERENCES corso(id);
 H   ALTER TABLE ONLY public.contiene DROP CONSTRAINT contiene_idcorso_fkey;
       public       postgres    false    2100    200    193            ^           2606    41489 %   contiene contiene_idpianodistudi_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY contiene
    ADD CONSTRAINT contiene_idpianodistudi_fkey FOREIGN KEY (idpianodistudi) REFERENCES pianodistudi(id);
 O   ALTER TABLE ONLY public.contiene DROP CONSTRAINT contiene_idpianodistudi_fkey;
       public       postgres    false    200    187    2088            X           2606    41444 "   devepagare devepagare_idtassa_fkey    FK CONSTRAINT     s   ALTER TABLE ONLY devepagare
    ADD CONSTRAINT devepagare_idtassa_fkey FOREIGN KEY (idtassa) REFERENCES tassa(id);
 L   ALTER TABLE ONLY public.devepagare DROP CONSTRAINT devepagare_idtassa_fkey;
       public       postgres    false    197    2098    192            W           2606    41439 ,   devepagare devepagare_matricolastudente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY devepagare
    ADD CONSTRAINT devepagare_matricolastudente_fkey FOREIGN KEY (matricolastudente) REFERENCES studente(matricola);
 V   ALTER TABLE ONLY public.devepagare DROP CONSTRAINT devepagare_matricolastudente_fkey;
       public       postgres    false    2090    188    197            c           2606    41529    esame esame_idappello_fkey    FK CONSTRAINT     o   ALTER TABLE ONLY esame
    ADD CONSTRAINT esame_idappello_fkey FOREIGN KEY (idappello) REFERENCES appello(id);
 D   ALTER TABLE ONLY public.esame DROP CONSTRAINT esame_idappello_fkey;
       public       postgres    false    203    2106    196            d           2606    41534 "   esame esame_matricolastudente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY esame
    ADD CONSTRAINT esame_matricolastudente_fkey FOREIGN KEY (matricolastudente) REFERENCES studente(matricola);
 L   ALTER TABLE ONLY public.esame DROP CONSTRAINT esame_matricolastudente_fkey;
       public       postgres    false    203    2090    188            [           2606    41469    insegna insegna_idcorso_fkey    FK CONSTRAINT     m   ALTER TABLE ONLY insegna
    ADD CONSTRAINT insegna_idcorso_fkey FOREIGN KEY (idcorso) REFERENCES corso(id);
 F   ALTER TABLE ONLY public.insegna DROP CONSTRAINT insegna_idcorso_fkey;
       public       postgres    false    199    193    2100            \           2606    41474 )   insegna insegna_nomeutenteprofessore_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY insegna
    ADD CONSTRAINT insegna_nomeutenteprofessore_fkey FOREIGN KEY (nomeutenteprofessore) REFERENCES professore(nomeutente);
 S   ALTER TABLE ONLY public.insegna DROP CONSTRAINT insegna_nomeutenteprofessore_fkey;
       public       postgres    false    191    199    2096            e           2606    41544     libretto libretto_idappello_fkey    FK CONSTRAINT     u   ALTER TABLE ONLY libretto
    ADD CONSTRAINT libretto_idappello_fkey FOREIGN KEY (idappello) REFERENCES appello(id);
 J   ALTER TABLE ONLY public.libretto DROP CONSTRAINT libretto_idappello_fkey;
       public       postgres    false    204    2106    196            f           2606    41549 (   libretto libretto_matricolastudente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY libretto
    ADD CONSTRAINT libretto_matricolastudente_fkey FOREIGN KEY (matricolastudente) REFERENCES studente(matricola);
 R   ALTER TABLE ONLY public.libretto DROP CONSTRAINT libretto_matricolastudente_fkey;
       public       postgres    false    2090    204    188            S           2606    41401 -   materiale materiale_nomeutenteprofessore_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY materiale
    ADD CONSTRAINT materiale_nomeutenteprofessore_fkey FOREIGN KEY (nomeutenteprofessore) REFERENCES professore(nomeutente);
 W   ALTER TABLE ONLY public.materiale DROP CONSTRAINT materiale_nomeutenteprofessore_fkey;
       public       postgres    false    191    2096    194            M           2606    41318 .   pianodistudi pianodistudi_corsodilaureaid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY pianodistudi
    ADD CONSTRAINT pianodistudi_corsodilaureaid_fkey FOREIGN KEY (corsodilaureaid) REFERENCES corsodilaurea(id);
 X   ALTER TABLE ONLY public.pianodistudi DROP CONSTRAINT pianodistudi_corsodilaureaid_fkey;
       public       postgres    false    187    186    2086            _           2606    41499    prenota prenota_idappello_fkey    FK CONSTRAINT     s   ALTER TABLE ONLY prenota
    ADD CONSTRAINT prenota_idappello_fkey FOREIGN KEY (idappello) REFERENCES appello(id);
 H   ALTER TABLE ONLY public.prenota DROP CONSTRAINT prenota_idappello_fkey;
       public       postgres    false    2106    196    201            `           2606    41504 &   prenota prenota_matricolastudente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY prenota
    ADD CONSTRAINT prenota_matricolastudente_fkey FOREIGN KEY (matricolastudente) REFERENCES studente(matricola);
 P   ALTER TABLE ONLY public.prenota DROP CONSTRAINT prenota_matricolastudente_fkey;
       public       postgres    false    201    2090    188            P           2606    41365 *   professore professore_corsodilaureaid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY professore
    ADD CONSTRAINT professore_corsodilaureaid_fkey FOREIGN KEY (corsodilaureaid) REFERENCES corsodilaurea(id);
 T   ALTER TABLE ONLY public.professore DROP CONSTRAINT professore_corsodilaureaid_fkey;
       public       postgres    false    191    186    2086            Q           2606    41370 #   professore professore_studioid_fkey    FK CONSTRAINT     v   ALTER TABLE ONLY professore
    ADD CONSTRAINT professore_studioid_fkey FOREIGN KEY (studioid) REFERENCES studio(id);
 M   ALTER TABLE ONLY public.professore DROP CONSTRAINT professore_studioid_fkey;
       public       postgres    false    191    2094    190            g           2606    41559 $   riceve riceve_matricolastudente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY riceve
    ADD CONSTRAINT riceve_matricolastudente_fkey FOREIGN KEY (matricolastudente) REFERENCES studente(matricola);
 N   ALTER TABLE ONLY public.riceve DROP CONSTRAINT riceve_matricolastudente_fkey;
       public       postgres    false    188    2090    205            h           2606    41564 '   riceve riceve_nomeutenteprofessore_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY riceve
    ADD CONSTRAINT riceve_nomeutenteprofessore_fkey FOREIGN KEY (nomeutenteprofessore) REFERENCES professore(nomeutente);
 Q   ALTER TABLE ONLY public.riceve DROP CONSTRAINT riceve_nomeutenteprofessore_fkey;
       public       postgres    false    2096    205    191            N           2606    41331 &   studente studente_corsodilaureaid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY studente
    ADD CONSTRAINT studente_corsodilaureaid_fkey FOREIGN KEY (corsodilaureaid) REFERENCES corsodilaurea(id);
 P   ALTER TABLE ONLY public.studente DROP CONSTRAINT studente_corsodilaureaid_fkey;
       public       postgres    false    188    186    2086            O           2606    41336 %   studente studente_pianodistudiid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY studente
    ADD CONSTRAINT studente_pianodistudiid_fkey FOREIGN KEY (pianodistudiid) REFERENCES pianodistudi(id);
 O   ALTER TABLE ONLY public.studente DROP CONSTRAINT studente_pianodistudiid_fkey;
       public       postgres    false    2088    187    188            R           2606    41383     tassa tassa_nomeutenteadmin_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY tassa
    ADD CONSTRAINT tassa_nomeutenteadmin_fkey FOREIGN KEY (nomeutenteadmin) REFERENCES admin(nomeutente);
 J   ALTER TABLE ONLY public.tassa DROP CONSTRAINT tassa_nomeutenteadmin_fkey;
       public       postgres    false    192    2092    189            a           2606    41514 3   vuolemodificare vuolemodificare_idpianodistudi_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY vuolemodificare
    ADD CONSTRAINT vuolemodificare_idpianodistudi_fkey FOREIGN KEY (idpianodistudi) REFERENCES pianodistudi(id);
 ]   ALTER TABLE ONLY public.vuolemodificare DROP CONSTRAINT vuolemodificare_idpianodistudi_fkey;
       public       postgres    false    202    187    2088            b           2606    41519 6   vuolemodificare vuolemodificare_matricolastudente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY vuolemodificare
    ADD CONSTRAINT vuolemodificare_matricolastudente_fkey FOREIGN KEY (matricolastudente) REFERENCES studente(matricola);
 `   ALTER TABLE ONLY public.vuolemodificare DROP CONSTRAINT vuolemodificare_matricolastudente_fkey;
       public       postgres    false    188    2090    202            �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �     