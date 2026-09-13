package br.edu.ifpa.construmob.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
@Entity @Table(name="cliente", uniqueConstraints=@UniqueConstraint(name="uk_cliente_email",columnNames="email"))
public class Cliente {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false,length=120) private String nome;
 @Email @NotBlank @Column(nullable=false,length=160) private String email;
 @NotBlank @Column(nullable=false,length=20) private String telefone;
 protected Cliente(){}
 public Cliente(String nome,String email,String telefone){this.nome=nome;this.email=email;this.telefone=telefone;}
 public Long getId(){return id;} public String getNome(){return nome;} public String getEmail(){return email;} public String getTelefone(){return telefone;}
 public void setNome(String nome){this.nome=nome;} public void setEmail(String email){this.email=email;} public void setTelefone(String telefone){this.telefone=telefone;}
}
