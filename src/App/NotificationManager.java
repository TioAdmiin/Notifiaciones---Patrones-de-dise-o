package App;
public class NotificationManager {
    private static NotificationManager instance;

    private NotificationManager(){
        
    }
    
    public static NotificationManager GetInstance(){
        if (instance == null){
            instance = new NotificationManager();
        }
        return instance;
    }
}
