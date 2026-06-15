package App;

public class PushNotificationAdapter implements Interfaces.INotifier {
    private String lastToken;
    private String lastMessage;

    public PushNotificationAdapter() {
        this.lastToken = "";
        this.lastMessage = "";
    }

    @Override
    public void sendNotification(User usuario, String message) {
        this.lastToken = usuario.getToken();
        this.lastMessage = message;
    }

    public String getLastTokenUsed() {
        return lastToken;
    }
    public String getLastMessageProcessed() {
        return lastMessage;
    }
}
