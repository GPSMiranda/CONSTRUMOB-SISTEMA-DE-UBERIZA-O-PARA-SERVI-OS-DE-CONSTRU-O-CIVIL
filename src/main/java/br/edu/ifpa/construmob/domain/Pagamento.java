package br.edu.ifpa.construmob.domain;
import br.edu.ifpa.construmob.domain.enums.TipoPagamento;
import jakarta.persistence.*;
@Entity @Table(name="pagamento") @Inheritance(strategy=InheritanceType.SINGLE_TABLE) @DiscriminatorColumn(name="subtipo")
public abstract class Pagamento {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private TipoPagamento tipo;
 @Column(nullable=false) private boolean validado;
 protected Pagamento(){} protected Pagamento(TipoPagamento tipo){this.tipo=tipo;}
 public final boolean processarValidacao(){this.validado=validarPagamento();return this.validado;}
 protected abstract boolean validarPagamento();
 public Long getId(){return id;} public TipoPagamento getTipo(){return tipo;} public boolean isValidado(){return validado;}
}
