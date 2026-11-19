public class ConSincronizacion {
    private static int contador = 0;
    private static final int INCREMENTOS_POR_HILO = 1000;

    public static void main(String[] args) throws InterruptedException {
        Thread hilo1 = new Thread(ConSincronizacion::incrementarMilVeces, "Hilo-1");
        Thread hilo2 = new Thread(ConSincronizacion::incrementarMilVeces, "Hilo-2");

        hilo1.start();
        hilo2.start();
        hilo1.join();
        hilo2.join();

        System.out.println("=== CON synchronized ===");
        System.out.println("Resultado esperado: " + (2 * INCREMENTOS_POR_HILO));
        System.out.println("Resultado obtenido: " + contador);
    }

    private static void incrementarMilVeces() {
        for (int i = 0; i < INCREMENTOS_POR_HILO; i++) {
            incrementar();
        }
    }

    private static synchronized void incrementar() {
        int valor = contador;
        Thread.yield();
        contador = valor + 1;
    }
}
