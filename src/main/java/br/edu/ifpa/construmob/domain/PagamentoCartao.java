package br.edu.ifpa.construmob.domain;
import br.edu.ifpa.construmob.domain.enums.TipoPagamento;
import jakarta.persistence.*;
@Entity @DiscriminatorValue("CARTAO")
public class PagamentoCartao extends Pagamento {
 @Column(name="ultimos_quatro_digitos",length=4) private String ultimosQuatroDigitos;
 protected PagamentoCartao(){} public PagamentoCartao(String ultimosQuatroDigitos){super(TipoPagamento.CARTAO);this.ultimosQuatroDigitos=ultimosQuatroDigitos;}
 @Override protected boolean validarPagamento(){return ultimosQuatroDigitos!=null&&ultimosQuatroDigitos.matches("\\d{4}");}
 public String getUltimosQuatroDigitos(){return ultimosQuatroDigitos;}
}
