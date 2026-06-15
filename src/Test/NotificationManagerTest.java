package Test;

import org.junit.*;

import App.NotificationManager;

import static org.junit.Assert.assertEquals;

public class NotificationManagerTest{

    @Test
    public void CompareNotificatinManager(){
        NotificationManager a = NotificationManager.GetInstance();
        NotificationManager b = NotificationManager.GetInstance();
        assertEquals(a, b);
    }
}