-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Host: sql11.freemysqlhosting.net
-- Creato il: Gen 22, 2018 alle 10:34
-- Versione del server: 5.5.58-0ubuntu0.14.04.1
-- Versione PHP: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sql11217105`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `admin`
--

CREATE TABLE `admin` (
  `nomeUtente` varchar(20) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `cognome` varchar(255) DEFAULT NULL,
  `dataDiNascita` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `appartieneA`
--

CREATE TABLE `appartieneA` (
  `id` bigint(20) NOT NULL,
  `idCorso` bigint(20) DEFAULT NULL,
  `idCorsoDiLaurea` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `appello`
--

CREATE TABLE `appello` (
  `id` bigint(20) NOT NULL,
  `dataAppello` date DEFAULT NULL,
  `nomeUtenteProfessore` varchar(20) DEFAULT NULL,
  `corsoId` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `bando`
--

CREATE TABLE `bando` (
  `id` bigint(20) NOT NULL,
  `contenuto` blob,
  `nomeUtenteAdmin` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `contiene`
--

CREATE TABLE `contiene` (
  `id` bigint(20) NOT NULL,
  `idCorso` bigint(20) DEFAULT NULL,
  `idPianoDiStudi` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `corso`
--

CREATE TABLE `corso` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `corsoDiLaurea`
--

CREATE TABLE `corsoDiLaurea` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `devePagare`
--

CREATE TABLE `devePagare` (
  `id` bigint(20) NOT NULL,
  `matricolaStudente` char(6) DEFAULT NULL,
  `idTassa` bigint(20) DEFAULT NULL,
  `pagata` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `esame`
--

CREATE TABLE `esame` (
  `id` bigint(20) NOT NULL,
  `idAppello` bigint(20) DEFAULT NULL,
  `matricolaStudente` char(6) DEFAULT NULL,
  `voto` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `insegna`
--

CREATE TABLE `insegna` (
  `id` bigint(20) NOT NULL,
  `idCorso` bigint(20) DEFAULT NULL,
  `nomeUtenteProfessore` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `libretto`
--

CREATE TABLE `libretto` (
  `id` bigint(20) NOT NULL,
  `idAppello` bigint(20) DEFAULT NULL,
  `matricolaStudente` char(6) DEFAULT NULL,
  `voto` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `materiale`
--

CREATE TABLE `materiale` (
  `id` bigint(20) NOT NULL,
  `contenuto` blob,
  `nomeUtenteProfessore` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `pianoDiStudi`
--

CREATE TABLE `pianoDiStudi` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `corsoDiLaureaId` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `prenota`
--

CREATE TABLE `prenota` (
  `id` bigint(20) NOT NULL,
  `idAppello` bigint(20) DEFAULT NULL,
  `matricolaStudente` char(6) DEFAULT NULL,
  `voto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `professore`
--

CREATE TABLE `professore` (
  `nomeUtente` varchar(20) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `cognome` varchar(255) DEFAULT NULL,
  `dataDiNascita` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `corsoDiLaureaId` bigint(20) DEFAULT NULL,
  `studioId` bigint(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `riceve`
--

CREATE TABLE `riceve` (
  `id` bigint(20) NOT NULL,
  `matricolaStudente` char(6) DEFAULT NULL,
  `nomeUtenteProfessore` varchar(20) DEFAULT NULL,
  `dataRicevimento` date DEFAULT NULL,
  `accettato` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `studente`
--

CREATE TABLE `studente` (
  `matricola` char(6) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `cognome` varchar(255) DEFAULT NULL,
  `dataDiNascita` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `corsoDiLaureaId` bigint(20) DEFAULT NULL,
  `pianoDiStudiId` bigint(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `studio`
--

CREATE TABLE `studio` (
  `id` bigint(20) NOT NULL,
  `cubo` varchar(255) DEFAULT NULL,
  `piano` varchar(255) DEFAULT NULL,
  `lat` bigint(20) DEFAULT NULL,
  `lon` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `tassa`
--

CREATE TABLE `tassa` (
  `id` bigint(20) NOT NULL,
  `importo` double DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `descrizione` varchar(255) DEFAULT NULL,
  `nomeUtenteAdmin` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `vuoleModificare`
--

CREATE TABLE `vuoleModificare` (
  `id` bigint(20) NOT NULL,
  `idPianoDiStudi` bigint(20) DEFAULT NULL,
  `matricolaStudente` char(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`nomeUtente`);

--
-- Indici per le tabelle `appartieneA`
--
ALTER TABLE `appartieneA`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `appello`
--
ALTER TABLE `appello`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `bando`
--
ALTER TABLE `bando`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `contiene`
--
ALTER TABLE `contiene`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `corso`
--
ALTER TABLE `corso`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `corsoDiLaurea`
--
ALTER TABLE `corsoDiLaurea`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `devePagare`
--
ALTER TABLE `devePagare`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `esame`
--
ALTER TABLE `esame`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `insegna`
--
ALTER TABLE `insegna`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `libretto`
--
ALTER TABLE `libretto`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `materiale`
--
ALTER TABLE `materiale`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `pianoDiStudi`
--
ALTER TABLE `pianoDiStudi`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `prenota`
--
ALTER TABLE `prenota`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `professore`
--
ALTER TABLE `professore`
  ADD PRIMARY KEY (`nomeUtente`);

--
-- Indici per le tabelle `riceve`
--
ALTER TABLE `riceve`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `studente`
--
ALTER TABLE `studente`
  ADD PRIMARY KEY (`matricola`);

--
-- Indici per le tabelle `studio`
--
ALTER TABLE `studio`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `tassa`
--
ALTER TABLE `tassa`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `vuoleModificare`
--
ALTER TABLE `vuoleModificare`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
