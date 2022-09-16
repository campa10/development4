package com.sample;


public class CatalogoCamiones {

  private long catalogocamionesid;
  private long personaid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;
  private String duenoChofer;
  private long telef1;
  private long telef2;
  private long tamano;


  public long getCatalogocamionesid() {
    return catalogocamionesid;
  }

  public void setCatalogocamionesid(long catalogocamionesid) {
    this.catalogocamionesid = catalogocamionesid;
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


  public String getDuenoChofer() {
    return duenoChofer;
  }

  public void setDuenoChofer(String duenoChofer) {
    this.duenoChofer = duenoChofer;
  }


  public long getTelef1() {
    return telef1;
  }

  public void setTelef1(long telef1) {
    this.telef1 = telef1;
  }


  public long getTelef2() {
    return telef2;
  }

  public void setTelef2(long telef2) {
    this.telef2 = telef2;
  }


  public long getTamano() {
    return tamano;
  }

  public void setTamano(long tamano) {
    this.tamano = tamano;
  }

}
