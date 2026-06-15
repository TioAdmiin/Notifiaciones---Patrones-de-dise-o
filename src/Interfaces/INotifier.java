package Interfaces;
import App.User;

public interface INotifier {
    public void sendNotification(User usuario, String message);
}
