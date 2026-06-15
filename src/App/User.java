package App;

public class User {
    //Atributos
    private String name;
    private String token;

    //Constructor
    public User(String name, String token) {
        this.name = name;
        this.token = token;
    }

    //Metodos
    public String getName() {
        return name;
    }
    public String getToken() {
        return token;
    }
}
