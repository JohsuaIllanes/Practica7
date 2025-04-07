package juego1;
import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinaNumero extends Juego {
    private int numeroAAdivinar;
    private Random random;
    private Scanner scanner;

    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas);
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }

    public void juega() {
        reiniciaPartida();
        numeroAAdivinar = random.nextInt(11); 
        System.out.println("Adivina un número entre 0 y 10:");

        while (true) {
            while (!scanner.hasNextInt()) { 
                System.out.println("Por favor, ingresa un número válido:");
                scanner.next(); 
            }
            int intento = scanner.nextInt();

            if (intento == numeroAAdivinar) {
                System.out.println("¡Acertaste!");
                actualizaRecord();
                break;
            } else {
                if (quitaVida()) {
                    System.out.println("Incorrecto. El número a adivinar es " + 
                    (intento < numeroAAdivinar ? "mayor" : "menor") + ". Inténtalo de nuevo:");
                } else {
                    System.out.println("Se acabaron tus vidas. El número era: " + numeroAAdivinar);
                    break;
                }
            }
        }
        scanner.close();
    }
}
