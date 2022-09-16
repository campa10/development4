package Entities;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {

    private String userName;
    private String password;
    private Long loginId;
    //private Long verificationCode;


    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public Long getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(Long verificationCode) {
        this.verificationCode = verificationCode;
    }*/
}
