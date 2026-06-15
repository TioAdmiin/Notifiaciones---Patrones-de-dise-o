package Test;

import org.junit.*;

import App.NotificationManager;
import App.PushNotificationAdapter;
import App.User;

import static org.junit.Assert.assertEquals;

public class UnitTests {

    private NotificationManager manager;
    private PushNotificationAdapter adapter;

    @Before
    public void setUp() {
        manager = NotificationManager.GetInstance();
        manager.resetCount();
        adapter = manager.getAdapter(); 
    }

    @Test
    // Verificación de que solo haya una instancia de NotificationManager creada en todo el ciclo de vida de la aplicación.
    public void CompareNotificatinManager() {
        NotificationManager a = NotificationManager.GetInstance();
        NotificationManager b = NotificationManager.GetInstance();

        assertEquals(a, b);
    }
 
    @Test
    // Pruebas para asegurar que el PushNotificationAdapter traduzca correctamente las llamadas del NotificationManager a las API del servicio de notificaciones externo.
    public void AdapterTranslatesCallsCorrectly() {
        String message = "Alerta de sistema";
        String tokenEsperado = "TOKEN_API_EXTERNA_456";

        User usuarioPrueba = new User("Carlos", tokenEsperado);
        Integer idUser = usuarioPrueba.getId();

        manager.getUserRepository().registrarUsuario(usuarioPrueba);
        
        // Ejecución: El manager recibe un entero (ID) y el texto
        manager.manage(idUser, message);

        // Verificación: Comprobamos que la traducción ID -> Token fue exitosa
        // y que el Adapter tiene los datos correctos listos para el servicio externo
        assertEquals(tokenEsperado, adapter.getLastTokenUsed());
        assertEquals(message, adapter.getLastMessageProcessed());
    }

    @Test
    // Confirmación de que el MessageObserver notifique de manera efectiva al NotificationManager cuando lleguen nuevos mensajes en la aplicación.
    public void NotificationManagerNotified() {
        Integer idUser;
        String message = "Test Message";
        String tokenEsperado = "TOKEN_FCM_999";

        User usuarioPrueba = new User("Juan", tokenEsperado);
        idUser = usuarioPrueba.getId();

        manager.getUserRepository().registrarUsuario(usuarioPrueba);
        manager.manage(idUser, message);

        assertEquals(1, manager.getNotificationCount());
        assertEquals(tokenEsperado, adapter.getLastTokenUsed());
        assertEquals(message, adapter.getLastMessageProcessed());
    }
}