/**
 * Clase estática que actúa como recurso compartido seguro entre hilos,
 * previniendo condiciones de carrera.
 */
public class ContadorConsonante {
private static int suma;

    /**
     * Metodo sincronizado para sumar las repeticiones encontradas por cada hilo.
     * El modificador 'synchronized' asegura que solo un hilo pueda modificar 'suma' a la vez.
     *
     * @param repeticiones Número de veces que el hilo encontró su consonante.
     */
    public static synchronized void sumar(int repeticiones) throws InterruptedException {
        Thread.sleep(1);
        suma += repeticiones;
    }

    /**
     * Metodo sincronizado para obtener el valor total acumulado de forma segura.
     * @return El valor total de la suma global.
     */
    public static synchronized int getSuma() {
        return suma;
    }
}
