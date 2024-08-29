CREATE SCHEMA BTG;
--{
--   "codigoPedido": 1001,
--   "codigoCliente":1,
--   "itens": [
--       {
--           "produto": "lápis",
--           "quantidade": 100,
--           "preco": 1.10
--       },
--       {
--           "produto": "caderno",
--           "quantidade": 10,
--           "preco": 1.00
--       }
--   ]
--}
CREATE TABLE IF NOT EXISTS BTG.PEDIDO(
    CODIGO_PEDIDO   INTEGER PRIMARY KEY,
    CODIGO_CLIENTE  INTEGER
);
CREATE TABLE IF NOT EXISTS BTG.PEDIDO_PRODUTO(
    CODIGO_PRODUTO  INTEGER PRIMARY KEY,
    CODIGO_PEDIDO   INTEGER REFERENCES BTG.PEDIDO(CODIGO_PEDIDO),
    PRODUTO         VARCHAR(255),
    QUANTIDADE      INTEGER,
    PRECO           FLOAT
);
