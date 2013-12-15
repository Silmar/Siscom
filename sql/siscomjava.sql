/*==============================================================*/
/* Database name:  SISCOMJAVA                                   */
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     22/07/2013 23:56:23                          */
/*==============================================================*/


drop database if exists SISCOMJAVA;

/*==============================================================*/
/* Database: SISCOMJAVA                                         */
/*==============================================================*/
create database SISCOMJAVA;

use SISCOMJAVA;

/*==============================================================*/
/* Table: BANCOS                                                */
/*==============================================================*/
create table BANCOS
(
   BANCO_COD            int not null auto_increment,
   BANCO_NOME           varchar(50) not null,
   BANCO_AGENCIA        integer,
   BANCO_CONTA          integer,
   BANCO_GERENTE        varchar(30),
   BANCO_FONE           varchar(10),
   primary key (BANCO_COD)
)
type = InnoDB;

/*==============================================================*/
/* Table: CARTAOS                                               */
/*==============================================================*/
create table CARTAOS
(
   CART_CODIGO          integer not null auto_increment,
   CART_NOME            varchar(20),
   CART_TAXA            double(5,2),
   primary key (CART_CODIGO)
)
type = InnoDB;

alter table CARTAOS comment 'Cartãos de crédito';

/*==============================================================*/
/* Table: CFOP                                                  */
/*==============================================================*/
create table CFOP
(
   CFOP_COD             int not null,
   CFOP_DESCRICAO       text,
   primary key (CFOP_COD)
)
type = InnoDB;

/*==============================================================*/
/* Table: CHEQUE_NCOMP                                          */
/*==============================================================*/
create table CHEQUE_NCOMP
(
   CHKNCOMP_COD         int not null auto_increment,
   CHKNCOMP_NUM_CHEQUE  int,
   CHKNCOMP_DATA_CHEQUE date,
   CHKNCOMP_VLR_CHEQUE  double(11,2),
   CHKNCOMP_MES_ANO     varchar(7),
   CHKNCOMP_HISTORICO   varchar(50),
   primary key (CHKNCOMP_COD)
)
type = InnoDB;

/*==============================================================*/
/* Table: CLIENTES                                              */
/*==============================================================*/
create table CLIENTES
(
   CLI_CODIGO           int not null auto_increment comment 'Codigo cliente, auto incremento',
   CLI_NOME             varchar(50) not null,
   CLI_CPF              varchar(11),
   CLI_RG               varchar(25),
   CLI_ORGAO_RG         varchar(10),
   CLI_NASCIMENTO       date,
   CLI_DESDE            date,
   CLI_PROFISSAO        varchar(40),
   CLI_EMPRESA          varchar(50),
   CLI_FONE_EMPRESA     varchar(10),
   CLI_RENDA            double(11,2),
   CLI_TIPO_FIS_JURI    char(1) comment 'Pessoas física ou jurídica?',
   CLI_CNPJ             varchar(14),
   CLI_REFERENCIA       varchar(50),
   CLI_FONE_REFERENCIA  varchar(10),
   EMAIL                varchar(100),
   primary key (CLI_CODIGO)
)
type = InnoDB;

alter table CLIENTES comment 'tabela que armazena os dados dos clientes';

/*==============================================================*/
/* Table: CLIENTES_ENDERECOS                                    */
/*==============================================================*/
create table CLIENTES_ENDERECOS
(
   ENDE_CODIGO          int not null auto_increment,
   CLI_CODIGO           int comment 'Codigo cliente, auto incremento',
   ENDE_LOGRADOURO      varchar(50) not null,
   ENDE_COMPLEMENTO     varchar(50),
   ENDE_CEP             varchar8,
   ENDE_BAIRRO          varchar(50),
   ENDE_CIDADE          varchar(50),
   ENDE_UF              char(2) default 'PA',
   primary key (ENDE_CODIGO)
)
type = InnoDB;

/*==============================================================*/
/* Table: CLIENTES_TELEFONE                                     */
/*==============================================================*/
create table CLIENTES_TELEFONE
(
   TELEFONE_CODIGO      int not null auto_increment,
   CLI_CODIGO           int comment 'Codigo cliente, auto incremento',
   TELEFONE_NUMERO      varchar(10),
   TELEFONE_TIPO        char(1),
   primary key (TELEFONE_CODIGO)
)
type = InnoDB;

alter table CLIENTES_TELEFONE comment 'Telefone dos clientes
';

/*==============================================================*/
/* Table: COBRANCAS                                             */
/*==============================================================*/
create table COBRANCAS
(
   COBRA_COD            int not null auto_increment,
   CLI_CODIGO           int comment 'Codigo cliente, auto incremento',
   COBRA_ASSU_NTO       varchar(50),
   COBRA_TEXTO          text,
   ENVIO1               date,
   ENVIO2               date,
   ENVIO3               date,
   ENVIO4               date,
   ENVIO5               date,
   COD_PROCESSO         varchar(30),
   DATA_PROCESSO        date,
   ADVOGADO_PROCESSO    varchar(50),
   primary key (COBRA_COD)
)
type = InnoDB;

/*==============================================================*/
/* Table: CONCILIACAO                                           */
/*==============================================================*/
create table CONCILIACAO
(
   CONCIL_COD           int not null auto_increment,
   CONCIL_NUM_CHEQUE    int,
   CONCIL_DATA_CHEQUE   date,
   CONCIL_VLR_CHEQUE    double(11,2),
   CONCIL_MES_ANO       varchar(7),
   CONCIL_HISTORICO     varchar(50),
   primary key (CONCIL_COD)
)
type = InnoDB;

/*==============================================================*/
/* Table: COT_CAB                                               */
/*==============================================================*/
create table COT_CAB
(
   COTCAB_COD           integer not null auto_increment,
   COTCAT_DATA          date,
   FORN1                integer,
   FORN2                integer,
   FORN3                integer,
   FORN4                integer,
   FORN5                integer,
   CONDICOES1           varchar(30),
   CONDICOES2           varchar(30),
   CONDICOES3           varchar(30),
   CONDICOES4           varchar(30),
   CONDICOES5           varchar(30),
   DESCONTO1            double(11,2),
   DESCONTO2            double(11,2),
   DESCONTO3            double(11,2),
   DESCONTO4            double(11,2),
   DESCONTO5            double(11,2),
   ENTREGA1             varchar(30),
   ENTREGA2             varchar(30),
   ENTREGA3             varchar(30),
   ENTREGA4             varchar(30),
   ENTREGA5             varchar(30),
   TOTAL1               double(11,2),
   TOTAL2               double(11,2),
   TOTAL3               double(11,2),
   TOTAL4               double(11,2),
   TOTAL5               double(11,2),
   primary key (COTCAB_COD)
)
type = InnoDB;

alter table COT_CAB comment 'Cabeçalho para cotações';

/*==============================================================*/
/* Table: COT_DETALHE                                           */
/*==============================================================*/
create table COT_DETALHE
(
   COTCAB_COD           integer not null,
   REQCAB_COD           integer not null,
   PRODUTO_CODIGO       int not null,
   COTDETQTDE           integer,
   COTDET_UNIT1         double(11,2),
   COTDET_UNIT2         double(11,2),
   COTDET_UNIT3         double(11,2),
   COTDET_UNIT4         double(11,2),
   COTDET_UNIT5         double(11,2),
   COTDET_TOTAL1        double(11,2),
   COTDET_TOTAL2        double(11,2),
   COTDET_TOTAL3        double(11,2),
   COTDET_TOTAL4        double(11,2),
   COTDET_TOTAL5        double(11,2),
   primary key (COTCAB_COD, REQCAB_COD, PRODUTO_CODIGO)
)
type = InnoDB;

/*==============================================================*/
/* Table: DEPARTAMENTOS                                         */
/*==============================================================*/
create table DEPARTAMENTOS
(
   DEPART_CODIGO        integer not null auto_increment,
   DEPART_NOME          varchar(50),
   primary key (DEPART_CODIGO)
)
type = InnoDB;

/*==============================================================*/
/* Table: FECHAMENTO                                            */
/*==============================================================*/
create table FECHAMENTO
(
   FECHA_CODIGO         integer not null auto_increment,
   FECHA_MES_ANO        varchar(7),
   VLR_SALDO_ANTERIOR   double(11,2),
   VLR_RECEBIMENTOS     double(11,2,
   VLR_PAGAMENTOS       double(11,2),
   VLR_CHEQUE_NCOMP     double(11,2,
   VLR_SALDO_CONTA      double(11,2),
   VLR_SALDO_REAL       double(11,2),
   primary key (FECHA_CODIGO)
)
type = InnoDB;

/*==============================================================*/
/* Table: FORNECEDORES                                          */
/*==============================================================*/
create table FORNECEDORES
(
   FORNEC_COD           integer not null auto_increment,
   FORNEC_NOME          varchar(50),
   FORNEC_CPF           varchar(11),
   FORNEC_RG            varchar(25),
   FORNEC_RG_ORGAO      varchar(10),
   FORNEC_CNPJ          varchar(14),
   FORNECEDOR_TIPO      char(1),
   FORNEC_ENDERECO      varchar(100),
   FORNEC_BAIRRO        varchar(50),
   FORNEC_CIDADE        varchar(50),
   FORNEC_UF            char(2),
   FORNEC_CEP           char(8),
   FORNEC_EMAIL         varchar(100),
   FORNEC_SITE          varchar(100),
   FORNEC_FONE          varchar(10),
   FORNEC_CELULAR       varchar(10),
   FORNEC_FAX           varchar(10),
   primary key (FORNEC_COD)
)
type = InnoDB;

alter table FORNECEDORES comment 'Armazena os fornecedores para a empresa';

/*==============================================================*/
/* Table: FUNCIONARIOS                                          */
/*==============================================================*/
create table FUNCIONARIOS
(
   FUNC_CODIGO          int not null auto_increment,
   DEPART_CODIGO        integer,
   FUNC_NOME            varchar(50),
   FUNC_FUNCAO          varchar(50),
   FUNC_LOGIN           varchar(10),
   FUNC_SENHA           varchar(10),
   FUNC_ADMISSAO        date,
   FUNC_ACESSO_TOTAL    char(1),
   primary key (FUNC_CODIGO)
)
type = InnoDB;

/*==============================================================*/
/* Table: MOVIMENTO                                             */
/*==============================================================*/
create table MOVIMENTO
(
   MOV_COD              integer not null auto_increment,
   COD_PLANO_COMPRA     integer(4),
   MOV_COD_MES_ANO      varchar(7),
   MOV_NUM_CHEQUE       integer,
   MOV_NUM_DOCUMENTO    varchar(20),
   MOV_DATA_CHEQUE      date,
   MOV_DATA_LCTO        date,
   MOV_HISTORICO_MOVIMENTO varchar(50),
   MOV_VLR_DOCUMENTO    double(11,2),
   primary key (MOV_COD)
)
type = InnoDB;

/*==============================================================*/
/* Table: NFE_CAB                                               */
/*==============================================================*/
create table NFE_CAB
(
   NFECAB_NUMERO        integer not null,
   CFOP_COD             int,
   FORNEC_COD           integer,
   NFECAB_EMISSAO       date,
   NFECAB_ENTRADA       date,
   NFECAB_TOTAL         double(11,2),
   primary key (NFECAB_NUMERO)
)
type = InnoDB;

/*==============================================================*/
/* Table: NFE_DET                                               */
/*==============================================================*/
create table NFE_DET
(
   NFECAB_NUMERO        integer not null,
   PRODUTO_CODIGO       int not null,
   NFEDET_QTDE          integer,
   NFEDET_VLR_UNIT_     double(11,2),
   NFEDET_VLR_TOTAL     double(11,2),
   primary key (NFECAB_NUMERO, PRODUTO_CODIGO)
)
type = InnoDB;

/*==============================================================*/
/* Table: ORC_CAB                                               */
/*==============================================================*/
create table ORC_CAB
(
   ORCCAB_COD           int not null auto_increment,
   FUNC_CODIGO          int,
   CLI_CODIGO           int comment 'Codigo cliente, auto incremento',
   ORCCAB_DATA          date not null,
   ORCCAB_VLR           double(11,2) not null,
   primary key (ORCCAB_COD)
)
type = InnoDB;

alter table ORC_CAB comment 'Cabeçalho para as os orçamentos do sistema.
';

/*==============================================================*/
/* Table: ORC_DET                                               */
/*==============================================================*/
create table ORC_DET
(
   ORCCAB_COD           int not null,
   PRODUTO_CODIGO       int not null,
   ORCDET_QTDE          integer,
   ORCDETVLR_UNIT       double(11,2),
   ORCDET_VLR_TOTAL     double(11,2),
   primary key (ORCCAB_COD, PRODUTO_CODIGO)
)
type = InnoDB;

alter table ORC_DET comment 'Detalhes dos orçamentos.';

/*==============================================================*/
/* Table: PAGAMENTOS                                            */
/*==============================================================*/
create table PAGAMENTOS
(
   PAG_CODIGO           int not null auto_increment,
   TIPOPGTO_COD         int,
   COD_PLANO_COMPRA     integer(4),
   FORNEC_COD           integer,
   BANCO_COD            int,
   PAG_NUM_DOC          varchar(20),
   PAG_VALOR            double(11,2),
   PAG_VLR_TOTAL        double(11,2),
   PAG_VLR_JURO         double(11,2),
   PAG_VLR_MULTA        double(11,2),
   PAG_VLR_DESCONTO     double(11,2),
   PAG_VLR_PAGO_PAGAMENTO double(11,2),
   PAG_NUM_CHEQUE       integer,
   PAG_NOMINAL          varchar(50),
   PAG_EMISSAO          date,
   PAG_LANCAMENTO       date,
   PAG_VENCIMENTO       date,
   PAG_DATA             date,
   PAG_CHEQUE_DATA      date,
   primary key (PAG_CODIGO)
)
type = InnoDB;

/*==============================================================*/
/* Table: PEDIDO_CAB                                            */
/*==============================================================*/
create table PEDIDO_CAB
(
   PEDCAB_COD           int not null auto_increment,
   COTCAB_COD           integer,
   FORNEC_COD           integer,
   PEDCAB_DATA          date,
   PEDCAB_ENDERECO_ENTREGA varchar(50),
   PEDCAB_ENDERECO_COBRANCA varchar(50),
   PEDCAB_VLR           doubld(11,2),
   PEDCAB_DESCONTO      double(11,2),
   PEDCAB_TOTAL         double(11,2),
   primary key (PEDCAB_COD)
)
type = InnoDB;

/*==============================================================*/
/* Table: PEDIDO_DETALHE                                        */
/*==============================================================*/
create table PEDIDO_DETALHE
(
   PEDCAB_COD           int not null,
   COTCAB_COD           integer not null,
   REQCAB_COD           integer not null,
   PRODUTO_CODIGO       int not null,
   PEDDET_QTDE          integer,
   PEDDET_VLR_UNIT      double(11,2),
   PEDDET_VLR_TOTAL     double(11,2),
   primary key (PEDCAB_COD, COTCAB_COD, REQCAB_COD, PRODUTO_CODIGO)
)
type = InnoDB;

/*==============================================================*/
/* Table: PLANO_CONTAS                                          */
/*==============================================================*/
create table PLANO_CONTAS
(
   COD_PLANO_COMPRA     integer(4) not null auto_increment,
   PLANO_COMPRA_DESCRICAO varchar(20),
   primary key (COD_PLANO_COMPRA)
)
type = InnoDB;

/*==============================================================*/
/* Table: PRODUTOS                                              */
/*==============================================================*/
create table PRODUTOS
(
   PRODUTO_CODIGO       int not null,
   UNIDADES_CODIGO      integer,
   ENDE_CODIGO          int,
   PROD_DESCRICAO       varchar(50),
   PROD_VALOR_COMPRA    double(11,2),
   PROD_VALOR_VENDA     double(11,2),
   ESTOQUE_PRODUTO      integer,
   PROD_CRITICO         integer,
   primary key (PRODUTO_CODIGO)
)
type = InnoDB;

/*==============================================================*/
/* Table: RECEBIMENTOS                                          */
/*==============================================================*/
create table RECEBIMENTOS
(
   REC_CODIGO           int not null auto_increment,
   TIPOPGTO_COD         int,
   CLI_CODIGO           int comment 'Codigo cliente, auto incremento',
   BANCO_COD            int,
   REC_NUM_DOCUMENTO    varchar(20),
   REC_VLR__TOTAL       double(11,2),
   REC_VLR_JURO         double(11,2),
   REC_VLR_MULTA        double(11,2),
   REC_VLR_DESCONTO     double(11,2),
   REC_VLR_RECEBIDO     double(11,2),
   REC_EMISSAO          date,
   REC_LANCAMENTO       date,
   REC_VENCIMENTO       date,
   REC_DATA             date,
   primary key (REC_CODIGO)
)
type = InnoDB;

/*==============================================================*/
/* Table: REQ_CAB                                               */
/*==============================================================*/
create table REQ_CAB
(
   REQCAB_COD           integer not null auto_increment,
   FUNC_CODIGO          int,
   REQCAB_DATA          date,
   primary key (REQCAB_COD)
)
type = InnoDB;

/*==============================================================*/
/* Table: REQ_DET                                               */
/*==============================================================*/
create table REQ_DET
(
   REQCAB_COD           integer not null,
   PRODUTO_CODIGO       int not null,
   REQDET_QTDE          integer,
   REQDET_FLR_UNIT      double(11,2),
   REQDET_VLR_TOTAL     double(11,2,
   primary key (REQCAB_COD, PRODUTO_CODIGO)
)
type = InnoDB;

alter table REQ_DET comment 'Detalhes da requisição';

/*==============================================================*/
/* Table: TIPO_PAGAMENTOS                                       */
/*==============================================================*/
create table TIPO_PAGAMENTOS
(
   TIPOPGTO_COD         int not null auto_increment,
   TIPOPGTO_DESC        varchar(20),
   primary key (TIPOPGTO_COD)
)
type = InnoDB;

/*==============================================================*/
/* Table: UNIDADES                                              */
/*==============================================================*/
create table UNIDADES
(
   UNIDADES_CODIGO      integer not null auto_increment,
   UNIDADES_DESCRICAO   varchar(5),
   primary key (UNIDADES_CODIGO)
)
type = InnoDB;

alter table UNIDADES comment 'Armazena as unidades do sistema';

/*==============================================================*/
/* Table: VENDAS_CAB                                            */
/*==============================================================*/
create table VENDAS_CAB
(
   VENCAB_COD           int not null auto_increment,
   CLI_CODIGO           int comment 'Codigo cliente, auto incremento',
   CART_CODIGO          integer,
   FUNC_CODIGO          int,
   CFOP_COD             int,
   VENCAB_DATA_VANDA    date not null,
   VENCAB_VLR_VENDA     double(11,2) not null,
   VENCAB_DESCONTO      double(11,2),
   VENCAB_TOTAL         double(11,2),
   VENCAB_NUM_PARCELAS  integer,
   VENCAB_PRI_VENC      date,
   VENCAB_NUM_NF        integer,
   primary key (VENCAB_COD)
)
type = InnoDB;

alter table VENDAS_CAB comment 'Cabeçalho para as vendas do sistema.
';

/*==============================================================*/
/* Table: VENDA_DET                                             */
/*==============================================================*/
create table VENDA_DET
(
   VENCAB_COD           int not null,
   PRODUTO_CODIGO       int not null,
   VENDADET_QTDE        integer,
   VENDADET_VLR_UNIT    double(11,2),
   VENDADET_VLR_TOTAL   double(11,2),
   primary key (VENCAB_COD, PRODUTO_CODIGO)
)
type = InnoDB;

alter table VENDA_DET comment 'Detalhes das vendas';

alter table CLIENTES_ENDERECOS add constraint FK_CLIENTE_ENDERECO foreign key (CLI_CODIGO)
      references CLIENTES (CLI_CODIGO) on delete cascade on update restrict;

alter table CLIENTES_TELEFONE add constraint FK_CLIENTE_TELEFONE foreign key (CLI_CODIGO)
      references CLIENTES (CLI_CODIGO) on delete restrict on update restrict;

alter table COBRANCAS add constraint FK_CLIENTE_COBRANCA foreign key (CLI_CODIGO)
      references CLIENTES (CLI_CODIGO) on delete restrict on update restrict;

alter table COT_DETALHE add constraint FK_COT_DETALHE_COT_CAB foreign key (COTCAB_COD)
      references COT_CAB (COTCAB_COD) on delete restrict on update restrict;

alter table COT_DETALHE add constraint FK_COT_DETALHE_REQ_DETALHE foreign key (REQCAB_COD, PRODUTO_CODIGO)
      references REQ_DET (REQCAB_COD, PRODUTO_CODIGO) on delete restrict on update restrict;

alter table FUNCIONARIOS add constraint FK_FUNCIONARIO_DEPARTAMENTO foreign key (DEPART_CODIGO)
      references DEPARTAMENTOS (DEPART_CODIGO) on delete restrict on update restrict;

alter table MOVIMENTO add constraint FK_MOVIMENTO_PLANO_CONTAS foreign key (COD_PLANO_COMPRA)
      references PLANO_CONTAS (COD_PLANO_COMPRA) on delete restrict on update restrict;

alter table NFE_CAB add constraint FK_NFECAB_CFOP foreign key (CFOP_COD)
      references CFOP (CFOP_COD) on delete restrict on update restrict;

alter table NFE_CAB add constraint FK_NFECAB_FORNECEDORES foreign key (FORNEC_COD)
      references FORNECEDORES (FORNEC_COD) on delete restrict on update restrict;

alter table NFE_DET add constraint FK_NFEDET_NFECAB foreign key (NFECAB_NUMERO)
      references NFE_CAB (NFECAB_NUMERO) on delete restrict on update restrict;

alter table NFE_DET add constraint FK_NFEDET_PRODUTOS foreign key (PRODUTO_CODIGO)
      references PRODUTOS (PRODUTO_CODIGO) on delete restrict on update restrict;

alter table ORC_CAB add constraint FK_ORC_CAB__CLIENTES foreign key (CLI_CODIGO)
      references CLIENTES (CLI_CODIGO) on delete restrict on update restrict;

alter table ORC_CAB add constraint FK_ORC_CAB__FUNCIONARIOS foreign key (FUNC_CODIGO)
      references FUNCIONARIOS (FUNC_CODIGO) on delete restrict on update restrict;

alter table ORC_DET add constraint FK_ORC_CAB__ORC_DET foreign key (ORCCAB_COD)
      references ORC_CAB (ORCCAB_COD) on delete restrict on update restrict;

alter table ORC_DET add constraint FK_PRODUTOS__ORC_DET foreign key (PRODUTO_CODIGO)
      references PRODUTOS (PRODUTO_CODIGO) on delete restrict on update restrict;

alter table PAGAMENTOS add constraint FK_PAGAMENTO_BANCOS foreign key (BANCO_COD)
      references BANCOS (BANCO_COD) on delete restrict on update restrict;

alter table PAGAMENTOS add constraint FK_PAGAMENTO_FORNECEDOR foreign key (FORNEC_COD)
      references FORNECEDORES (FORNEC_COD) on delete restrict on update restrict;

alter table PAGAMENTOS add constraint FK_PAGAMENTO_PLANO_CONTAS foreign key (COD_PLANO_COMPRA)
      references PLANO_CONTAS (COD_PLANO_COMPRA) on delete restrict on update restrict;

alter table PAGAMENTOS add constraint FK_PAGAMENTO_TIPO_PAGAMENTOS foreign key (TIPOPGTO_COD)
      references TIPO_PAGAMENTOS (TIPOPGTO_COD) on delete restrict on update restrict;

alter table PEDIDO_CAB add constraint FK_COT_CAB_PEDIDO_CAB foreign key (COTCAB_COD)
      references COT_CAB (COTCAB_COD) on delete restrict on update restrict;

alter table PEDIDO_CAB add constraint FK_PEDIDO_CAB__FORNECEDORES foreign key (FORNEC_COD)
      references FORNECEDORES (FORNEC_COD) on delete restrict on update restrict;

alter table PEDIDO_DETALHE add constraint FK_PEDIDO_DETALHE__PEDIDO_CAB foreign key (PEDCAB_COD)
      references PEDIDO_CAB (PEDCAB_COD) on delete restrict on update restrict;

alter table PEDIDO_DETALHE add constraint FK_PEDIDO_DETALHE___COTACAO_DETALHE foreign key (COTCAB_COD, REQCAB_COD, PRODUTO_CODIGO)
      references COT_DETALHE (COTCAB_COD, REQCAB_COD, PRODUTO_CODIGO) on delete restrict on update restrict;

alter table PRODUTOS add constraint FK_FORNECEDOR_PRODUTO foreign key (ENDE_CODIGO)
      references CLIENTES_ENDERECOS (ENDE_CODIGO) on delete restrict on update restrict;

alter table PRODUTOS add constraint FK_UNIDADE_PRODUTO foreign key (UNIDADES_CODIGO)
      references UNIDADES (UNIDADES_CODIGO) on delete restrict on update restrict;

alter table RECEBIMENTOS add constraint FK_RECEBIMENTOS_BANCOS foreign key (BANCO_COD)
      references BANCOS (BANCO_COD) on delete restrict on update restrict;

alter table RECEBIMENTOS add constraint FK_RECEBIMENTOS_TIPO_PAGAMENTOS foreign key (TIPOPGTO_COD)
      references TIPO_PAGAMENTOS (TIPOPGTO_COD) on delete restrict on update restrict;

alter table RECEBIMENTOS add constraint FK_RECEBIMENTO_CLIENTES foreign key (CLI_CODIGO)
      references CLIENTES (CLI_CODIGO) on delete restrict on update restrict;

alter table REQ_CAB add constraint FK_FUNCIONARIO_REQCAB foreign key (FUNC_CODIGO)
      references FUNCIONARIOS (FUNC_CODIGO) on delete restrict on update restrict;

alter table REQ_DET add constraint FK_REQDET_PRODUTOS foreign key (PRODUTO_CODIGO)
      references PRODUTOS (PRODUTO_CODIGO) on delete restrict on update restrict;

alter table REQ_DET add constraint FK_REQDET_REQCAB foreign key (REQCAB_COD)
      references REQ_CAB (REQCAB_COD) on delete restrict on update restrict;

alter table VENDAS_CAB add constraint FK_VENDA_CARTAOS foreign key (CART_CODIGO)
      references CARTAOS (CART_CODIGO) on delete restrict on update restrict;

alter table VENDAS_CAB add constraint FK_VENDA_CFOP foreign key (CFOP_COD)
      references CFOP (CFOP_COD) on delete restrict on update restrict;

alter table VENDAS_CAB add constraint FK_VENDA_CLIENTE foreign key (CLI_CODIGO)
      references CLIENTES (CLI_CODIGO) on delete restrict on update restrict;

alter table VENDAS_CAB add constraint FK_VENDA_FUNCIONARIOS foreign key (FUNC_CODIGO)
      references FUNCIONARIOS (FUNC_CODIGO) on delete restrict on update restrict;

alter table VENDA_DET add constraint FK_VENDADET_PRODUTOS foreign key (PRODUTO_CODIGO)
      references PRODUTOS (PRODUTO_CODIGO) on delete restrict on update restrict;

alter table VENDA_DET add constraint FK_VENDADET_VENDAS_CAB foreign key (VENCAB_COD)
      references VENDAS_CAB (VENCAB_COD) on delete restrict on update restrict;

