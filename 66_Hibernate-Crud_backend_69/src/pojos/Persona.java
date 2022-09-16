package com.sample;


public class Persona {

  private long personaid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;
  private String nombre;
  private String apellido1;
  private String apellido2;
  private long telef1;
  private long telef2;
  private String email1;
  private String email2;
  private String pais;
  private String nacionalidad;
  private String estadoProvincia;
  private String direccionExacta;
  private String cedula;


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


  public String getApellido2() {
    return apellido2;
  }

  public void setApellido2(String apellido2) {
    this.apellido2 = apellido2;
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


  public String getEmail1() {
    return email1;
  }

  public void setEmail1(String email1) {
    this.email1 = email1;
  }


  public String getEmail2() {
    return email2;
  }

  public void setEmail2(String email2) {
    this.email2 = email2;
  }


  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }


  public String getNacionalidad() {
    return nacionalidad;
  }

  public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
  }


  public String getEstadoProvincia() {
    return estadoProvincia;
  }

  public void setEstadoProvincia(String estadoProvincia) {
    this.estadoProvincia = estadoProvincia;
  }


  public String getDireccionExacta() {
    return direccionExacta;
  }

  public void setDireccionExacta(String direccionExacta) {
    this.direccionExacta = direccionExacta;
  }


  public String getCedula() {
    return cedula;
  }

  public void setCedula(String cedula) {
    this.cedula = cedula;
  }

}
