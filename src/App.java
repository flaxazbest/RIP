import java.util.Timer;
import java.util.TimerTask;

public class App {

    static final private int T = 100;

    public static void main(String[] args) {
        Hero h = new Hero("TestHero");

        Timer mainTimer = new Timer();
        TimerTask killingTask = new KillingTask(h);
        mainTimer.schedule(killingTask, 0, T);

        //System.out.println(h);

    }

}
