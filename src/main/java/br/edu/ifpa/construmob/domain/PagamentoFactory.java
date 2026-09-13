package br.edu.ifpa.construmob.domain;
import br.edu.ifpa.construmob.domain.enums.TipoPagamento;
public final class PagamentoFactory {
 private PagamentoFactory(){}
 public static Pagamento criar(TipoPagamento tipo,String dadoPagamento){if(tipo==null)throw new IllegalArgumentException("Tipo de pagamento obrigatório.");return switch(tipo){case PIX->new PagamentoPix(dadoPagamento);case CARTAO->new PagamentoCartao(dadoPagamento);};}
}
