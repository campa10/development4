package com.sample;


public class Conocido {

  private long conocidoid;
  private long personaid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;
  private String nombre;
  private String apellido1;
  private long telef1;
  private long telef2;


  public long getConocidoid() {
    return conocidoid;
  }

  public void setConocidoid(long conocidoid) {
    this.conocidoid = conocidoid;
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


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  public String getApellido1() {
    return apellido1;
  }

  public void setApellido1(String apellido1) {
    this.apellido1 = apellido1;
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

}
