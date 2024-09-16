-- Criando a sequência para a tabela T_USUARIO
CREATE SEQUENCE SEQ_T_USUARIO
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

-- Criando a tabela T_USUARIO
CREATE TABLE TBL_USER (
    ID_USUARIO INTEGER DEFAULT SEQ_T_USUARIO.NEXTVAL NOT NULL PRIMARY KEY,  -- Define o valor padrão usando a sequência
    NM_USUARIO VARCHAR2(100) NOT NULL,
    CONTAS VARCHAR2(2000),
    PASSWORD VARCHAR2(100) NOT NULL,
    PF_COLORS VARCHAR2(200),
    PF_THEME NUMBER(1) DEFAULT 0
    --CONSTRAINT PK_USUARIO PRIMARY KEY (ID_USUARIO)  -- Definindo a chave primária
);
