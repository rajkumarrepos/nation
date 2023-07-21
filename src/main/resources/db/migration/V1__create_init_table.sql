-- nation.`_user` definition

CREATE TABLE `_user` (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','MANAGER','USER') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- nation.country definition

CREATE TABLE `country` (
  `id` varchar(255) NOT NULL,
  `capital` varchar(30) NOT NULL,
  `continent` varchar(30) NOT NULL,
  `country_code` varchar(5) NOT NULL,
  `country_name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_hs6grar8947iypypoi4wwjvc5` (`capital`),
  UNIQUE KEY `UK_oqixmig4k8qxc8oba3fl4gqkr` (`country_code`),
  UNIQUE KEY `UK_qrkn270121aljmucrdbnmd35p` (`country_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `state` (
  `id` varchar(255) NOT NULL,
  `state_code` int NOT NULL,
  `state_name` varchar(30) NOT NULL,
  `country_entity_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_eheeb6h2pcepqpqxuq3vredts` (`state_code`),
  UNIQUE KEY `UK_qtjsbpmp2ejq0753ktldenyqo` (`state_name`),
  KEY `FKt0fw5frj26niadaovhpvn5h90` (`country_entity_id`),
  CONSTRAINT `FKt0fw5frj26niadaovhpvn5h90` FOREIGN KEY (`country_entity_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- nation.district definition

CREATE TABLE `district` (
  `id` varchar(255) NOT NULL,
  `district_code` int NOT NULL,
  `district_name` varchar(30) NOT NULL,
  `state_entity_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7o47s6kydudnriva1o26w4hbg` (`district_code`),
  UNIQUE KEY `UK_256gmmaxp8m27c53mlo2tnw4e` (`district_name`),
  KEY `FKgkkn2v2ovjv6h6clfcq6pxyqo` (`state_entity_id`),
  CONSTRAINT `FKgkkn2v2ovjv6h6clfcq6pxyqo` FOREIGN KEY (`state_entity_id`) REFERENCES `state` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- nation.state definition

