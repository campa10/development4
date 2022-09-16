package Entities;


import org.hibernate.annotations.Type;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "todo")
public class Todo {

  private long todoid;
  private long personaid;
  private String foto1;
  private Boolean activo;
  private String titulo;

  @Id
  //@Column(name = "USER_ID", unique = true, nullable = false, precision = 5, scale = 0)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public long getTodoid() {
    return todoid;
  }

  public void setTodoid(long todoid) {
    this.todoid = todoid;
  }

  public long getPersonaid() {
    return personaid;
  }

  public void setPersonaid(long personaid) {
    this.personaid = personaid;
  }

  public String getFoto1() {
    return foto1;
  }

  public void setFoto1(String foto1) {
    this.foto1 = foto1;
  }

  public Boolean getActivo() {
    return activo;
  }

  public void setActivo(Boolean activo) {
    this.activo = activo;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }



}
