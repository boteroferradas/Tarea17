import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal que gestiona la entrada de datos por teclado,
 * la creación y ejecución de los hilos, y la sincronización final.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> letras = new ArrayList<>();
        ArrayList<Consonante> consonantes = new ArrayList<>();
        ArrayList<Thread> hilos = new ArrayList<>();
        String texto;
        CharSequence vocales = "aeiou";


        Scanner teclado = new Scanner(System.in);

        // 1. Solicitar al usuario 5 consonantes por teclado
        for (int i = 1; i <= 5; i++){
            System.out.println("Introduce una consonante: ");
            String entrada = teclado.nextLine();
            if (!entrada.isBlank() && !entrada.contains(vocales)) {
                letras.add(entrada);
            }
        }

        // 2. Solicitar el texto base y multiplicarlo por 2000 para aumentar la carga de trabajo
        System.out.println("Introduce un texto a contar: ");
        texto = teclado.nextLine();
        texto = texto.repeat(2000);

        // Dividir el texto en un array de cadenas (caracter a caracter)
        String [] textoDiv = texto.split("");


        // 3. Crear un hilo independiente para cada consonante introducida
        for (String letra : letras) {
            Consonante consonante = new Consonante(letra, textoDiv);
            Thread hilo = new Thread(consonante);
            hilos.add(hilo);
            hilo.setName(letra);
        }

        // 4. Iniciar la ejecución de todos los hilos en paralelo
        for (Thread h : hilos){
            h.start();
        }

        // 5. Esperar a que todos los hilos terminen antes de mostrar el resultado global (evita race conditions en la salida)
        for (Thread h : hilos){
            try {
                h.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // 6. Mostrar el resultado acumulado total de todas las consonantes
        System.out.println("Contador global: " + ContadorConsonante.getSuma());

    }
}
