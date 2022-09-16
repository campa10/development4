package com.sample;


public class AsistenciaLegalCasoPrincipal {

  private long asistencialegalcasoprincipalid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;
  private String titulo;
  private String listaCasos;
  private String descripcion;


  public long getAsistencialegalcasoprincipalid() {
    return asistencialegalcasoprincipalid;
  }

  public void setAsistencialegalcasoprincipalid(long asistencialegalcasoprincipalid) {
    this.asistencialegalcasoprincipalid = asistencialegalcasoprincipalid;
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


  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }


  public String getListaCasos() {
    return listaCasos;
  }

  public void setListaCasos(String listaCasos) {
    this.listaCasos = listaCasos;
  }


  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

}
