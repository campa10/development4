package com.sample;


public class OrdenCompra {

  private long ordencompraid;
  private long listacompratotalid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;
  private String trackingGui;
  private String total;
  private String entregaInmediata;
  private String pais;
  private String estadoProvincia;
  private long distanciaKms;


  public long getOrdencompraid() {
    return ordencompraid;
  }

  public void setOrdencompraid(long ordencompraid) {
    this.ordencompraid = ordencompraid;
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


  public String getTrackingGui() {
    return trackingGui;
  }

  public void setTrackingGui(String trackingGui) {
    this.trackingGui = trackingGui;
  }


  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }


  public String getEntregaInmediata() {
    return entregaInmediata;
  }

  public void setEntregaInmediata(String entregaInmediata) {
    this.entregaInmediata = entregaInmediata;
  }


  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }


  public String getEstadoProvincia() {
    return estadoProvincia;
  }

  public void setEstadoProvincia(String estadoProvincia) {
    this.estadoProvincia = estadoProvincia;
  }


  public long getDistanciaKms() {
    return distanciaKms;
  }

  public void setDistanciaKms(long distanciaKms) {
    this.distanciaKms = distanciaKms;
  }

}
