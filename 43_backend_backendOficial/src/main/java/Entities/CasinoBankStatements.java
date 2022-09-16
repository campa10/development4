package Entities;

import javax.persistence.*;
import java.security.Timestamp;


@Entity
@Table(name = "casino_bank_statements")
public class CasinoBankStatements {
    private Integer casinobankstatementsid;
    private String invoice;
    private Timestamp date;
    private String card;
    private String auth;
    private String txtype;
    private String bin;
    private String terminal_id;
    private String costumerip;
    private String costumeremail;
    private String ticket;
    private String txdescription;
    private Float exchangerate;
    private Float fee;


    @Id
    @Column(name = "casinobankstatementsid", unique = true, nullable = false, precision = 5, scale = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getCasinobankstatementsid() {
        return casinobankstatementsid;
    }

    public void setCasinobankstatementsid(Integer casinobankstatementsid) {
        this.casinobankstatementsid = casinobankstatementsid;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }


    /*public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }*/

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getTxtype() {
        return txtype;
    }

    public void setTxtype(String txtype) {
        this.txtype = txtype;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getTerminal_id() {
        return terminal_id;
    }

    public void setTerminal_id(String terminal_id) {
        this.terminal_id = terminal_id;
    }

    public String getCostumerip() {
        return costumerip;
    }

    public void setCostumerip(String costumerip) {
        this.costumerip = costumerip;
    }

    public String getCostumeremail() {
        return costumeremail;
    }

    public void setCostumeremail(String costumeremail) {
        this.costumeremail = costumeremail;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getTxdescription() {
        return txdescription;
    }

    public void setTxdescription(String txdescription) {
        this.txdescription = txdescription;
    }

    public Float getExchangerate() {
        return exchangerate;
    }

    public void setExchangerate(Float exchangerate) {
        this.exchangerate = exchangerate;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }
}
