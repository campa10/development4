package com.sample;


public class Opiniones {

  private long opinionesid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;
  private String modulo;
  private String tema;
  private String comentatio;
  private String votoPositivo;
  private String votoNegativo;


  public long getOpinionesid() {
    return opinionesid;
  }

  public void setOpinionesid(long opinionesid) {
    this.opinionesid = opinionesid;
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


  public String getModulo() {
    return modulo;
  }

  public void setModulo(String modulo) {
    this.modulo = modulo;
  }


  public String getTema() {
    return tema;
  }

  public void setTema(String tema) {
    this.tema = tema;
  }


  public String getComentatio() {
    return comentatio;
  }

  public void setComentatio(String comentatio) {
    this.comentatio = comentatio;
  }


  public String getVotoPositivo() {
    return votoPositivo;
  }

  public void setVotoPositivo(String votoPositivo) {
    this.votoPositivo = votoPositivo;
  }


  public String getVotoNegativo() {
    return votoNegativo;
  }

  public void setVotoNegativo(String votoNegativo) {
    this.votoNegativo = votoNegativo;
  }

}
