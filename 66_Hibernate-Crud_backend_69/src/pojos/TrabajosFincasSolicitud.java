package com.sample;


public class TrabajosFincasSolicitud {

  private long trabajosfincassolicitudid;
  private long personaid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;
  private String descripcion;
  private String lugar;
  private long totalPersonas;
  private String costo;


  public long getTrabajosfincassolicitudid() {
    return trabajosfincassolicitudid;
  }

  public void setTrabajosfincassolicitudid(long trabajosfincassolicitudid) {
    this.trabajosfincassolicitudid = trabajosfincassolicitudid;
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


  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }


  public String getLugar() {
    return lugar;
  }

  public void setLugar(String lugar) {
    this.lugar = lugar;
  }


  public long getTotalPersonas() {
    return totalPersonas;
  }

  public void setTotalPersonas(long totalPersonas) {
    this.totalPersonas = totalPersonas;
  }


  public String getCosto() {
    return costo;
  }

  public void setCosto(String costo) {
    this.costo = costo;
  }

}
