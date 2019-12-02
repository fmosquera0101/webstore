CREATE TABLE `webstore`.`cartitems` (
  `idcartitems` INT NOT NULL AUTO_INCREMENT,
  `idcart` INT NULL,
  `productid` INT NULL,
  `quantity` INT NULL,
  `totalprice` INT NULL,
  PRIMARY KEY (`idcartitems`));
