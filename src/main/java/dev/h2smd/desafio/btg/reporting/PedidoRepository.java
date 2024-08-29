package dev.h2smd.desafio.btg.reporting;

import dev.h2smd.desafio.btg.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query(
            value = """
            select sum(i.preco)
            from PEDIDO_PRODUTO i
            where i.CODIGO_PEDIDO = ?1
            """,
            nativeQuery = true
    )
    Double totalPedido(Integer pedido);

    @Query(
            value="""
            select count(p.CODIGO_PEDIDO)
            from pedido p
            where p.CODIGO_CLIENTE = ?1
            """,
            nativeQuery = true
    )
    Integer qtyPedidos(Integer codigoCliente);

    @Query(value=
            """
            select p.CODIGO_PEDIDO
            from pedido p
            where p.CODIGO_CLIENTE = ?1
            """,
            nativeQuery = true
    )
    List<Pedido> findPedidoByCodigoClienteEquals(Integer codigoCliente);
}
