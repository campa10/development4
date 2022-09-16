package Entities;


import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "producto")
public class Producto {

    private String productoid;
    private Timestamp localtimes;
    private Timestamp utctime;
    private String vendorname;
    private boolean activo;
    private String productname;
    private String productsize;
    private String material;
    private String color;
    private String sabor;
    private String estilo;
    private String brand;
    private float costo;
    private float porcentage;
    private float precioventa;
    private String vendorphone;
    private String pict1;
    private String pict2;
    private String pict3;
    private String pict4;
    private String pict5;
    private String pict6;
    private String pict7;
    private String pict8;
    private String vendoremail;

    @Id
    //@Column(name = "USER_ID", unique = true, nullable = false, precision = 5, scale = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getProductoid() {
        return productoid;
    }

    public void setProductoid(String productoid) {
        this.productoid = productoid;
    }

    public Timestamp getLocaltimes() {
        return localtimes;
    }

    //public void setLocaltimes(Timestamp localtimes) {        this.localtimes = localtimes;    }
    @Transient
    public void setLocaltimes(Timestamp localtimes) {
        this.localtimes = localtimes;
    }

    public Timestamp getUtctime() {
        return utctime;
    }

    public void setUtctime(Timestamp utctime) {
        this.utctime = utctime;
    }

    public String getVendorname() {
        return vendorname;
    }

    public void setVendorname(String vendorname) {
        this.vendorname = vendorname;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductsize() {
        return productsize;
    }

    public void setProductsize(String productsize) {
        this.productsize = productsize;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getPorcentage() {
        return porcentage;
    }

    public void setPorcentage(float porcentage) {
        this.porcentage = porcentage;
    }

    public float getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(float precioventa) {
        this.precioventa = precioventa;
    }

    public String getVendorphone() {
        return vendorphone;
    }

    public void setVendorphone(String vendorphone) {
        this.vendorphone = vendorphone;
    }

    public String getPict1() {
        return pict1;
    }

    public void setPict1(String pict1) {
        this.pict1 = pict1;
    }

    public String getPict2() {
        return pict2;
    }

    public void setPict2(String pict2) {
        this.pict2 = pict2;
    }

    public String getPict3() {
        return pict3;
    }

    public void setPict3(String pict3) {
        this.pict3 = pict3;
    }

    public String getPict4() {
        return pict4;
    }

    public void setPict4(String pict4) {
        this.pict4 = pict4;
    }

    public String getPict5() {
        return pict5;
    }

    public void setPict5(String pict5) {
        this.pict5 = pict5;
    }

    public String getPict6() {
        return pict6;
    }

    public void setPict6(String pict6) {
        this.pict6 = pict6;
    }

    public String getPict7() {
        return pict7;
    }

    public void setPict7(String pict7) {
        this.pict7 = pict7;
    }

    public String getPict8() {
        return pict8;
    }

    public void setPict8(String pict8) {
        this.pict8 = pict8;
    }

    public String getVendoremail() {
        return vendoremail;
    }

    public void setVendoremail(String vendoremail) {
        this.vendoremail = vendoremail;
    }
}
