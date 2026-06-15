package App;

import java.util.*;

public class MessageReceiver {  
    private List<Interfaces.IMessageListener> listeners;

    public MessageReceiver() {
        listeners = new ArrayList<>();
    }

    public void registrarListener(Interfaces.IMessageListener listener) {
        listeners.add(listener);
    }

    public void MensajeRecibido(int userId, String message) {
        for (Interfaces.IMessageListener listener : listeners) {
            listener.onMessageReceived(userId, message);
        }
    }
}
