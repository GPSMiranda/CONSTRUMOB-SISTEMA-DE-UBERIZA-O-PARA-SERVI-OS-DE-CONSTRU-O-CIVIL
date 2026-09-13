package br.edu.ifpa.construmob.service;
import br.edu.ifpa.construmob.domain.Cliente;
import br.edu.ifpa.construmob.exception.RecursoNaoEncontradoException;
import br.edu.ifpa.construmob.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service public class ClienteService{
 private final ClienteRepository repository; public ClienteService(ClienteRepository repository){this.repository=repository;}
 @Transactional(readOnly=true) public List<Cliente> listar(){return repository.findAll();}
 @Transactional(readOnly=true) public Cliente buscar(Long id){return repository.findById(id).orElseThrow(()->new RecursoNaoEncontradoException("Cliente não encontrado: "+id));}
 @Transactional public Cliente salvar(Cliente cliente){return repository.save(cliente);}
}
