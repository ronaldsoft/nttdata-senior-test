--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `contrasenia` varchar(255) NOT NULL,
  `estado` bit(1) NOT NULL,
  `clienteid` bigint NOT NULL,
  PRIMARY KEY (`clienteid`),
  CONSTRAINT `FKltuad7gvir4i2nu5wse9mnb8` FOREIGN KEY (`clienteid`) REFERENCES `persona` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('1234',_binary '',1),('5678',_binary '',2),('1245',_binary '',3);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuenta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `clienteid` bigint NOT NULL,
  `estado` varchar(20) NOT NULL,
  `numero_cuenta` varchar(255) DEFAULT NULL,
  `saldo_inicial` double NOT NULL,
  `tipo_cuenta` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pj7ncg765kt4klndu25bwbwe4` (`numero_cuenta`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta`
--

LOCK TABLES `cuenta` WRITE;
/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
INSERT INTO `cuenta` VALUES (1,1,'Activo','478758',1425,'Ahorros'),(2,2,'Activo','225487',700,'Corriente'),(3,2,'Activo','496825',0,'Ahorros'),(4,3,'Activo','495878',150,'Ahorros'),(5,1,'Activo','585545',1000,'Corriente');
/*!40000 ALTER TABLE `cuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimiento`
--

DROP TABLE IF EXISTS `movimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimiento` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha` datetime(6) NOT NULL,
  `saldo` double NOT NULL,
  `tipo_movimiento` varchar(50) NOT NULL,
  `valor` double NOT NULL,
  `numero_cuenta` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk10u787s9re28fue9gdscb5kt` (`numero_cuenta`),
  CONSTRAINT `FKk10u787s9re28fue9gdscb5kt` FOREIGN KEY (`numero_cuenta`) REFERENCES `cuenta` (`numero_cuenta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimiento`
--

LOCK TABLES `movimiento` WRITE;
/*!40000 ALTER TABLE `movimiento` DISABLE KEYS */;
INSERT INTO `movimiento` VALUES (1,'2024-10-13 23:37:53.207000',1425,'Retiro',575,'478758'),(2,'2024-10-13 23:38:11.150000',0,'Retiro',540,'496825'),(3,'2024-10-13 23:38:34.697000',700,'Deposito',600,'225487'),(4,'2024-10-13 23:39:02.023000',150,'Deposito',150,'495878');
/*!40000 ALTER TABLE `movimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `identificacion` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r5vsms84ih2viwd6tatk9o5pq` (`identificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Otavalo sn y principal',27,'Masculino','1811556535','Jose Lema','098254785'),(2,'Amazonas y NNUU',27,'Femenino','1811556530','Marianela Montalvo','097548965'),(3,'13 junio y Equinoccial',27,'Masculino','1811556532','Juan Osorio','098874587');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

-- Dump completed on 2024-10-14  4:50:21
