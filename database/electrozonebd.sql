DROP DATABASE IF EXISTS electrozone;
CREATE SCHEMA IF NOT EXISTS electrozone DEFAULT CHARACTER SET utf8 ;
USE electrozone ;

-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS electrozone.`Usuario` (
  `cpf` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`cpf`));


-- -----------------------------------------------------
-- Table `mydb`.`Endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS electrozone.`Endereco` (
  `idEndereco` INT NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `numero` VARCHAR(5) NOT NULL,
  `complemento` VARCHAR(45) NULL,
  `cep` VARCHAR(8) NOT NULL,
  `Usuario_cpf` INT NOT NULL,
  PRIMARY KEY (`idEndereco`, `Usuario_cpf`),
  CONSTRAINT `fk_Endereco_Usuario`
    FOREIGN KEY (`Usuario_cpf`)
    REFERENCES electrozone.`Usuario` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS electrozone.`Compra` (
  `idCompra` INT NOT NULL,
  `valor` VARCHAR(45) NOT NULL,
  `data` DATE NOT NULL,
  `Usuario_cpf` INT NOT NULL,
  PRIMARY KEY (`idCompra`),
  CONSTRAINT `fk_Compra_Usuario1`
    FOREIGN KEY (`Usuario_cpf`)
    REFERENCES electrozone.`Usuario` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table `mydb`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS electrozone.`Categoria` (
  `idCategoria` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategoria`));

-- -----------------------------------------------------
-- Table `mydb`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS electrozone.`Produto` (
  `idProduto` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `valor` DOUBLE NOT NULL,
  `qtd_disponivel` INT NULL,
  `Categoria_idCategoria` INT NOT NULL,
  PRIMARY KEY (`idProduto`),
  CONSTRAINT `fk_Produto_Categoria1`
    FOREIGN KEY (`Categoria_idCategoria`)
    REFERENCES electrozone.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`Compra_has_Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS electrozone.`Compra_has_Produto` (
  `Compra_idCompra` INT NOT NULL,
  `Produto_idProduto` INT NOT NULL,
  PRIMARY KEY (`Compra_idCompra`, `Produto_idProduto`),
  CONSTRAINT `fk_Compra_has_Produto_Compra1`
    FOREIGN KEY (`Compra_idCompra`)
    REFERENCES electrozone.`Compra` (`idCompra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compra_has_Produto_Produto1`
    FOREIGN KEY (`Produto_idProduto`)
    REFERENCES electrozone.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`Imagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS electrozone.`Imagem` (
  `idImagem` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `dados_imagem` BLOB NOT NULL,
  `Produto_idProduto` INT NOT NULL,
  PRIMARY KEY (`idImagem`),
  CONSTRAINT `fk_Imagem_Produto1`
    FOREIGN KEY (`Produto_idProduto`)
    REFERENCES electrozone.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table `mydb`.`Carrinho`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS electrozone.`Carrinho` (
  `idCarrinho` INT NOT NULL,
  `Usuario_cpf` INT NOT NULL,
  PRIMARY KEY (`idCarrinho`),
  CONSTRAINT `fk_Carrinho_Usuario1`
    FOREIGN KEY (`Usuario_cpf`)
    REFERENCES electrozone.`Usuario` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table `mydb`.`Carrinho_has_Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS electrozone.`Carrinho_has_Produto` (
  `Carrinho_idCarrinho` INT NOT NULL,
  `Produto_idProduto` INT NOT NULL,
  PRIMARY KEY (`Carrinho_idCarrinho`, `Produto_idProduto`),
  CONSTRAINT `fk_Carrinho_has_Produto_Carrinho1`
    FOREIGN KEY (`Carrinho_idCarrinho`)
    REFERENCES electrozone.`Carrinho` (`idCarrinho`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Carrinho_has_Produto_Produto1`
    FOREIGN KEY (`Produto_idProduto`)
    REFERENCES electrozone.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
