package br.edu.ifpa.construmob.service;
import br.edu.ifpa.construmob.domain.Avaliacao;
import br.edu.ifpa.construmob.domain.PedidoServico;
import br.edu.ifpa.construmob.repository.AvaliacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service public class AvaliacaoService{
 private final AvaliacaoRepository repository; private final PedidoService pedidoService;
 public AvaliacaoService(AvaliacaoRepository repository,PedidoService pedidoService){this.repository=repository;this.pedidoService=pedidoService;}
 @Transactional public Avaliacao avaliar(Long pedidoId,int nota,String comentario){PedidoServico pedido=pedidoService.buscar(pedidoId);return repository.save(new Avaliacao(pedido,nota,comentario));}
}
