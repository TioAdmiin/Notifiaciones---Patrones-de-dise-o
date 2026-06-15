package App;
import java.util.ArrayList;
import java.util.List;

public class MessageObserver {
    List<Object> listeners = new ArrayList<>()  ;

    public void addListener(Object listener)
    {
        listeners.add(listener);
    }
}
