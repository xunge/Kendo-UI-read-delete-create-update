CREATE SCHEMA `emp` ;

--
-- Table structure for table `kendo`
--

DROP TABLE IF EXISTS `kendo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kendo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kendo`
--

LOCK TABLES `kendo` WRITE;
/*!40000 ALTER TABLE `kendo` DISABLE KEYS */;
INSERT INTO `kendo` VALUES (2,'jiang',11),(3,'li',33),(4,'gao',44),(5,'ji',55),(6,'liu',66),(7,'jiang',22),(8,'jiang',2),(9,'222',22),(10,'jiang',11),(11,'111',111),(12,'gongbaobao',3),(13,'jiangbaobao',5);
/*!40000 ALTER TABLE `kendo` ENABLE KEYS */;
UNLOCK TABLES;