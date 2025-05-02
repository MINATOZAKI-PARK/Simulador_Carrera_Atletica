import javax.swing.*;

public class ThreadRunner implements Runnable {
    //Atributos del hilo
    private Runner runner;
    private JTextArea tablero;

    //Constructor del hilo que recibe el corredor y area de texto
    public ThreadRunner(Runner runner, JTextArea tablero) {
        this.runner = runner;
        this.tablero = tablero;
    }

    //Método que se ejecuta al iniciar el hilo
    public void run() {
        try {
            //Calcula el tiempo de espera en milisegundos
            long seg = runner.getSpeed() * 1000L;
            //Pone el hilo a dormir por el tiempo calculado
            Thread.sleep(seg);

            //Añade el resultado del corredor al area de texto
            tablero.append(runner.toString() + "\n");

        } catch (InterruptedException s) {
            //Manejo de interrupción del hilo
            Thread.currentThread().interrupt();
            System.err.println("Hilo interrumpido - Corredor: " + runner.getName());
        }


    }
}
