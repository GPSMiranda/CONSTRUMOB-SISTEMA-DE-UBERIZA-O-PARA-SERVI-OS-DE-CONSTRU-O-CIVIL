package br.edu.ifpa.construmob.config;
import br.edu.ifpa.construmob.domain.*;
import br.edu.ifpa.construmob.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import java.math.BigDecimal;
@Configuration public class DataInitializer{
 @Bean CommandLineRunner seed(ClienteRepository clientes,ProfissionalRepository profissionais,ServicoRepository servicos){return args->{if(clientes.count()==0)clientes.save(new Cliente("Cliente Demonstração","cliente@construmob.local","(94) 99999-0001"));if(profissionais.count()==0){Profissional p=new Profissional("Profissional Demonstração","profissional@construmob.local","(94) 99999-0002","Reparos residenciais");p.validarCadastro();profissionais.save(p);}if(servicos.count()==0){servicos.save(new Servico("Reparo hidráulico","Hidráulica",new BigDecimal("180.00")));servicos.save(new Servico("Instalação de tomada","Elétrica",new BigDecimal("120.00")));servicos.save(new Servico("Pintura de parede","Pintura",new BigDecimal("250.00")));}};}
}
