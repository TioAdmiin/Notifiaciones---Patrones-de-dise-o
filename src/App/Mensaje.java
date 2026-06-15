package App;
import java.util.*;

public class Mensaje {
    //Atributos
    private String id;
    private User remitente;
    private String mensaje;
    private Date fecha;

    //Constructor
    public Mensaje(String id, User remitente, String mensaje, Date fecha) {
        this.id = id;
        this.remitente = remitente;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    //Metodos
    public String getId() {
        return id;
    }
    public User getRemitente() {
        return remitente;
    }
    public String getMensaje() {
        return mensaje;
    }
    public Date getFecha() {
        return fecha;
    }
}
