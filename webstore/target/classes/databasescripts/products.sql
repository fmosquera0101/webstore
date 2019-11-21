CREATE TABLE `webstore`.`products` (
  `productId` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `unitPrice` INT NOT NULL,
  `description` VARCHAR(100) NULL,
  `manufacturer` VARCHAR(45) NULL,
  `category` VARCHAR(45) NULL,
  `unitsInStock` INT NULL,
  `unitsInOrder` INT NULL,
  `discontinued` VARCHAR(10) NULL,
  PRIMARY KEY (`productId`));