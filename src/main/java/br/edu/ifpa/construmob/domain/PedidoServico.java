package br.edu.ifpa.construmob.domain;
import br.edu.ifpa.construmob.domain.enums.StatusPedido;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
@Entity @Table(name="pedido_servico")
public class PedidoServico {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long numero;
 @Column(nullable=false) private LocalDateTime data;
 @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private StatusPedido status;
 @ManyToOne(fetch=FetchType.EAGER,optional=false) @JoinColumn(name="cliente_id",nullable=false) private Cliente cliente;
 @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="profissional_id") private Profissional profissional;
 @Column(nullable=false,length=160) private String localidade;
 @Column(nullable=false,length=500) private String descricao;
 @OneToMany(mappedBy="pedido",cascade=CascadeType.ALL,orphanRemoval=true) private List<ItemServico> itens=new ArrayList<>();
 protected PedidoServico(){}
 public PedidoServico(Cliente cliente,String localidade,String descricao){this.data=LocalDateTime.now();this.status=StatusPedido.ABERTO;this.cliente=cliente;this.localidade=localidade;this.descricao=descricao;}
 public void adicionarItem(Servico servico,int quantidade){if(status==StatusPedido.CANCELADO||status==StatusPedido.FINALIZADO)throw new IllegalStateException("Não é possível alterar um pedido encerrado.");ItemServico item=new ItemServico(servico,quantidade);item.vincularAoPedido(this);itens.add(item);}
 public BigDecimal calcularTotal(){return itens.stream().map(ItemServico::calcularSubtotal).reduce(BigDecimal.ZERO,BigDecimal::add);}
 public void aceitar(Profissional profissional){if(status!=StatusPedido.ABERTO)throw new IllegalStateException("Somente pedidos abertos podem ser aceitos.");if(profissional==null||!profissional.isValidado())throw new IllegalStateException("O profissional precisa estar cadastrado e validado.");this.profissional=profissional;this.status=StatusPedido.ACEITO;}
 public void finalizar(){if(status!=StatusPedido.ACEITO)throw new IllegalStateException("O pedido deve estar aceito antes da finalização.");this.status=StatusPedido.FINALIZADO;}
 public void cancelar(){if(status==StatusPedido.FINALIZADO)throw new IllegalStateException("Pedido finalizado não pode ser cancelado.");this.status=StatusPedido.CANCELADO;}
 public Long getNumero(){return numero;} public LocalDateTime getData(){return data;} public StatusPedido getStatus(){return status;} public Cliente getCliente(){return cliente;} public Profissional getProfissional(){return profissional;} public String getLocalidade(){return localidade;} public String getDescricao(){return descricao;} public List<ItemServico> getItens(){return Collections.unmodifiableList(itens);}
}
