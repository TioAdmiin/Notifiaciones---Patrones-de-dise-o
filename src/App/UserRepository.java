package App;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    // La lista real de usuarios que son parte de la app
    private final List<User> listaUsuarios;

    public UserRepository() {
        this.listaUsuarios = new ArrayList<>();
    }

    // Método para registrar usuarios cuando instalan la app
    public void registrarUsuario(User nuevoUsuario) {
        listaUsuarios.add(nuevoUsuario);
    }

    // Método para buscar un usuario por su ID
    public User buscarPorId(int idBusqueda) {
        for (User u : listaUsuarios) {
            if (u.getId() == idBusqueda) {
                return u; // Usuario encontrado
            }
        }
        return null; // Usuario no existe
    }
}