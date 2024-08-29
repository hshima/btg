package dev.h2smd.desafio.btg.reporting;

import dev.h2smd.desafio.btg.domain.Pedido;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping("/total-pedido/{codigoPedido}")
    public Double totalPedido(@PathVariable("codigoPedido") Integer codigoPedido){
        return pedidoRepository.totalPedido(codigoPedido);
    }
    @GetMapping("/quantidade-pedidos/{codigoCliente}")
    public Integer qtyPedidos(@PathVariable Integer codigoCliente){
        return pedidoRepository.qtyPedidos(codigoCliente);
    }

    @GetMapping("/pedidos/{codigoCliente}")
    public List<Pedido> pedidos(@PathVariable Integer codigoCliente){
        return pedidoRepository.findPedidoByCodigoClienteEquals(codigoCliente);
    }
}
