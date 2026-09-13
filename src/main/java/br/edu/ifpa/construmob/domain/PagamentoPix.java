package br.edu.ifpa.construmob.domain;
import br.edu.ifpa.construmob.domain.enums.TipoPagamento;
import jakarta.persistence.*;
@Entity @DiscriminatorValue("PIX")
public class PagamentoPix extends Pagamento {
 @Column(name="chave_pix",length=160) private String chavePix;
 protected PagamentoPix(){} public PagamentoPix(String chavePix){super(TipoPagamento.PIX);this.chavePix=chavePix;}
 @Override protected boolean validarPagamento(){return chavePix!=null&&!chavePix.isBlank()&&chavePix.length()>=5;}
 public String getChavePix(){return chavePix;}
}
