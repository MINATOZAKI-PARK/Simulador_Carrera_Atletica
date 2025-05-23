import java.util.Random;

/**
 * Clase Runner representa a un corredor con un nombre y velocidad random.
 * El valor de velocidad es generado como un (int) entre 1 y 30.
 */
public class Runner {
    private String name;
    private int speed;

    public Runner(String name){
        Random rand = new Random();
        this.name = name;
        this.speed = rand.nextInt(30)+1;
    }

    public String getName(){return this.name;}

    public int getSpeed(){return this.speed;}

    public String toString(){
        return this.name+" - Tiempo: "+this.speed+" segundos";
    }
}

