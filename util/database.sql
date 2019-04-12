-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pwsa
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pwsa
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pwsa` ;
USE `pwsa` ;

-- -----------------------------------------------------
-- Table `pwsa`.`pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwsa`.`pessoa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `cpf` VARCHAR(16) NOT NULL,
  `end` VARCHAR(150) NOT NULL,
  `email` VARCHAR(150) NULL DEFAULT '',
  `telefone` VARCHAR(20) NOT NULL,
  `tipo` VARCHAR(50) NOT NULL,
  `titulacao` VARCHAR(45) NULL DEFAULT '',
  `ativo` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pwsa`.`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwsa`.`login` (
  `matricula` VARCHAR(50) NOT NULL,
  `senha` VARCHAR(256) NOT NULL,
  `pessoa_id` INT NOT NULL,
  `ativo` TINYINT NOT NULL,
  PRIMARY KEY (`matricula`),
  INDEX `fk_login_pessoa_idx` (`pessoa_id` ASC) VISIBLE,
  CONSTRAINT `fk_login_pessoa`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `pwsa`.`pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pwsa`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwsa`.`curso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `area` VARCHAR(100) NOT NULL,
  `pessoa_id` INT NULL,
  `ativo` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_curso_pessoa1_idx` (`pessoa_id` ASC) VISIBLE,
  CONSTRAINT `fk_curso_pessoa1`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `pwsa`.`pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pwsa`.`turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwsa`.`turma` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `periodo` VARCHAR(50) NOT NULL,
  `sigla` VARCHAR(50) NOT NULL,
  `curso_id` INT NULL,
  `pessoa_id` INT NULL,
  `ativo` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_turma_curso1_idx` (`curso_id` ASC) VISIBLE,
  INDEX `fk_turma_pessoa1_idx` (`pessoa_id` ASC) VISIBLE,
  CONSTRAINT `fk_turma_curso1`
    FOREIGN KEY (`curso_id`)
    REFERENCES `pwsa`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turma_pessoa1`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `pwsa`.`pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pwsa`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwsa`.`disciplina` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `curso_id` INT NULL,
  `pessoa_id` INT NULL,
  `ativo` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_disciplina_curso1_idx` (`curso_id` ASC) VISIBLE,
  INDEX `fk_disciplina_pessoa1_idx` (`pessoa_id` ASC) VISIBLE,
  CONSTRAINT `fk_disciplina_curso1`
    FOREIGN KEY (`curso_id`)
    REFERENCES `pwsa`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplina_pessoa1`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `pwsa`.`pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pwsa`.`vestibular`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwsa`.`vestibular` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` VARCHAR(10) NOT NULL,
  `hora` VARCHAR(8) NOT NULL,
  `local` VARCHAR(100) NOT NULL,
  `curso_id` INT NULL,
  `pessoa_id` INT NULL,
  `ativo` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vestibular_curso1_idx` (`curso_id` ASC) VISIBLE,
  INDEX `fk_vestibular_pessoa1_idx` (`pessoa_id` ASC) VISIBLE,
  CONSTRAINT `fk_vestibular_curso1`
    FOREIGN KEY (`curso_id`)
    REFERENCES `pwsa`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vestibular_pessoa1`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `pwsa`.`pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pwsa`.`notas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwsa`.`notas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `primeira` FLOAT NULL DEFAULT 0,
  `segunda` FLOAT NULL DEFAULT 0,
  `terceira` FLOAT NULL DEFAULT 0,
  `pessoa_id` INT NULL,
  `disciplina_id` INT NULL,
  `ativo` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_notas_pessoa1_idx` (`pessoa_id` ASC) VISIBLE,
  INDEX `fk_notas_disciplina1_idx` (`disciplina_id` ASC) VISIBLE,
  CONSTRAINT `fk_notas_pessoa1`
    FOREIGN KEY (`pessoa_id`)
    REFERENCES `pwsa`.`pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notas_disciplina1`
    FOREIGN KEY (`disciplina_id`)
    REFERENCES `pwsa`.`disciplina` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
