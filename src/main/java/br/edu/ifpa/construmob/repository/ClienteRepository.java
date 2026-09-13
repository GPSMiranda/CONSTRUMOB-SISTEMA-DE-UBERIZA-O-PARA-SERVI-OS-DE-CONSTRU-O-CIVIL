package br.edu.ifpa.construmob.repository;
import br.edu.ifpa.construmob.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository extends JpaRepository<Cliente,Long>{}
