import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> letras = new ArrayList<>();
        ArrayList<Consonante> consonantes = new ArrayList<>();
        ArrayList<Thread> hilos = new ArrayList<>();
        String texto;


        Scanner teclado = new Scanner(System.in);

        for (int i = 1; i <= 5; i++){
            System.out.println("Introduce una consonante: ");
            String entrada = teclado.nextLine();
            if (!entrada.isBlank()) {
                letras.add(entrada);
            }
        }

        System.out.println("Introduce un texto a contar: ");
        texto = teclado.nextLine();
        String [] textoDiv = texto.split("");



        for (String letra : letras) {
            Consonante consonante = new Consonante(letra, textoDiv);
            Thread hilo = new Thread(consonante);
            hilo.setName(letra);
        }



    }
}
