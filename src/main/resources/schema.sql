CREATE TABLE IF NOT EXISTS `Organizations` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT,
  `name` VARCHAR(100) NOT NULL,
  `inn` VARCHAR(100) NOT NULL,
  `isActive` TINYINT NOT NULL default 1,
  `fullName` VARCHAR(100) NOT NULL,
  `kpp` VARCHAR(100) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `phone` VARCHAR(100),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Offices` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT,
  `orgId` INT NOT NULL,
  `name` VARCHAR(100),
  `phone` VARCHAR(100),
  `isActive` TINYINT default 1,
  `address` VARCHAR(100),
  PRIMARY KEY (`id`),
  CONSTRAINT `orgId`
    FOREIGN KEY (`orgId`)
    REFERENCES `Organizations` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `orgId_idx` ON `Offices` (`orgId` ASC);

CREATE TABLE IF NOT EXISTS `Docs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT,
  `code` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Countries` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT,
  `code` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT,
  `officeId` INT,
  `firstName` VARCHAR(100),
  `lastName` VARCHAR(100),
  `middleName` VARCHAR(100),
  `position` VARCHAR(100),
  `docId` INT NULL default 0,
  `citizenshipId` INT default 0,
  `phone` VARCHAR(100),
  `docNumber` VARCHAR(100),
  `docDate` VARCHAR(100),
  `isIdentified` TINYINT default 1,
  PRIMARY KEY (`id`),
  CONSTRAINT `officeId`
    FOREIGN KEY (`officeId`)
    REFERENCES `Offices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `docId`
    FOREIGN KEY (`docId`)
    REFERENCES `Docs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `citizenshipId`
    FOREIGN KEY (`citizenshipId`)
    REFERENCES `Countries` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `officeId_idx` ON `Users` (`officeId` ASC);

CREATE INDEX `docId_idx` ON `Users` (`docId` ASC);

CREATE INDEX `citizenshipId_idx` ON `Users` (`citizenshipId` ASC);