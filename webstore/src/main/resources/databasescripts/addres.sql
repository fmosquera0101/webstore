CREATE TABLE `webstore`.`addres` (
  `idaddres` INT NOT NULL AUTO_INCREMENT,
  `streetname` VARCHAR(45) NULL,
  `areaname` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `zipcode` VARCHAR(45) NULL,
  `idcustomer` INT NULL,
  PRIMARY KEY (`idaddres`));
