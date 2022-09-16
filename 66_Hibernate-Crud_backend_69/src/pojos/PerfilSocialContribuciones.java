package com.sample;


public class PerfilSocialContribuciones {

  private long perfilsocialcontribucionesid;
  private long perfilsocialid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;
  private long reciboBancoDeposito;
  private String monto;


  public long getPerfilsocialcontribucionesid() {
    return perfilsocialcontribucionesid;
  }

  public void setPerfilsocialcontribucionesid(long perfilsocialcontribucionesid) {
    this.perfilsocialcontribucionesid = perfilsocialcontribucionesid;
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


  public long getReciboBancoDeposito() {
    return reciboBancoDeposito;
  }

  public void setReciboBancoDeposito(long reciboBancoDeposito) {
    this.reciboBancoDeposito = reciboBancoDeposito;
  }


  public String getMonto() {
    return monto;
  }

  public void setMonto(String monto) {
    this.monto = monto;
  }

}
