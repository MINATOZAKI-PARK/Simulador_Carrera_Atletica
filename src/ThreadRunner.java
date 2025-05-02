import javax.swing.JTextArea;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.SwingUtilities;

public class ThreadRunner implements Runnable {
    private static final AtomicInteger COUNTER = new AtomicInteger(1);
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

            int lugar = COUNTER.getAndIncrement();
            //Añade el resultado del corredor al area de texto
            SwingUtilities.invokeLater(()->tablero.append(COUNTER + "- "+runner.toString() + "\n"));


        } catch (InterruptedException s) {
            //Manejo de interrupción del hilo
            Thread.currentThread().interrupt();
            System.err.println("Hilo interrumpido - Corredor: " + runner.getName());
        }


    }
}
