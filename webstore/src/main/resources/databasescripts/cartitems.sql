CREATE TABLE `webstore`.`cartitems` (
  `idcartitems` INT NOT NULL AUTO_INCREMENT,
  `idcart` VARCHAR(300) NULL,
  `productid` INT NULL,
  `quantity` INT NULL,
  `totalprice` INT NULL,
  PRIMARY KEY (`idcartitems`));
