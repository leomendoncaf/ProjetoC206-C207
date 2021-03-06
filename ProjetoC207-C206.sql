-- MySQL Script generated by MySQL Workbench
-- Fri Dec  3 18:24:10 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `projeto` DEFAULT CHARACTER SET utf8 ;
USE `projeto` ;

-- -----------------------------------------------------
-- Table `mydb`.`Empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`Empresa` (
  `idEmpresa` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cnpj` VARCHAR(45) NOT NULL,
  `numFuncionarios` INT NOT NULL,
  `produto` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEmpresa`))
ENGINE = InnoDB
COMMENT = '\n';


-- -----------------------------------------------------
-- Table `mydb`.`Fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`Fornecedor` (
  `idFornecedor` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cnpj` VARCHAR(45) NOT NULL,
  `Empresa_idEmpresa` INT NOT NULL,
  PRIMARY KEY (`idFornecedor`),
  INDEX `fk_Fornecedor_Empresa_idx` (`Empresa_idEmpresa` ASC) VISIBLE,
  CONSTRAINT `fk_Fornecedor_Empresa`
    FOREIGN KEY (`Empresa_idEmpresa`)
    REFERENCES `projeto`.`Empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`Cliente` (
  `cpf` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `idade` INT NOT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`Funcionario` (
  `idFuncionario` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `salario` VARCHAR(45) NOT NULL,
  `Empresa_idEmpresa` INT NOT NULL,
  PRIMARY KEY (`idFuncionario`),
  INDEX `fk_Funcionario_Empresa1_idx` (`Empresa_idEmpresa` ASC) VISIBLE,
  CONSTRAINT `fk_Funcionario_Empresa1`
    FOREIGN KEY (`Empresa_idEmpresa`)
    REFERENCES `projeto`.`Empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Empresa_has_Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`Empresa_has_Cliente` (
  `Empresa_idEmpresa` INT NOT NULL,
  `Cliente_cpf` INT NOT NULL,
  PRIMARY KEY (`Empresa_idEmpresa`, `Cliente_cpf`),
  INDEX `fk_Empresa_has_Cliente_Cliente1_idx` (`Cliente_cpf` ASC) VISIBLE,
  INDEX `fk_Empresa_has_Cliente_Empresa1_idx` (`Empresa_idEmpresa` ASC) VISIBLE,
  CONSTRAINT `fk_Empresa_has_Cliente_Empresa1`
    FOREIGN KEY (`Empresa_idEmpresa`)
    REFERENCES `projeto`.`Empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empresa_has_Cliente_Cliente1`
    FOREIGN KEY (`Cliente_cpf`)
    REFERENCES `projeto`.`Cliente` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into Fornecedor(idFornecedor, nome, cnpj, Empresa_idEmpresa) values('1','Gigabyte','12345678910','1');
insert into Fornecedor(idFornecedor, nome, cnpj, Empresa_idEmpresa) values('2','Terabyte','12345678911','2');
insert into Fornecedor(idFornecedor, nome, cnpj, Empresa_idEmpresa) values('3','Megabyte','12345678912','3');

insert into Empresa(idEmpresa, nome, cnpj, numFuncionarios,produto) values('1','TecnoByte','12345678920','10','Notebook');
insert into Empresa(idEmpresa, nome, cnpj, numFuncionarios,produto) values('2','PcInfo','12345678921','5','PC Gamer');
insert into Empresa(idEmpresa, nome, cnpj, numFuncionarios,produto) values('3','Kabum','12345678922','1000','Eletr??nicos');

insert into Funcionario(idFuncionario, nome, salario, Empresa_idEmpresa) values('1','Leonardo','5000','3');
insert into Funcionario(idFuncionario, nome, salario, Empresa_idEmpresa) values('2','Luiz','3000','3');
insert into Funcionario(idFuncionario, nome, salario, Empresa_idEmpresa) values('3','Ayeska','1600','2');
insert into Funcionario(idFuncionario, nome, salario, Empresa_idEmpresa) values('4','Beatriz','1500','2');
insert into Funcionario(idFuncionario, nome, salario, Empresa_idEmpresa) values('5','Samuel','2500','1');
insert into Funcionario(idFuncionario, nome, salario, Empresa_idEmpresa) values('6','Gabriel','3400','1');

insert into Cliente(cpf, nome, idade) values('1002003004','Leo','21');
insert into Cliente(cpf, nome, idade) values('1002003005','Zalex','25');

insert into Empresa_has_Cliente(Empresa_idEmpresa, Cliente_cpf) values('1','1002003004'),('2','1002003004'),('3','1002003004'),
('1','1002003005'),('2','1002003005'),('3','1002003005');

CREATE USER 'DonoEmpresa'@'localhost' IDENTIFIED BY 'password';
GRANT select,insert,update,delete on `projeto`.`Empresa` TO DonoEmpresa@localhost;

CREATE USER 'DonoFornecedor'@'localhost' IDENTIFIED BY 'senha';
GRANT select,insert,update on `projeto`.`Fornecedor` TO DonoFornecedor@localhost;

select*from Empresa
