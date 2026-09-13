package br.edu.ifpa.construmob.service;
import br.edu.ifpa.construmob.domain.Servico;
import br.edu.ifpa.construmob.exception.RecursoNaoEncontradoException;
import br.edu.ifpa.construmob.repository.ServicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service public class ServicoService{
 private final ServicoRepository repository; public ServicoService(ServicoRepository repository){this.repository=repository;}
 @Transactional(readOnly=true) public List<Servico> listar(){return repository.findAll();}
 @Transactional(readOnly=true) public Servico buscar(Long id){return repository.findById(id).orElseThrow(()->new RecursoNaoEncontradoException("Serviço não encontrado: "+id));}
 @Transactional public Servico salvar(Servico servico){return repository.save(servico);}
}
