package com.sample;


public class AnimalesOnline {

  private long animalesonlineid;
  private long personaid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;
  private String tipoAnimal;
  private long edadAnos;
  private String raza;
  private String puro;
  private String precio;
  private String ubicadoEn;


  public long getAnimalesonlineid() {
    return animalesonlineid;
  }

  public void setAnimalesonlineid(long animalesonlineid) {
    this.animalesonlineid = animalesonlineid;
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


  public String getTipoAnimal() {
    return tipoAnimal;
  }

  public void setTipoAnimal(String tipoAnimal) {
    this.tipoAnimal = tipoAnimal;
  }


  public long getEdadAnos() {
    return edadAnos;
  }

  public void setEdadAnos(long edadAnos) {
    this.edadAnos = edadAnos;
  }


  public String getRaza() {
    return raza;
  }

  public void setRaza(String raza) {
    this.raza = raza;
  }


  public String getPuro() {
    return puro;
  }

  public void setPuro(String puro) {
    this.puro = puro;
  }


  public String getPrecio() {
    return precio;
  }

  public void setPrecio(String precio) {
    this.precio = precio;
  }


  public String getUbicadoEn() {
    return ubicadoEn;
  }

  public void setUbicadoEn(String ubicadoEn) {
    this.ubicadoEn = ubicadoEn;
  }

}
