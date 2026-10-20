/**
 * Clase que implementa Runnable para que cada consonante sea procesada
 * de forma concurrente en un hilo independiente.
 */
public class Consonante implements Runnable{
private String[] texto;
private String letra;

    /**
     * Constructor de la tarea del hilo.
     * @param letra La consonante que este hilo debe buscar.
     * @param texto El array de texto dividido donde se realizará la búsqueda.
     */
    public Consonante(String letra, String[] texto){
        this.letra = letra;
        this.texto = texto;
    }

    @Override
    public void run() {
        int contador = 0;

        try {
        // Recorrer el texto buscando las coincidencias con la letra asignada
        for (String c : texto){
            if (c.equalsIgnoreCase(letra)) {
                contador++;
            }
        }
        // Sumar el resultado local al contador global compartido de forma segura
        ContadorConsonante.sumar(contador);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Consonante " + letra + ": " + contador + " veces");
    }
}

