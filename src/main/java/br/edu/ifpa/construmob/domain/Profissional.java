package br.edu.ifpa.construmob.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
@Entity @Table(name="profissional",uniqueConstraints=@UniqueConstraint(name="uk_profissional_email",columnNames="email"))
public class Profissional {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false,length=120) private String nome;
 @Email @NotBlank @Column(nullable=false,length=160) private String email;
 @NotBlank @Column(nullable=false,length=20) private String telefone;
 @NotBlank @Column(nullable=false,length=100) private String especialidade;
 @Column(nullable=false) private boolean validado;
 protected Profissional(){}
 public Profissional(String nome,String email,String telefone,String especialidade){this.nome=nome;this.email=email;this.telefone=telefone;this.especialidade=especialidade;this.validado=false;}
 public Long getId(){return id;} public String getNome(){return nome;} public String getEmail(){return email;} public String getTelefone(){return telefone;} public String getEspecialidade(){return especialidade;} public boolean isValidado(){return validado;}
 public void setNome(String nome){this.nome=nome;} public void setEmail(String email){this.email=email;} public void setTelefone(String telefone){this.telefone=telefone;} public void setEspecialidade(String especialidade){this.especialidade=especialidade;} public void validarCadastro(){this.validado=true;}
}
