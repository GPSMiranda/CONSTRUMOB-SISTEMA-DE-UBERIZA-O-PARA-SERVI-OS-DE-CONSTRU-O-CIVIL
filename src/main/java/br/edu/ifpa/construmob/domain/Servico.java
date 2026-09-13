package br.edu.ifpa.construmob.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
@Entity @Table(name="servico")
public class Servico {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long codigo;
 @NotBlank @Column(nullable=false,length=120) private String nome;
 @NotBlank @Column(nullable=false,length=80) private String categoria;
 @NotNull @DecimalMin("0.00") @Column(nullable=false,precision=12,scale=2) private BigDecimal preco;
 @Column(nullable=false) private boolean ativo=true;
 protected Servico(){}
 public Servico(String nome,String categoria,BigDecimal preco){this.nome=nome;this.categoria=categoria;this.preco=preco;}
 public Long getCodigo(){return codigo;} public String getNome(){return nome;} public String getCategoria(){return categoria;} public BigDecimal getPreco(){return preco;} public boolean isAtivo(){return ativo;}
 public void setNome(String nome){this.nome=nome;} public void setCategoria(String categoria){this.categoria=categoria;} public void setPreco(BigDecimal preco){this.preco=preco;} public void setAtivo(boolean ativo){this.ativo=ativo;}
}
