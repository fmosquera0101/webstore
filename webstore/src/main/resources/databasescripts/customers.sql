CREATE TABLE `webstore`.`customers` (
  `idcustomer` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `idbillingaddres` INT NULL,
  `phonenumber` VARCHAR(45) NULL,
  PRIMARY KEY (`idcustomer`));