import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Food {
    private int points;
    private double hp;
    private FoodType ft;
    private List<Bonus> bonuses;

    public Food(FoodType ft) {
        this.ft = ft;

        switch (ft) {
            case APPLE:
                hp = 1.0;
                points = 20;
                break;
            case BANANA:
                hp = 1.5;
                points = 30;
                break;
            case ORANGE:
                hp = 1.2;
                points = 40;
                break;
            case CAKE:
                hp = 0.5;
                points = 100;
                break;
            default:
                hp = 0.1;
                points = 1;
        }

        bonuses = new LinkedList<>();
        Random rnd = new Random();

        double p = 0.1;
        for (int i=0; i<5; i++) {
            double d = rnd.nextDouble();
            if (d < p) {
                int tmp = rnd.nextInt(2);
                switch (tmp) {
                    case 0: bonuses.add(Bonus.PEPPER); break;
                    case 1: bonuses.add(Bonus.NUT); break;
                }

            }
            p/=10.0;
        }

    }

    public int getPoints() {
        return points;
    }

    public double getHp() {
        return hp;
    }

    public List<Bonus> getBonuses() {
        return bonuses;
    }
}
