package com.sample;


public class VisitsLog {

  private long visitslogid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;
  private String ipAddress;
  private String zona;
  private String pais;


  public long getVisitslogid() {
    return visitslogid;
  }

  public void setVisitslogid(long visitslogid) {
    this.visitslogid = visitslogid;
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


  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }


  public String getZona() {
    return zona;
  }

  public void setZona(String zona) {
    this.zona = zona;
  }


  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

}
