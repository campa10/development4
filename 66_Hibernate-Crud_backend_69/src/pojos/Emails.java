package com.sample;


public class Emails {

  private long emailsid;
  private java.sql.Timestamp localTime;
  private java.sql.Timestamp utcTime;
  private String name;
  private String value;


  public long getEmailsid() {
    return emailsid;
  }

  public void setEmailsid(long emailsid) {
    this.emailsid = emailsid;
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


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}
