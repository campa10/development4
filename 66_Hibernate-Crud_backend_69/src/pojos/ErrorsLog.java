package com.sample;


public class ErrorsLog {

  private long errorslogid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;
  private String descripcion;
  private String modulo;


  public long getErrorslogid() {
    return errorslogid;
  }

  public void setErrorslogid(long errorslogid) {
    this.errorslogid = errorslogid;
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


  public String getModulo() {
    return modulo;
  }

  public void setModulo(String modulo) {
    this.modulo = modulo;
  }

}
