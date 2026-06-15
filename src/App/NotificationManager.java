package App;
public class NotificationManager {
    private static NotificationManager instance;
    private Interfaces.INotifier adapter;
    private UserRepository userRepository;
    private int notificationCount;
    
    private NotificationManager() {
        adapter = new PushNotificationAdapter();
        userRepository = new UserRepository();
        this.notificationCount = 0;
    }

    public static NotificationManager GetInstance(){
        if (instance == null){
            instance = new NotificationManager();
        }
        return instance;
    }

    public void manage(int userId, String texto) {
        this.notificationCount++;
        
        User usuarioDestino = userRepository.buscarPorId(userId);
        
        if (usuarioDestino != null) {
            adapter.sendNotification(usuarioDestino, texto);
        } else {
            System.err.println("Error: El usuario " + userId + " no está registrado en la app.");
        }
    } 

    public int getNotificationCount()           {        return notificationCount;                  }
    public PushNotificationAdapter getAdapter() {        return (PushNotificationAdapter) adapter;  }
    public UserRepository getUserRepository()   {        return userRepository;                     }

    public void resetCount() {
        this.notificationCount = 0;
    }
}
