CREATE TABLE `cashiers` (
  `id` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT 'cashier',
  `name` varchar(45) DEFAULT NULL,
  `hire_date` varchar(45) DEFAULT NULL,
  `end_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


INSERT INTO `sms`.`cashiers1` (`id`, `username`, `password`, `type`, `name`, `hire_date`, `end_date`) VALUES ('1', 'cashier1', 'password', 'cashier', 'Popescu Ioana', '2014/12/17', '2016/12/12');
INSERT INTO `sms`.`cashiers1` (`id`, `username`, `password`, `type`, `name`, `hire_date`, `end_date`) VALUES ('2', 'cashier2', 'password', 'cashier', 'Anghel Petrut', '2017/11/23', '2019/06/02');
INSERT INTO `sms`.`cashiers1` (`id`, `username`, `password`, `type`, `name`, `hire_date`, `end_date`) VALUES ('3', 'cashier3', 'password', 'cashier', 'Ionescu Pavel', '2018/10/11', 'null');

CREATE TABLE `customers` (
  `id` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT 'customer',
  `registration_date` varchar(45) DEFAULT NULL,
  `last_active` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `loc_country` varchar(45) DEFAULT NULL,
  `loc_city` varchar(45) DEFAULT NULL,
  `loc_ZIP` varchar(45) DEFAULT NULL,
  `loc_address` varchar(45) DEFAULT NULL,
  `ship_country` varchar(45) DEFAULT NULL,
  `ship_city` varchar(45) DEFAULT NULL,
  `ship_ZIP` varchar(45) DEFAULT NULL,
  `ship_address` varchar(45) DEFAULT NULL,
  `card_number` varchar(45) DEFAULT NULL,
  `expiration_date` varchar(45) DEFAULT NULL,
  `cvc` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `sms`.`customers` (`id`, `username`, `password`, `type`, `registration_date`, `last_active`, `name`, `email`, `phone`, `loc_country`, `loc_city`, `loc_ZIP`, `loc_address`, `ship_country`, `ship_city`, `ship_ZIP`, `ship_address`, `card_number`, `expiration_date`, `cvc`) VALUES ('4', 'customer1', 'password', 'customer', '2019/06/02', '2019/06/02', 'Calin George-Adrian', 'calingeorgeadrian98@gmail.com', '0756098755', 'Romania', 'Tulcea', '123432', 'Str. Mieilor Nr. 7', 'Romania', 'Bucuresti', '123789', 'Intrarea Badeni 2A', '1234 1234 1234', '2019/06/02', '1221');
INSERT INTO `sms`.`customers` (`id`, `username`, `password`, `type`, `registration_date`, `last_active`, `name`, `email`, `phone`, `loc_country`, `loc_city`, `loc_ZIP`, `loc_address`, `ship_country`, `ship_city`, `ship_ZIP`, `ship_address`, `card_number`, `expiration_date`, `cvc`) VALUES ('5', 'customer2', 'password', 'customer', '2019/06/02', '2019/06/02', 'Hirhui Ema-Ioana', 'emahirhui@gmail.com', '0757615843', 'Romania', 'Bacau', '123412', 'Str. Moldovei Nr. 8', 'Romania', 'Bucuresti', '132534', 'Splaiul Independentei Nr. 16', '4321 7658 9032', '2019/06/02', '5678');

CREATE TABLE `packagetypes` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `measure_unit` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `sms`.`packagetypes` (`id`, `name`, `description`, `quantity`, `measure_unit`) VALUES ('1', 'Bottle', 'For liquids', '500', 'mL');
INSERT INTO `sms`.`packagetypes` (`id`, `name`, `description`, `quantity`, `measure_unit`) VALUES ('2', 'Bottle', 'For liquids', '1', 'L');
INSERT INTO `sms`.`packagetypes` (`id`, `name`, `description`, `quantity`, `measure_unit`) VALUES ('3', 'Bottle', 'For liquids', '2', 'L');
INSERT INTO `sms`.`packagetypes` (`id`, `name`, `description`, `quantity`, `measure_unit`) VALUES ('4', 'Glass bottle', 'For liquids', '330', 'mL');
INSERT INTO `sms`.`packagetypes` (`id`, `name`, `description`, `quantity`, `measure_unit`) VALUES ('5', 'Glass bottle', 'For liquids', '500', 'mL');
INSERT INTO `sms`.`packagetypes` (`id`, `name`, `description`, `quantity`, `measure_unit`) VALUES ('6', 'Glass bottle', 'For liquids', '750', 'mL');
INSERT INTO `sms`.`packagetypes` (`id`, `name`, `description`, `quantity`, `measure_unit`) VALUES ('7', 'Cardboard box', 'For liquids', '900', 'mL');
INSERT INTO `sms`.`packagetypes` (`id`, `name`, `description`, `quantity`, `measure_unit`) VALUES ('8', 'Bag', 'For solids', '300', 'g');
INSERT INTO `sms`.`packagetypes` (`id`, `name`, `description`, `quantity`, `measure_unit`) VALUES ('9', 'Bag', 'For solids', '500', 'g');
INSERT INTO `sms`.`packagetypes` (`id`, `name`, `description`, `quantity`, `measure_unit`) VALUES ('10', 'Can', 'For liquids', '330', 'mL');
INSERT INTO `sms`.`packagetypes` (`id`, `name`, `description`, `quantity`, `measure_unit`) VALUES ('11', 'Can', 'For liquids', '500', 'mL');
INSERT INTO `sms`.`packagetypes` (`id`, `name`, `description`, `quantity`, `measure_unit`) VALUES ('12', 'Plastic box', 'For yogurt', '200', 'g');
INSERT INTO `sms`.`packagetypes` (`id`, `name`, `description`, `quantity`, `measure_unit`) VALUES ('13', 'Plastic box', 'For yogurt', '360', 'g');
INSERT INTO `sms`.`packagetypes` (`id`, `name`, `description`, `quantity`, `measure_unit`) VALUES ('14', 'Plastic box', 'For yogurt', '500', 'g');

CREATE TABLE `productcategories` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `sms`.`productcategories` (`id`, `name`, `description`) VALUES ('1', 'Soft drinks', 'For non-alcoholic drinks such as water or juice');
INSERT INTO `sms`.`productcategories` (`id`, `name`, `description`) VALUES ('2', 'Alcoholic beverages', 'For alcoholic drinks such as beer or wine');
INSERT INTO `sms`.`productcategories` (`id`, `name`, `description`) VALUES ('3', 'Dairy products', 'For dairy products such as milk or cheese');
INSERT INTO `sms`.`productcategories` (`id`, `name`, `description`) VALUES ('4', 'Hot drinks', 'For hot drinks such as coffee and tea');

CREATE TABLE `providers` (
  `id` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT 'provider',
  `registrationId` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `sms`.`providers` (`id`, `username`, `password`, `type`, `registrationId`, `name`) VALUES ('6', 'provider1', 'password', 'provider', '123454321', 'Dedeman S.R.L.');
INSERT INTO `sms`.`providers` (`id`, `username`, `password`, `type`, `registrationId`, `name`) VALUES ('7', 'provider2', 'password', 'provider', '123456789', 'Carrefour S.R.L.');

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `package` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (1,'Coca-Cola 330mL',1,10,2.2,50);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (2,'Coca-Cola 500mL',1,1,3.14,50);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (3,'Coca-Cola 1L',1,2,4.21,50);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (4,'Coca-Cola 2L',1,3,6.01,50);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (5,'Fanta 330mL',1,10,2.2,50);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (6,'Fanta 500mL',1,1,3.25,37);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (7,'Fanta 1L',1,2,4.32,37);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (8,'Fanta 2L',1,3,5.67,37);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (9,'Sprite 330mL',1,10,2.2,50);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (10,'Sprite 500mL',1,1,3.29,41);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (11,'Sprite 1L',1,2,4.43,41);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (12,'Sprite 2L',1,3,5.85,41);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (13,'Heineken Beer 330mL',2,4,3.45,28);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (14,'Heineken Beer 500mL',2,11,3.45,28);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (15,'Corona Beer 330mL',2,4,4.87,48);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (16,'Corona Beer 500mL',2,5,5.87,48);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (17,'Strongbow Gold Apple 330mL',2,4,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (18,'Strongbow Gold Apple 500mL',2,11,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (19,'Strongbow Red Berries 330mL',2,4,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (20,'Strongbow Red Berries 500mL',2,11,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (21,'Strongbow Elderflower 330mL',2,4,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (22,'Strongbow Elderflower 500mL',2,11,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (23,'Strongbow Pear 330mL',2,4,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (24,'Strongbow Medium Dry 330mL',2,4,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (25,'Strongbow Rose 330mL',2,4,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (26,'Silva Dark 330mL',2,4,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (27,'Silva Dark 500mL',2,5,3.3,65);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (28,'Silva Dark 500mL',2,11,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (29,'Tuborg 330mL',2,4,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (30,'Tuborg 500mL',2,11,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (31,'Tuborg 750mL',2,6,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (32,'Schwaben Rose 750mL',2,6,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (33,'Jidvei Premiat Alb Demisec 750mL',2,6,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (34,'Jidvei Premiat Alb Demidulce 750mL',2,6,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (35,'Cotnari Alb Demisec 750mL',2,6,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (36,'Cotnari Alb Demidulce 750mL',2,6,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (37,'Dealurile Moldovei Rosu Demisec 750mL',2,6,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (38,'Dealurile Moldovei Rosu Demidulce 750mL',2,6,3.3,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (39,'Zuzu Milk',3,7,2.91,80);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (40,'Delaco Cheese',3,9,8.49,40);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (41,'Zuzu Dolce Pudding',3,12,2.1,28);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (42,'Danone Yogurt',3,12,2.1,28);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (43,'Danone Yogurt',3,13,2.1,28);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (44,'Danone Yogurt',3,14,2.1,28);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (45,'Danone Fruit Yogurt',3,12,2.1,28);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (46,'Danone Fruit Yogurt',3,13,2.1,28);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (47,'Danone Fruit Yogurt',3,14,2.1,28);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (48,'Jacobs Kronung Coffee',4,4,11.34,27);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (49,'Doncafe Coffee',4,4,11.34,27);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (50,'Fortuna Coffee',4,4,11.34,27);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (51,'Amigo Coffee',4,4,11.34,27);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (52,'Hochland Cheese',3,9,8.49,40);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (53,'Muller Fruit Yogurt',3,12,2.1,28);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (54,'Muller Fruit Yogurt',3,13,2.1,28);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (55,'Muller Fruit Yogurt',3,14,2.1,28);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (56,'Covalact Cheese',3,9,8.49,40);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (57,'Coca-Cola Zero 330ml',1,10,1.97,34);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (58,'Coca-Cola Zero 500ml',1,1,3.24,14);
INSERT INTO `products` (`id`,`name`,`category`,`package`,`price`,`stock`) VALUES (69,'Coca Cola-Zero 2L',1,3,6.21,17);