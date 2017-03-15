import java.util.TimerTask;

public class KillingTask extends TimerTask {

    private Hero hero;

    public KillingTask(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void run() {
        hero.decreaseHP();
        System.out.println(hero);
        if (hero.isDead())
            cancel();
    }
}
