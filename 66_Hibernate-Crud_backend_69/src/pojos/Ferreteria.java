package com.sample;


public class Ferreteria {

  private long ferreteriaid;
  private long personaid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;
  private String nombre;
  private String marca;
  private String modelo;
  private String foto1;
  private String foto2;
  private String foto3;
  private String precio;


  public long getFerreteriaid() {
    return ferreteriaid;
  }

  public void setFerreteriaid(long ferreteriaid) {
    this.ferreteriaid = ferreteriaid;
  }


  public long getPersonaid() {
    return personaid;
  }

  public void setPersonaid(long personaid) {
    this.personaid = personaid;
  }


  public java.sql.Timestamp getLocalTime() {
    return localTime;
  }

  public void setLocalTime(java.sql.Timestamp localTime) {
    this.localTime = localTime;
  }


  public java.sql.Timestamp getUtcTime() {
    return utcTime;
  }

  public void setUtcTime(java.sql.Timestamp utcTime) {
    this.utcTime = utcTime;
  }


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }


  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }


  public String getFoto1() {
    return foto1;
  }

  public void setFoto1(String foto1) {
    this.foto1 = foto1;
  }


  public String getFoto2() {
    return foto2;
  }

  public void setFoto2(String foto2) {
    this.foto2 = foto2;
  }


  public String getFoto3() {
    return foto3;
  }

  public void setFoto3(String foto3) {
    this.foto3 = foto3;
  }


  public String getPrecio() {
    return precio;
  }

  public void setPrecio(String precio) {
    this.precio = precio;
  }

}
