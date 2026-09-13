package br.edu.ifpa.construmob.service;
import br.edu.ifpa.construmob.domain.Profissional;
import br.edu.ifpa.construmob.exception.RecursoNaoEncontradoException;
import br.edu.ifpa.construmob.repository.ProfissionalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service public class ProfissionalService{
 private final ProfissionalRepository repository; public ProfissionalService(ProfissionalRepository repository){this.repository=repository;}
 @Transactional(readOnly=true) public List<Profissional> listar(){return repository.findAll();}
 @Transactional(readOnly=true) public Profissional buscar(Long id){return repository.findById(id).orElseThrow(()->new RecursoNaoEncontradoException("Profissional não encontrado: "+id));}
 @Transactional public Profissional salvar(Profissional profissional){return repository.save(profissional);}
 @Transactional public void validar(Long id){buscar(id).validarCadastro();}
}
