import java.util.Random;
import java.util.Scanner; 

public class JuegoAdivinaNumero extends Juego {
    protected int numeroAAdivinar;
    protected Random random;
    protected Scanner scanner;

    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas);
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }

    public boolean validaNumero(int numero) {
        return numero >= 0 && numero <= 10;
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

            if (!validaNumero(intento)) {
                System.out.println("Número fuera de rango. Inténtalo de nuevo.");
                continue; 
            }

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
    }
}
