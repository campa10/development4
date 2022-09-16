package Entities;

import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "listacompratotals")
public class ListaCompraTotals {


    private int listacompratotalsid;
    private int loginid;

    private String uniquereference;
    private Float totalprecioventa;
    private Float totalservicioexpress;
    private Float totalimpuestos;
    private Float porcentageimpuestos;
    private Float grandtotal;


    @Id
    //@Column(name = "listacompraid", unique = true, nullable = false, precision = 5, scale = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getListacompratotalsid() {
        return listacompratotalsid;
    }

    public void setListacompratotalsid(int listacompratotalsid) {
        this.listacompratotalsid = listacompratotalsid;
    }

    public int getLoginid() {
        return loginid;
    }

    public void setLoginid(int loginid) {
        this.loginid = loginid;
    }

    public String getUniquereference() {
        return uniquereference;
    }

    public void setUniquereference(String uniquereference) {
        this.uniquereference = uniquereference;
    }

    public Float getTotalprecioventa() {
        return totalprecioventa;
    }

    public void setTotalprecioventa(Float totalprecioventa) {
        this.totalprecioventa = totalprecioventa;
    }

    public Float getTotalservicioexpress() {
        return totalservicioexpress;
    }

    public void setTotalservicioexpress(Float totalservicioexpress) {
        this.totalservicioexpress = totalservicioexpress;
    }

    public Float getTotalimpuestos() {
        return totalimpuestos;
    }

    public void setTotalimpuestos(Float totalimpuestos) {
        this.totalimpuestos = totalimpuestos;
    }

    public Float getPorcentageimpuestos() {
        return porcentageimpuestos;
    }

    public void setPorcentageimpuestos(Float porcentageimpuestos) {
        this.porcentageimpuestos = porcentageimpuestos;
    }

    public Float getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(Float grandtotal) {
        this.grandtotal = grandtotal;
    }
}
