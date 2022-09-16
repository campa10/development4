package com.sample;


public class Supermercado {

  private long supermercadoid;
  private long personaid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;
  private String nombre;
  private String marca;
  private String tamano;
  private String foto1;
  private String foto2;
  private String precio;
  private long cantidadUnidadesEmpaque;
  private String entregaInmediata;


  public long getSupermercadoid() {
    return supermercadoid;
  }

  public void setSupermercadoid(long supermercadoid) {
    this.supermercadoid = supermercadoid;
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


  public String getTamano() {
    return tamano;
  }

  public void setTamano(String tamano) {
    this.tamano = tamano;
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


  public String getPrecio() {
    return precio;
  }

  public void setPrecio(String precio) {
    this.precio = precio;
  }


  public long getCantidadUnidadesEmpaque() {
    return cantidadUnidadesEmpaque;
  }

  public void setCantidadUnidadesEmpaque(long cantidadUnidadesEmpaque) {
    this.cantidadUnidadesEmpaque = cantidadUnidadesEmpaque;
  }


  public String getEntregaInmediata() {
    return entregaInmediata;
  }

  public void setEntregaInmediata(String entregaInmediata) {
    this.entregaInmediata = entregaInmediata;
  }

}
