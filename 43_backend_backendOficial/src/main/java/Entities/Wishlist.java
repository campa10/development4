package Entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Wishlist")
public class Wishlist {

    private long wishlistid;
    private long personaid;
    private String category;
    private long productoid;
    private String productname;
    private Float precioventa;
    private int totalunits;


    @Id
    //@Column(name = "USER_ID", unique = true, nullable = false, precision = 5, scale = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public long getWishlistid() {
        return wishlistid;
    }

    public void setWishlistid(long wishlistid) {
        this.wishlistid = wishlistid;
    }

    public long getPersonaid() {
        return personaid;
    }

    public void setPersonaid(long personaid) {
        this.personaid = personaid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getProductoid() {
        return productoid;
    }

    public void setProductoid(long productoid) {
        this.productoid = productoid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Float getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(Float precioventa) {
        this.precioventa = precioventa;
    }

    public int getTotalunits() {
        return totalunits;
    }

    public void setTotalunits(int totalunits) {
        this.totalunits = totalunits;
    }
}
