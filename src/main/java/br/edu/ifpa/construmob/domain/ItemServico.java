package br.edu.ifpa.construmob.domain;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity @Table(name="item_servico")
public class ItemServico {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="pedido_id",nullable=false) private PedidoServico pedido;
 @ManyToOne(fetch=FetchType.EAGER,optional=false) @JoinColumn(name="servico_id",nullable=false) private Servico servico;
 @Column(nullable=false) private int quantidade;
 @Column(name="preco_unitario",nullable=false,precision=12,scale=2) private BigDecimal precoUnitario;
 protected ItemServico(){}
 public ItemServico(Servico servico,int quantidade){if(quantidade<=0)throw new IllegalArgumentException("A quantidade deve ser maior que zero.");this.servico=servico;this.quantidade=quantidade;this.precoUnitario=servico.getPreco();}
 void vincularAoPedido(PedidoServico pedido){this.pedido=pedido;}
 public BigDecimal calcularSubtotal(){return precoUnitario.multiply(BigDecimal.valueOf(quantidade));}
 public Long getId(){return id;} public Servico getServico(){return servico;} public int getQuantidade(){return quantidade;} public BigDecimal getPrecoUnitario(){return precoUnitario;}
}
