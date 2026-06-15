package App;

public class MessageObserver implements Interfaces.IMessageListener {
    private NotificationManager manager;

    //Constructor
    public MessageObserver() {
        manager = NotificationManager.GetInstance();
    }

    @Override
    public void onMessageReceived(int userId, String message) {
        manager.manage(userId, message);
    }
}
