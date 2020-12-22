SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema transacao
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `transacao` ;

-- -----------------------------------------------------
-- Schema transacao
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `transacao` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `transacao` ;

-- -----------------------------------------------------
-- Table `transacao`.`cartao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `transacao`.`cartao` ;

CREATE TABLE IF NOT EXISTS `transacao`.`cartao` (
    `cartao_id` BINARY(16) NOT NULL,
    `email` VARCHAR(254) NOT NULL,
    PRIMARY KEY (`cartao_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transacao`.`transacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `transacao`.`transacao` ;

CREATE TABLE IF NOT EXISTS `transacao`.`transacao` (
   `transacao_id` BINARY(16) NOT NULL,
   `valor` DECIMAL(30,2) NOT NULL,
   `estabelecimento_nome` VARCHAR(200) NOT NULL,
   `estabelecimento_cidade` VARCHAR(45) NOT NULL,
   `estabelecimento_endereco` VARCHAR(300) NOT NULL,
   `cartao_id` BINARY(16) NOT NULL,
   PRIMARY KEY (`transacao_id`),
   INDEX `fk_transacao_cartao_idx` (`cartao_id` ASC) VISIBLE,
   CONSTRAINT `fk_transacao_cartao`
       FOREIGN KEY (`cartao_id`)
           REFERENCES `transacao`.`cartao` (`cartao_id`)
           ON DELETE NO ACTION
           ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
