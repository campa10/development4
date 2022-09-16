package com.sample;


public class Login {

  private long loginid;
  private long personaid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;
  private String usuario;
  private String clave;
  private String jwtToken;
  private String tokenChange;
  private String email1;
  private String preguntaClave;
  private String nombreMostrar;
  private String email2;


  public long getLoginid() {
    return loginid;
  }

  public void setLoginid(long loginid) {
    this.loginid = loginid;
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


  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }


  public String getClave() {
    return clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }


  public String getJwtToken() {
    return jwtToken;
  }

  public void setJwtToken(String jwtToken) {
    this.jwtToken = jwtToken;
  }


  public String getTokenChange() {
    return tokenChange;
  }

  public void setTokenChange(String tokenChange) {
    this.tokenChange = tokenChange;
  }


  public String getEmail1() {
    return email1;
  }

  public void setEmail1(String email1) {
    this.email1 = email1;
  }


  public String getPreguntaClave() {
    return preguntaClave;
  }

  public void setPreguntaClave(String preguntaClave) {
    this.preguntaClave = preguntaClave;
  }


  public String getNombreMostrar() {
    return nombreMostrar;
  }

  public void setNombreMostrar(String nombreMostrar) {
    this.nombreMostrar = nombreMostrar;
  }


  public String getEmail2() {
    return email2;
  }

  public void setEmail2(String email2) {
    this.email2 = email2;
  }

}
