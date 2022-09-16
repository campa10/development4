package Entities;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "listacompra")
public class ListaCompra {


    private int listacompraid;
    private int loginid;
    private Timestamp localtimes;
    private Timestamp utctime;
    private String uniquereference;
    private int productoid;
    private String productoname;
    private float precioventa;
    private String vendedor;



    @Id
    //@Column(name = "listacompraid", unique = true, nullable = false, precision = 5, scale = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getListacompraid() {
        return listacompraid;
    }

    public void setListacompraid(int listacompraid) {
        this.listacompraid = listacompraid;
    }

    public int getLoginid() {
        return loginid;
    }

    public void setLoginid(int loginid) {
        this.loginid = loginid;
    }

    public Timestamp getLocaltimes() {
        return localtimes;
    }

    public void setLocaltimes(Timestamp localtimes) {
        this.localtimes = localtimes;
    }

    public Timestamp getUtctime() {
        return utctime;
    }

    public void setUtctime(Timestamp utctime) {
        this.utctime = utctime;
    }

    public String getUniquereference() {
        return uniquereference;
    }

    public void setUniquereference(String uniquereference) {
        this.uniquereference = uniquereference;
    }

    public int getProductoid() {
        return productoid;
    }

    public void setProductoid(int productoid) {
        this.productoid = productoid;
    }

    public String getProductoname() {
        return productoname;
    }

    public void setProductoname(String productoname) {
        this.productoname = productoname;
    }

    public float getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(float precioventa) {
        this.precioventa = precioventa;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
}
