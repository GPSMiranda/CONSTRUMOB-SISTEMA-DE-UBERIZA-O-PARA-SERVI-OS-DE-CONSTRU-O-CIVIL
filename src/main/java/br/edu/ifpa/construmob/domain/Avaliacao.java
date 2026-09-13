package br.edu.ifpa.construmob.domain;
import br.edu.ifpa.construmob.domain.enums.StatusPedido;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="avaliacao",uniqueConstraints=@UniqueConstraint(name="uk_avaliacao_pedido",columnNames="pedido_id"))
public class Avaliacao {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @OneToOne(fetch=FetchType.EAGER,optional=false) @JoinColumn(name="pedido_id",nullable=false) private PedidoServico pedido;
 @Column(nullable=false) private int nota; @Column(length=500) private String comentario; @Column(nullable=false) private LocalDateTime data;
 protected Avaliacao(){}
 public Avaliacao(PedidoServico pedido,int nota,String comentario){if(pedido==null||pedido.getStatus()!=StatusPedido.FINALIZADO)throw new IllegalStateException("Somente serviços finalizados podem ser avaliados.");if(nota<1||nota>5)throw new IllegalArgumentException("A nota deve estar entre 1 e 5.");this.pedido=pedido;this.nota=nota;this.comentario=comentario;this.data=LocalDateTime.now();}
 public Long getId(){return id;} public PedidoServico getPedido(){return pedido;} public int getNota(){return nota;} public String getComentario(){return comentario;} public LocalDateTime getData(){return data;}
}
