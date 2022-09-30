-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 09 déc. 2021 à 13:50
-- Version du serveur : 10.4.21-MariaDB
-- Version de PHP : 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bibliothequemysql`
--

-- --------------------------------------------------------

--
-- Structure de la table `book`
--

CREATE TABLE `book` (
  `nisbn` varchar(20) NOT NULL,
  `titre` varchar(20) NOT NULL,
  `auteur` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `book`
--

INSERT INTO `book` (`nisbn`, `titre`, `auteur`) VALUES
('1', ' La Vallée', 'Bernard Minier'),
('2', ' Buveurs de vent ', ' Franck Bouysse'),
('3', 'Chavirer ', ' Lola Lafon'),
('4', 'xxxx', 'xxxx');

-- --------------------------------------------------------

--
-- Structure de la table `emprunte`
--

CREATE TABLE `emprunte` (
  `id_exemplaire` varchar(20) NOT NULL,
  `titre` varchar(20) NOT NULL,
  `id_usager` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `date_emprunte` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `emprunte`
--

INSERT INTO `emprunte` (`id_exemplaire`, `titre`, `id_usager`, `prenom`, `date_emprunte`) VALUES
('1', ' La Vallée', '2', 'hiba', '2021-11-28'),
('4', ' Buveurs de vent ', '3', 'nadia', '2021-11-28');

-- --------------------------------------------------------

--
-- Structure de la table `exemplaire`
--

CREATE TABLE `exemplaire` (
  `id` varchar(20) NOT NULL,
  `nisbn` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `exemplaire`
--

INSERT INTO `exemplaire` (`id`, `nisbn`) VALUES
('1', '1'),
('2', '1'),
('3', '1'),
('4', '2'),
('5', '2'),
('6', '3');

-- --------------------------------------------------------

--
-- Structure de la table `historique`
--

CREATE TABLE `historique` (
  `id_exemplaire` varchar(20) NOT NULL,
  `titre` varchar(20) NOT NULL,
  `id_usager` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `date_emprunte` varchar(20) NOT NULL,
  `date_retour` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `historique`
--

INSERT INTO `historique` (`id_exemplaire`, `titre`, `id_usager`, `prenom`, `date_emprunte`, `date_retour`) VALUES
('1', ' La Vallée', '1', 'fadwa', '2021-11-28', '2021-11-28');

-- --------------------------------------------------------

--
-- Structure de la table `login_table`
--

CREATE TABLE `login_table` (
  `user_name` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `login_table`
--

INSERT INTO `login_table` (`user_name`, `password`) VALUES
('fadwa', '12345'),
('hiba', '123'),
('nadia', '12345'),
('rania', '1245');

-- --------------------------------------------------------

--
-- Structure de la table `usager`
--

CREATE TABLE `usager` (
  `id` varchar(20) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `statut` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `usager`
--

INSERT INTO `usager` (`id`, `nom`, `prenom`, `statut`, `email`) VALUES
('1', 'mili', 'fadwa', 'etudiant', 'milifadw@gmail.com'),
('2', 'khedhiri', 'hiba', 'etudiant', 'hiba.khedhri@gmail.com'),
('3', 'boulifa', 'nadia', 'enseignant', 'nadia.boulifa@gmail.com');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`nisbn`);

--
-- Index pour la table `emprunte`
--
ALTER TABLE `emprunte`
  ADD PRIMARY KEY (`id_exemplaire`);

--
-- Index pour la table `exemplaire`
--
ALTER TABLE `exemplaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `historique`
--
ALTER TABLE `historique`
  ADD PRIMARY KEY (`id_exemplaire`);

--
-- Index pour la table `login_table`
--
ALTER TABLE `login_table`
  ADD PRIMARY KEY (`user_name`);

--
-- Index pour la table `usager`
--
ALTER TABLE `usager`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
