package com.sample;


public class OrdenDevolucion {

  private long ordendevolucionid;
  private long listacompratotalid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;


  public long getOrdendevolucionid() {
    return ordendevolucionid;
  }

  public void setOrdendevolucionid(long ordendevolucionid) {
    this.ordendevolucionid = ordendevolucionid;
  }


  public long getListacompratotalid() {
    return listacompratotalid;
  }

  public void setListacompratotalid(long listacompratotalid) {
    this.listacompratotalid = listacompratotalid;
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

}
