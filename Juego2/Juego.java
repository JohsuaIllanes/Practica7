public class Juego {
    protected int numeroDeVidas;
    protected int record;

    public Juego(int numeroDeVidas) {
        this.numeroDeVidas = numeroDeVidas;
        this.record = 0;
    }

    public void reiniciaPartida() {
        this.numeroDeVidas = 3;
    }

    public void actualizaRecord() {
        System.out.println("¡Nuevo récord!");
        this.record++;
    }

    public boolean quitaVida() {
        this.numeroDeVidas--;
        return this.numeroDeVidas > 0;
    }
}
