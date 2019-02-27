-- MySQL dump 10.13  Distrib 5.7.23, for Linux (x86_64)
--
-- Host: localhost    Database: tcmdata
-- ------------------------------------------------------
-- Server version	5.7.23-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `jingluomaibiao`
--

DROP TABLE IF EXISTS `jingluomaibiao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jingluomaibiao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `jingluomingcheng` varchar(255) NOT NULL,
  `jingluomingchengfenlei` varchar(255) NOT NULL,
  `duiyingshichen` varchar(255) DEFAULT NULL,
  `jingmaixunxing` text,
  `zhuyaobinghou` text,
  `zhuzhigaiyao` text,
  `xueweishuliang` int(5) DEFAULT NULL,
  `xueweimingchengliebiao` text,
  `jiaohuishuxue` text,
  `rentishiyitu` varchar(255) DEFAULT NULL,
  `miaoshu` text,
  `shifouguobiao` tinyint(1) DEFAULT NULL,
  `beizhu` text,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `delete_at` datetime DEFAULT NULL,
  `zhuzhi` text,
  `zhuyaogaiyao` text,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3171 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jingluomaibiao`
--

LOCK TABLES `jingluomaibiao` WRITE;
/*!40000 ALTER TABLE `jingluomaibiao` DISABLE KEYS */;
INSERT INTO `jingluomaibiao` VALUES (3146,'手太阴肺经','十二经脉','寅时','起于中焦，向下联络大肠回绕胃口过膈属于肺脏，从肺系（肺与喉咙相联系的部位）横行出来，沿上臂内侧下行，行于手少阴经和手厥阴经的前面，经肘窝入寸口，沿鱼际边缘，出拇指内侧端（少商）。手腕后方支脉，从列缺处分出，走向食指内侧端，与手阳明大肠经相接。','咳嗽气喘气短、咳血咽痛，外感伤风，循环部位痛麻或活动受限等。','主治外感、头痛、项强、咳痰喘等证。',11,NULL,NULL,'/acupoint/acupoint_picture/手太阴肺经.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3147,'手阳明大肠经','十二经脉','卯时','起于食指末端（商阳），沿食指内（桡）侧向上，通过一、二掌骨之间（合谷）向上进入两筋（拇长伸肌健与拇短伸肌腱）之间的凹陷处，沿前臂前方，并肘部外侧，再沿上臂外侧前缘，上走肩端（肩髃），沿肩峰前缘向上出于颈椎（大椎），再向下入缺盆（锁骨上窝）部，联络肺脏，通过横膈，属于大肠。缺盆部支脉：上走颈部，通过面颊，进入下齿龈，回绕至上唇，交叉于人中，左脉向右，右脉向左，分布在鼻孔两侧（迎香），与足阳明胃经相接。','腹痛、肠鸣、泄泻、便秘、咽喉肿痛、齿痛。本经循行部位疼痛、热肿或寒冷麻木等。','主治头面、五官、咽喉病、热病及经脉循行部位的其他病证。',20,NULL,NULL,'/acupoint/acupoint_picture/手阳明大肠经.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3148,'足阳明胃经','十二经脉','辰时','起于鼻翼两侧（迎香）上行到鼻根部与足太阳经交会，向下沿鼻外侧进入上齿龈内，回出环绕口唇，向下交会于颏唇沟承浆处，再向后沿口腮后下方，出于下颌大迎处沿下颌角颊车，上行耳前，经上关，沿发际，到达前额（前庭）。面部支脉：从大迎前下走人迎，沿着喉咙，进入缺盆部，向下过膈，属于胃，联络脾脏。缺盘部直行的脉：经乳头，向下挟剂旁，进入少腹两侧气冲；胃下口部支脉：沿着腹里向下到气冲会合，再由此下行至髀关，直抵伏兔部，下至膝盖，沿胫骨外侧前缘，下经足跗；进入第二足趾外侧端（厉兑）；胫部支脉：从膝下3寸（足三里）处分出进入足中趾外侧；足跗部支脉：从跗上分出，进入足大趾内侧端（隐白）与足太阴脾经相接。','肠鸣腹胀、水肿、胃痛、呕吐或消谷善饥、口渴、咽喉肿痛、鼻衄、胸部及膝髌等本经循行部位疼痛、热病、发狂等。','主治胃肠病、头面、目鼻、口齿痛、神志病及经脉循行部位的其他病证。',45,NULL,NULL,'/acupoint/acupoint_picture/足阳明胃经.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3149,'足太阴脾经','十二经脉','巳时','起于足大趾末端（隐白），沿着大趾内侧赤白肉际，经第一跖趾关节向上行至内踝前，上行腿肚，交出足厥阴经的前面，经膝股部内侧前缘，进入腹部，属脾络胃，过膈上行，挟咽旁系舌根，散舌下。胃部支脉：过膈流注于心中，与心经相接。','胃脘痛、食则呕，嗳气，腹胀便溏，黄疸，身重无力，舌根强痛，下肢内侧肿胀，厥冷。','主治脾胃病，妇科，前阴病及经脉循行部位的其他病证。',21,NULL,NULL,'/acupoint/acupoint_picture/足太阴脾经.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3150,'手少阴心经','十二经脉','午时','起于心中，出属心系（心与其他脏器相连系的部位），过膈，联络小肠。“心系”向上支脉：挟咽喉上行，连系于目系（眼球连系于脑的部位）“心系”直行的脉：上行于肺部再向下出于腋窝部（极泉）沿上臂内侧后缘，行于手太阴和手厥阴经的后面，至掌后豌豆骨部入掌内，沿小指内侧至末端（少冲）交于手太阳小肠经。','心痛、咽干、口渴、目黄、胁痛、上臂内侧痛、手心发热等。','主治心、胸、神经病及经脉循行部位的其他病证。',9,NULL,NULL,'/acupoint/acupoint_picture/手少阴心经.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3151,'手太阳小肠经','十二经脉','未时','起于手小指外侧端（少泽），沿手背外侧至腕部直上沿前臂外侧后缘，经尺骨鹰嘴与肱骨内上髁之间，出于肩关节，绕行肩胛部，交于大椎（督脉）向下入缺盆部联络心脏，沿食管过膈达胃，属于小肠。缺盆部支脉：沿颈部上达面颊，至目外眦，转入耳中（听宫）。颊部支脉：上行目眶下，抵于鼻旁，至目内眦（睛明）、交于足太阳膀胱经。','少腹痛、腰脊痛引睾丸、耳聋、目黄、颊肿、咽喉肿痛、肩臂外侧后缘痛等。','主治头、项、耳、目、喉咽病、热病、神志病及经脉循行部位的其他病症。',19,NULL,NULL,'/acupoint/acupoint_picture/手太阳小肠经.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3152,'足太阳膀胱经','十二经脉','申时','起于目内眦，上额交会于巅顶（百会）。巅顶部支脉：从头顶到颞颥部。巅顶部直行的脉：从头顶入里联络于脑，回出分开下行项后，沿肩胛部内侧，挟脊柱，到达腰部，从脊旁肌肉进入体腔联络肾脏，属于膀胱；腰部支脉：向下通过臀部，进入腘窝内；后项部支脉：通过肩胛骨内缘直下，经过臀部下行，沿大腿后外侧与腰部下来的支脉会合于腘疟窝中。从此向下，出于外踝后,　第五跖骨粗隆，至小趾外侧端（至阴），与足少阴经相接。','小便不通，遗尿、癫狂，疟疾，目痛，见风流泪，鼻塞多涕，鼻衄，头痛，项、背、臀部及下肢循行部位痛麻等。','主治头、项、目、背、腰、下肢部病症及神志病，背部第一侧线的背俞穴及第二侧线相平的腧穴，主治与其相关的脏腑病证和有关的组织器官病症。',67,NULL,NULL,'/acupoint/acupoint_picture/足太阳膀胱经.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3153,'足少阴肾经','十二经脉','酉时','起于足小趾之下，斜向足心（涌泉）出于舟骨粗隆下，沿内踝后向上行于腿肚内侧，经股内后缘，通过脊住（长强）属于肾脏，联络膀胱。肾脏部直行脉：从肾向上通过肝和横膈，进入肺中，沿着喉咙，挟于舌根部。肺部支脉：从肺部出来，络心，流注于胸中，与手厥阴心包经相接。肺部支脉：从肺部出来，络心，流注于胸中，与手厥阴心包经相接。','咳血、气喘、舌干、咽喉、肿痛、水肿、大便秘结、泄泻、腰痛、脊股内后侧痛，痿弱无力，足心热等证。','主治妇科，前阴病、肾、肺、咽喉病及经脉循行部位的其他病证。',27,NULL,NULL,'/acupoint/acupoint_picture/足少阴肾经.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3154,'手厥阴心包经','十二经脉','戌时','起于胸中，出属心包络，向下通膈，从胸至腹依次联络上、中、下三焦。胸部支脉：沿胸中，出于胁肋至腋下（天地），上行至腋窝中，沿上臂内侧行于手太阴和手少阴经之间，经肘窝下行于前臂中间进入掌中，沿中指到指端（中冲）。掌中支脉：从劳宫分出，沿无名指到指端（关冲），与手少阳三焦经相接。','心痛、胸闷、心惊、心烦、癫狂、腋肿、肘臂挛痛、掌心发热等。','主治心、胸、胃、神志病及经脉循行部位的其他病症。',9,NULL,NULL,'/acupoint/acupoint_picture/手厥阴心包经.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3155,'手少阳三焦经','十二经脉','亥时','起于无名指末端（关冲）上行于第四、五掌骨间，沿腕背、出于前臂外侧尺桡骨之间，经肘尖沿上臂外侧达肩部，交大椎，再向前入缺盆部，分布于胸中，络心包，过膈，从胸至腹，属于上、中、下三焦。胸中支脉：从胸向上出于缺盆部，上走项部，沿耳后直上至额角，再下行经面颊部至目眶下。耳部支脉：从耳后入耳中耳前，与前脉交叉于面颊部，到目外眦，与足少阳胆经相接。','腹胀、水肿、遗尿、小便不利、耳聋、喉咽肿痛、目赤肿痛、颊肿、耳后、肩臂肘部外侧痛等。','主治侧头、耳、目、胸胁、咽喉病、热病及经脉循行部位的其他病症。',23,NULL,NULL,'/acupoint/acupoint_picture/手少阳三焦经.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3156,'足少阳胆经','十二经脉','子时','起于目外眦（瞳子髎），向上到额角返回下行至耳后，沿颈部向后交会大椎穴再向前入缺盆部入胸过膈，联络肝脏，属胆，沿胁肋部，出于腹股沟，经外阴毛际，横行入髋关节（环跳）。耳部支脉：从耳后入耳中，出走耳前，到目外眦处后向下经颊部会合前脉于缺盆部。下行腋部　侧胸部，经季肋和前脉会于髋关节后，再向下沿大腿外侧，行于足阳明和足太阴经之间，经腓骨前直下到外踝前，进入足第四趾外侧端（足窍明）；足背部支脉：从足临泣处分出，沿第一、二跖骨之间，至大趾端（大敦）与足厥阴经相接。','口苦、目眩、疟疾、头痛、颌痛、目外眦痛、缺盆部、腋下、胸胁、股及下肢外侧、足外侧痛等。','主治侧头、目、耳、咽喉病、神志病、热病及经脉循行部位的其他病症。',44,NULL,NULL,'/acupoint/acupoint_picture/足少阳胆经.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3157,'足厥阴肝经','十二经脉','丑时','起于足大趾上毫毛部（大敦），经内踝前向上至内踝上八寸外处交出于足太阴经之后，上行沿股内侧，进入阴毛中，绕阴器，上达小腹，挟胃旁，属肝络胆，过膈，分布于胁肋，沿喉咙后面，向上入鼻咽部，连接于“目系”（眼球连系于脑的部位），上出于前额，与督脉会合于巅顶。“目系”支脉，下行颊里、环绕唇内。肝部支脉：从肝分出，过膈，向上流注于肺，与手太阴肺经相接。','腰痛、胸满、呃逆、遗尿、小便不利、疝气、少腹肿等症。','主治肝病、妇科、前阴病及经脉循行部位的其他病症。',14,NULL,NULL,'/acupoint/acupoint_picture/足厥阴肝经.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3158,'督脉','奇经八脉',NULL,'起于小腹内，下出于会阴部，向后行于脊柱的内部，上达项后风府，进入脑内，上行巅顶，沿前额下行鼻柱。','脊柱强痛，角弓反张等证。','主治神志病、热病、腰骶、背、头项局部病证及相应的内脏疾病。',28,NULL,'','/acupoint/acupoint_picture/督脉.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3159,'任脉','奇经八脉',NULL,'起于小腹内，下出会阴部，向上行于阴毛部，沿腹内向上经前正中线到达咽喉部，再向上环绕口唇，经面部入目眶下。','疝气、带下、腹中结块等。','主治腹、胸、颈头面的局部病证及相应的内脏器官疾病。少数腧穴有强壮作用或可治神志病。',24,NULL,'','/acupoint/acupoint_picture/任脉.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3160,'冲脉','奇经八脉',NULL,'起于小腹内，下出于会阴部，向上行于脊柱之内，其外行者经气冲与足少阴经交会，沿着腹部两侧，上达咽喉，环绕口唇','腹部气逆而拘急',NULL,NULL,NULL,'会阴, 阴交, 气冲, 横骨, 大赫, 气穴, 四满, 中注, 商曲, 石关, 阴都, 通谷, 幽门','/acupoint/acupoint_picture/冲脉.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3161,'带脉','奇经八脉',NULL,'起于季肋部的下面，斜向下行到带脉，五枢、维道穴、横行绕身一周','腹满，腰部觉冷如坐水中',NULL,NULL,NULL,'带脉, 五枢, 维道','/acupoint/acupoint_picture/带脉.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3162,'阴维脉','奇经八脉',NULL,'起于小腿内侧，沿大腿内侧上行到腹部，与足太阴经相合过胸部，与任脉会合于面部','心痛、忧郁',NULL,NULL,NULL,'筑宾, 府舍, 大横, 腹衰, 期门, 天突, 廉泉','/acupoint/acupoint_picture/阴维脉.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3163,'阳维脉','奇经八脉',NULL,'起于足跟外侧，向上经过外踝，沿足少阳经上行髋关节部，经胁肋后侧，从腋后上肩，至前额，再到项后，合于督脉','恶寒发热，腰痛',NULL,NULL,NULL,'金门, 阳交, 俞臑, 天髎, 头维, 本神, 阳白, 头临泣, 目窗, 正营, 承灵, 脑空, 风池, 风府, 哑门','/acupoint/acupoint_picture/阳维脉.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3164,'阴跷脉','奇经八脉',NULL,'起于足舟骨后方，上行的内踝上，直上沿大腿内侧，经阴部，上行沿胸部内侧，进入锁骨上窝，进颧部到目内眦，与足太阴经和阳跷脉相会合','多眠、癃闭',NULL,NULL,NULL,'照海, 交信, 晴明','/acupoint/acupoint_picture/阴跷脉.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3165,'阳跷脉','奇经八脉',NULL,'起于足跟外侧，经外踝上行腓骨后缘，沿股部外侧和肋后上肩，过颈上挟口角，入目内眦，与阴跷脉相合，再沿足太阳经上额，与足少阳经合于风池','目痛从内眦始，不眠',NULL,NULL,NULL,'申脉, 仆参, 跗阳, 居髎, 臑俞, 肩髃, 巨骨, 天髎, 地仓, 巨髎, 承泣, 晴明','/acupoint/acupoint_picture/阳跷脉.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3166,'头颈部穴','奇穴',NULL,NULL,NULL,NULL,13,NULL,NULL,'/acupoint/acupoint_picture/头颈部穴.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3167,'胸腹部穴','奇穴',NULL,NULL,NULL,NULL,2,NULL,NULL,'/acupoint/acupoint_picture/胸腹部穴.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3168,'背部穴','奇穴',NULL,NULL,NULL,NULL,6,NULL,NULL,'/acupoint/acupoint_picture/背部穴.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3169,'上肢穴','奇穴',NULL,NULL,NULL,NULL,10,NULL,NULL,'/acupoint/acupoint_picture/上肢穴.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3170,'下肢穴','奇穴',NULL,NULL,NULL,NULL,9,NULL,NULL,'/acupoint/acupoint_picture/下肢穴.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `jingluomaibiao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-23 13:42:37
