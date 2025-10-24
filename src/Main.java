import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //crea la entrada para los datos del usuario
        Scanner Teclado = new Scanner(System.in);

        System.out.println("Participa del Juego de la Adivinación 🔮");

        // Crea el número aleatorio (de 1 a 10)
        int numeroAleatorio = new Random().nextInt(10) + 1;

        // Inicializa variables de control
        int maxIntentos = 5; // inicializa en la cant max de intentos
        int intentos = 1;
        int numeroJugador; // numero que ingresa el jugador

        System.out.println("\n ¡Tienes " + maxIntentos + " intentos para adivinar un número entre 1 y 10! ");

        // El bucle se ejecuta mientras los intentos sean menores o iguales a maxIntentos
        while (intentos <= maxIntentos) {

            System.out.print("Intento #" + intentos + ": Ingresa tu número: ");


            // asumimos que siempre ingresará un número:
            numeroJugador = Teclado.nextInt();

            // 1. si ACERTO
            if (numeroAleatorio == numeroJugador) {
                System.out.println("\n🎉 ¡SOS UN CRACK DE LA ADIVINACIÓN! El número era: " + numeroAleatorio);
                //  Detiene el bucle  al acertar
                break;

                // 2. si FALLO
            } else {
                //calcula los intentos que restan y los guarda en variable
                int restanIntentos = maxIntentos - intentos;

                // 2 usuario le da unas pistas
                if (numeroJugador < numeroAleatorio) {
                    System.out.println(" Fallaste. ¡El número secreto es MÁS ALTO! ⬆️");
                } else {
                    System.out.println(" Fallaste. ¡El número secreto es MÁS BAJO! ⬇️");
                }

                //  Mensaje de intentos restantes
                if (restanIntentos > 0) {
                    System.out.println("Te quedan " + restanIntentos + " intentos más.");
                }

                intentos++; // Incrementa el contador de intento
            }
        } // Fin del while

        // 3. Mensaje de DERROTA (Solo si el bucle terminó por falta de intentos)
        if (intentos > maxIntentos) {
            System.out.println("\n💔 ¡FIN DEL JUEGO! Se te acabaron los " + maxIntentos + " intentos.");
            System.out.println("El número secreto era: " + numeroAleatorio);
        }

        Teclado.close(); // Buena práctica
    }
}