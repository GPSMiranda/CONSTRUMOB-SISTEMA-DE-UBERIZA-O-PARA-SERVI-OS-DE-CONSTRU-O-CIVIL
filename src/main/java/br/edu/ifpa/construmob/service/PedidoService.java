package br.edu.ifpa.construmob.service;
import br.edu.ifpa.construmob.domain.*;
import br.edu.ifpa.construmob.domain.enums.TipoPagamento;
import br.edu.ifpa.construmob.exception.RecursoNaoEncontradoException;
import br.edu.ifpa.construmob.repository.PedidoServicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service public class PedidoService{
 private final PedidoServicoRepository repository; private final ClienteService clienteService; private final ProfissionalService profissionalService; private final ServicoService servicoService;
 public PedidoService(PedidoServicoRepository repository,ClienteService clienteService,ProfissionalService profissionalService,ServicoService servicoService){this.repository=repository;this.clienteService=clienteService;this.profissionalService=profissionalService;this.servicoService=servicoService;}
 @Transactional(readOnly=true) public List<PedidoServico> listar(){return repository.findAllByOrderByDataDesc();}
 @Transactional(readOnly=true) public PedidoServico buscar(Long numero){return repository.findById(numero).orElseThrow(()->new RecursoNaoEncontradoException("Pedido não encontrado: "+numero));}
 @Transactional public PedidoServico criar(Long clienteId,Long servicoId,int quantidade,String localidade,String descricao){Cliente cliente=clienteService.buscar(clienteId);Servico servico=servicoService.buscar(servicoId);PedidoServico pedido=new PedidoServico(cliente,localidade,descricao);pedido.adicionarItem(servico,quantidade);return repository.save(pedido);}
 @Transactional public void aceitar(Long numero,Long profissionalId){buscar(numero).aceitar(profissionalService.buscar(profissionalId));}
 @Transactional public void cancelar(Long numero){buscar(numero).cancelar();}
 @Transactional public void finalizar(Long numero,TipoPagamento tipo,String dadoPagamento){PedidoServico pedido=buscar(numero);Pagamento pagamento=PagamentoFactory.criar(tipo,dadoPagamento);pedido.definirPagamento(pagamento);pedido.finalizar();}
}
