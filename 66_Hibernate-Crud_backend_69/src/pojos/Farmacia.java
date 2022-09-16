package com.sample;


public class Farmacia {

  private long farmaciaid;
  private long personaid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;
  private String nombre;
  private String marca;
  private String generico;
  private String requiereReceta;
  private String precio;
  private String entregaInmediata;


  public long getFarmaciaid() {
    return farmaciaid;
  }

  public void setFarmaciaid(long farmaciaid) {
    this.farmaciaid = farmaciaid;
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


  public String getGenerico() {
    return generico;
  }

  public void setGenerico(String generico) {
    this.generico = generico;
  }


  public String getRequiereReceta() {
    return requiereReceta;
  }

  public void setRequiereReceta(String requiereReceta) {
    this.requiereReceta = requiereReceta;
  }


  public String getPrecio() {
    return precio;
  }

  public void setPrecio(String precio) {
    this.precio = precio;
  }


  public String getEntregaInmediata() {
    return entregaInmediata;
  }

  public void setEntregaInmediata(String entregaInmediata) {
    this.entregaInmediata = entregaInmediata;
  }

}
