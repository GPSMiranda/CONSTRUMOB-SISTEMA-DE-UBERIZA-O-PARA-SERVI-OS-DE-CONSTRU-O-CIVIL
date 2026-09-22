package br.edu.ifpa.construmob.repository;
import br.edu.ifpa.construmob.domain.PedidoServico;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface PedidoServicoRepository extends JpaRepository<PedidoServico,Long>{
 @Override @EntityGraph(attributePaths={"itens","itens.servico","cliente","profissional"}) Optional<PedidoServico> findById(Long id);
 @EntityGraph(attributePaths={"itens","itens.servico","cliente","profissional"}) List<PedidoServico> findAllByOrderByDataDesc();
}
