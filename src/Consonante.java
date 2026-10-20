public class Consonante implements Runnable{
private String[] texto;
private String letra;

    public Consonante(String letra, String[] texto){
        this.letra = letra;
        this.texto = texto;
    }

    @Override
    public void run() {
        int contador = 0;
        for (String c : texto){
            if (c.equalsIgnoreCase(letra)) {
                contador++;
            }
        }
        System.out.println("Consonante " + letra + ": " + contador + "veces");
    }
}

