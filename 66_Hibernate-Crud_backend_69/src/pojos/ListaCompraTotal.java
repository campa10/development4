package com.sample;


public class ListaCompraTotal {

  private long listacompratotalid;
  private long listacompraid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;
  private String total;
  private String impuestos;
  private String granTotal;


  public long getListacompratotalid() {
    return listacompratotalid;
  }

  public void setListacompratotalid(long listacompratotalid) {
    this.listacompratotalid = listacompratotalid;
  }


  public long getListacompraid() {
    return listacompraid;
  }

  public void setListacompraid(long listacompraid) {
    this.listacompraid = listacompraid;
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


  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }


  public String getImpuestos() {
    return impuestos;
  }

  public void setImpuestos(String impuestos) {
    this.impuestos = impuestos;
  }


  public String getGranTotal() {
    return granTotal;
  }

  public void setGranTotal(String granTotal) {
    this.granTotal = granTotal;
  }

}
