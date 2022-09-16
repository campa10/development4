package Entities;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;


import javax.persistence.*;

@Entity

@Table(name="listacompratotals")
@NamedStoredProcedureQueries({ @NamedStoredProcedureQuery(name = "firstProcedure()", procedureName = "getTickets"),
        @NamedStoredProcedureQuery(name = "secondProcedure", procedureName = "temptabl", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "tcatagory", type = Integer.class) }) })
public class Ticket {
    @Id
    private int id;
    private int amount;
    private String catagory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }
}

