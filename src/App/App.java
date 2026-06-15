package App;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Iniciando Sistema de Notificaciones ===");

        // 1. Obtener el Gestor Central (Singleton)
        NotificationManager manager = NotificationManager.GetInstance();

        // 2. Poblar la "Base de Datos" con usuarios reales
        System.out.println("[Sistema] Registrando usuarios en la aplicación...");
        User usuario1 = new User("Ana", "TOKEN_FCM_ANA_123");
        User usuario2 = new User("Luis", "TOKEN_FCM_LUIS_456");
        manager.getUserRepository().registrarUsuario(usuario1);
        manager.getUserRepository().registrarUsuario(usuario2);

        // 3. Armar la Arquitectura de Red (Observer)
        MessageReceiver receptorDeRed = new MessageReceiver();
        MessageObserver observador = new MessageObserver();
        
        // Conectamos al vigilante para que escuche la red
        receptorDeRed.registrarListener(observador);

        // 4. Simulación de ejecución real
        System.out.println("\n[Red] Simulando la llegada de mensajes desde internet...");

        // Caso A: Mensaje a un usuario válido (Ana)
        System.out.println("\n-> Entrando mensaje para ID 1:");
        receptorDeRed.MensajeRecibido(1, "¡Hola Ana, alerta de seguridad!");

        // Caso B: Mensaje a un usuario válido (Luis)
        System.out.println("\n-> Entrando mensaje para ID 2:");
        receptorDeRed.MensajeRecibido(2, "Luis, tienes un nuevo match.");

        // Caso C: Mensaje a un usuario que no existe (para probar el manejo de errores)
        System.out.println("\n-> Entrando mensaje para ID 99 (Inexistente):");
        receptorDeRed.MensajeRecibido(99, "Este mensaje debería fallar.");

        System.out.println("\n=== Fin de la ejecución ===");
    }
}