package dev.h2smd.desafio.btg.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name="PEDIDOS", schema = "DESAFIO_BTG")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoPedido;

    private String codigoCliente;

    @OneToMany(cascade=ALL, mappedBy = "pedido")
    private List<ItemPedido> itens;
}
