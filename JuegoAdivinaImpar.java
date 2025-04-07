import java.util.Random;
import java.util.Scanner; 

public class JuegoAdivinaImpar extends JuegoAdivinaNumero {

    public JuegoAdivinaImpar(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    @Override
    public boolean validaNumero(int numero) {
        if (numero >= 0 && numero <= 10 && numero % 2 != 0) { 
            return true;  
        } else {
            if (numero % 2 == 0) {
                System.out.println("Error: Solo se permiten números impares entre 0 y 10.");
            } else {
                System.out.println("Número fuera de rango. Inténtalo de nuevo.");
            }
            return false;  
        }
    }

    @Override
    public void juega() {
        reiniciaPartida();
        numeroAAdivinar = generarNumeroImpar();
        System.out.println("Adivina un número impar entre 0 y 10:");

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
    }

    private int generarNumeroImpar() {
        Random rand = new Random();
        return rand.nextInt(5) * 2 + 1;
    }
}
