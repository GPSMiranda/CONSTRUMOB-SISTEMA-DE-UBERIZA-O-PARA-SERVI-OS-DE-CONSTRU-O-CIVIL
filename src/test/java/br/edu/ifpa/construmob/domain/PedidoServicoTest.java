package br.edu.ifpa.construmob.domain;
import br.edu.ifpa.construmob.domain.enums.*;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
class PedidoServicoTest{
 @Test void deveCalcularTotalEAceitarProfissionalValidado(){Cliente c=new Cliente("Ana","ana@email.com","9999-9999");Servico s=new Servico("Pintura","Pintura",new BigDecimal("150.00"));Profissional p=new Profissional("Carlos","carlos@email.com","9888-8888","Pintor");p.validarCadastro();PedidoServico pedido=new PedidoServico(c,"Tucuruí","Pintar sala");pedido.adicionarItem(s,2);pedido.aceitar(p);assertEquals(new BigDecimal("300.00"),pedido.calcularTotal());assertEquals(StatusPedido.ACEITO,pedido.getStatus());}
 @Test void deveFinalizarComPagamentoPixValido(){Cliente c=new Cliente("Ana","ana@email.com","9999-9999");Servico s=new Servico("Reparo","Hidráulica",new BigDecimal("100.00"));Profissional p=new Profissional("Carlos","carlos@email.com","9888-8888","Encanador");p.validarCadastro();PedidoServico pedido=new PedidoServico(c,"Tucuruí","Reparo");pedido.adicionarItem(s,1);pedido.aceitar(p);pedido.definirPagamento(PagamentoFactory.criar(TipoPagamento.PIX,"email@pix.com"));pedido.finalizar();assertEquals(StatusPedido.FINALIZADO,pedido.getStatus());assertTrue(pedido.getPagamento().isValidado());}
}
