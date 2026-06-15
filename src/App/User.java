package App;

public class User {
    //Atributos
    private static int idCounter = 0;
    private int id;
    private String name;
    private String token;

    //Constructor
    public User(String name, String token) {    
        this.id = ++idCounter;
        this.name = name;
        this.token = token;
    }

    //Metodos
    public int getId()          {        return id;     }
    public String getName()     {        return name;    }
    public String getToken()    {        return token;    }
}
