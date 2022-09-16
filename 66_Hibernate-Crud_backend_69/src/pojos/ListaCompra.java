package com.sample;


public class ListaCompra {

  private long listacompraid;
  private long personaid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;
  private long itemid;
  private String trackingGui;
  private String tabla;
  private String name;
  private long cantidad;
  private String precio;
  private long cantidadDiasCreada;
  private String entregaInmediata;


  public long getListacompraid() {
    return listacompraid;
  }

  public void setListacompraid(long listacompraid) {
    this.listacompraid = listacompraid;
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


  public long getItemid() {
    return itemid;
  }

  public void setItemid(long itemid) {
    this.itemid = itemid;
  }


  public String getTrackingGui() {
    return trackingGui;
  }

  public void setTrackingGui(String trackingGui) {
    this.trackingGui = trackingGui;
  }


  public String getTabla() {
    return tabla;
  }

  public void setTabla(String tabla) {
    this.tabla = tabla;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getCantidad() {
    return cantidad;
  }

  public void setCantidad(long cantidad) {
    this.cantidad = cantidad;
  }


  public String getPrecio() {
    return precio;
  }

  public void setPrecio(String precio) {
    this.precio = precio;
  }


  public long getCantidadDiasCreada() {
    return cantidadDiasCreada;
  }

  public void setCantidadDiasCreada(long cantidadDiasCreada) {
    this.cantidadDiasCreada = cantidadDiasCreada;
  }


  public String getEntregaInmediata() {
    return entregaInmediata;
  }

  public void setEntregaInmediata(String entregaInmediata) {
    this.entregaInmediata = entregaInmediata;
  }

}
