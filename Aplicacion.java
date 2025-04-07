public class Aplicacion {
    public static void main(String[] args) {
        JuegoAdivinaNumero juegoGeneral = new JuegoAdivinaNumero(3);  
        JuegoAdivinaPar juegoPar = new JuegoAdivinaPar(3);              
        JuegoAdivinaImpar juegoImpar = new JuegoAdivinaImpar(3);         
        
        System.out.println("Juego General");
        juegoGeneral.juega();

        System.out.println("\nJuego Adivina Par");
        juegoPar.juega();

        System.out.println("\nJuego Adivina Impar");
        juegoImpar.juega();
    }
}
