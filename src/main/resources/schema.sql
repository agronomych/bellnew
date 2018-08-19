CREATE TABLE IF NOT EXISTS `organization` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT,
  `name` VARCHAR(100) NOT NULL,
  `inn` VARCHAR(100) NOT NULL,
  `is_active` TINYINT NOT NULL default 1,
  `full_name` VARCHAR(100) NOT NULL,
  `kpp` VARCHAR(100) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `phone` VARCHAR(100),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE INDEX `ix_organization_id` ON `organization` (`id` ASC);

CREATE TABLE IF NOT EXISTS `office` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT,
  `org_id` INT NOT NULL,
  `name` VARCHAR(100),
  `phone` VARCHAR(100),
  `is_active` TINYINT default 1,
  `address` VARCHAR(100),
  PRIMARY KEY (`id`),
  CONSTRAINT `org_id`
    FOREIGN KEY (`org_id`)
    REFERENCES `organization` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `ix_office_org_id` ON `office` (`org_id` ASC);
CREATE INDEX `ix_office_id` ON `office` (`id` ASC);

CREATE TABLE IF NOT EXISTS `doc` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT,
  `code` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE INDEX `ix_doc_id` ON `doc` (`id` ASC);

CREATE TABLE IF NOT EXISTS `country` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT,
  `code` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE INDEX `ix_country_id` ON `country` (`id` ASC);

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT,
  `office_id` INT,
  `first_name` VARCHAR(100),
  `last_name` VARCHAR(100),
  `middle_name` VARCHAR(100),
  `position` VARCHAR(100),
  `doc_id` INT NULL default 0,
  `citizenship_id` INT default 0,
  `phone` VARCHAR(100),
  `doc_number` VARCHAR(100),
  `doc_date` VARCHAR(100),
  `is_identified` TINYINT default 1,
  PRIMARY KEY (`id`),
  CONSTRAINT `office_id`
    FOREIGN KEY (`office_id`)
    REFERENCES `office` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `doc_id`
    FOREIGN KEY (`doc_id`)
    REFERENCES `doc` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `citizenship_id`
    FOREIGN KEY (`citizenship_id`)
    REFERENCES `country` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `ix_user_id` ON `user` (`id` ASC);

CREATE INDEX `ix_user_office_id` ON `user` (`office_id` ASC);

CREATE INDEX `ix_user_doc_id` ON `user` (`doc_id` ASC);

CREATE INDEX `ix_user_citizenship_id` ON `user` (`citizenship_id` ASC);