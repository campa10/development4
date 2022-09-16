package com.sample;


public class AsistenciaLegal {

  private long asistencialegalid;
  private long perfilsocialid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;
  private String descripcion;
  private String oficinaGobierno;
  private String encargadoOficina;
  private String presentoQueja;
  private String oficinaSiRespondio;
  private String oficinaRespuesta;


  public long getAsistencialegalid() {
    return asistencialegalid;
  }

  public void setAsistencialegalid(long asistencialegalid) {
    this.asistencialegalid = asistencialegalid;
  }


  public long getPerfilsocialid() {
    return perfilsocialid;
  }

  public void setPerfilsocialid(long perfilsocialid) {
    this.perfilsocialid = perfilsocialid;
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


  public String getOficinaGobierno() {
    return oficinaGobierno;
  }

  public void setOficinaGobierno(String oficinaGobierno) {
    this.oficinaGobierno = oficinaGobierno;
  }


  public String getEncargadoOficina() {
    return encargadoOficina;
  }

  public void setEncargadoOficina(String encargadoOficina) {
    this.encargadoOficina = encargadoOficina;
  }


  public String getPresentoQueja() {
    return presentoQueja;
  }

  public void setPresentoQueja(String presentoQueja) {
    this.presentoQueja = presentoQueja;
  }


  public String getOficinaSiRespondio() {
    return oficinaSiRespondio;
  }

  public void setOficinaSiRespondio(String oficinaSiRespondio) {
    this.oficinaSiRespondio = oficinaSiRespondio;
  }


  public String getOficinaRespuesta() {
    return oficinaRespuesta;
  }

  public void setOficinaRespuesta(String oficinaRespuesta) {
    this.oficinaRespuesta = oficinaRespuesta;
  }

}
