package Entities;

import java.net.InetAddress;
import java.sql.Timestamp;
import java.util.UUID;

public class UserSession {

    private String loggedUser;
    private UUID sessionToken;
    private String loginTime;
    private InetAddress macAddress;
    private String externalIpAddress;

    public String getExternalIpAddress() {
        return externalIpAddress;
    }

    public void setExternalIpAddress(String externalIpAddress) {
        this.externalIpAddress = externalIpAddress;
    }

    public String getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(String loggedUser) {
        this.loggedUser = loggedUser;
    }

    public UUID getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(UUID sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public InetAddress getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(InetAddress macAddress) {
        this.macAddress = macAddress;
    }
}
