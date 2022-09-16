package Entities;

import javax.persistence.*;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "persona")
public class Persona {

    private int personaid;
    private int cedula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int telefono1;
    private int telefono2;
    private String email1;
    private String email2;
    private String pais;
    private String provinciaestado;


    //DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy'T'HH:mm:ss:SSS z");
    String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    String dateString = null;

    //parsing error
    /*public String getLocaltimes() {
        return localtimes.toString();
    }*/


    @Id
    //@Column(name = "USER_ID", unique = true, nullable = false, precision = 5, scale = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPersonaid() {
        return personaid;
    }

    public void setPersonaid(int personaid) {
        this.personaid = personaid;
    }

    //public Timestamp getUtctime() {        return utctime;    }

    //@Transient    public void setUtctime(Timestamp utctime) {        this.utctime = utctime;    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(int telefono1) {
        this.telefono1 = telefono1;
    }

    public int getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(int telefono2) {
        this.telefono2 = telefono2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvinciaestado() {
        return provinciaestado;
    }

    public void setProvinciaestado(String provinciaestado) {
        this.provinciaestado = provinciaestado;
    }
}
