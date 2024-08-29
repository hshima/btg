package dev.h2smd.desafio.btg.domain;

import jakarta.persistence.*;


@Entity
@Table(name = "PEDIDO_PRODUTO", schema = "DESAFIO_BTG")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoProduto;
    @ManyToOne
    @JoinColumn(name = "pedido")
    private Pedido pedido;
    private String produto;
    private Integer quantidade;
    private Double preco;
}
