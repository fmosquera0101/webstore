CREATE TABLE `webstore`.`orders` (
  `idorder` INT NOT NULL AUTO_INCREMENT,
  `idcart` INT NULL,
  `idcustomer` INT NULL,
  `idshippingdetail` INT NULL,
  `date` DATETIME NULL,
  PRIMARY KEY (`idorder`));
