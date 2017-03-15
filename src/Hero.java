import java.util.LinkedList;
import java.util.List;

public class Hero implements Moveble {
    private String name;

    private double hp;
    private double maxHp;
    private double speed;
    private double bonusSpeed;
    private double dyingSpeed;
    private List<Power> listOfPower;


    private int level;
    private long score;
    private short lives;

    public Hero(String name) {
        this.name = name;

        level = 1;
        score = 0L;
        lives = 3;

        speed = 1.0;
        dyingSpeed = 0.1;
        maxHp = 2;
        hp = maxHp;
        bonusSpeed = 0.0;
        listOfPower = new LinkedList<>();
    }

    public void decreaseHP() {
        hp -= dyingSpeed;
        if (!isAlive()) {
            lives--;
            hp = maxHp;
        }
    }

    @Override
    public String toString() {
        String t = String.format("%.2f", hp);
        String s = name + "\n HP: " + t + "\n Score: " + score
                + "\n Level: " + level + "\n Lives: " + lives + "\n Speed: " + (
                        speed+bonusSpeed);
        return s;
    }

    public void getPower(Power p) {
        listOfPower.add(p);
    }

    private void levelUp() {
        boolean flag;
        do {
            flag = false;
            long s = (2*100 + 50*(level-1)) * (level) / 2;
            if (s <= score) {
                level++;
                flag = true;
            }
            setMaxHp(2.0 + (level - 1)*0.5);
            setSpeed(level/5*0.2+1.0);
            hp = maxHp;
        } while (flag);
    }

    private void setMaxHp(double hp) {
        this.maxHp = hp;
    }

    private void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isAlive() {
        return hp > 0.0;
    }

    private void livesLost() {
        if (!isAlive()) lives--;
    }

    public boolean isDead() {
        return lives < 1;
    }

    private void plusHp(double hp) {
        this.hp += hp;
        if (this.hp > maxHp)
            this.hp = maxHp;
    }

    public void eat(Food f) {
        score += f.getPoints();
        plusHp(f.getHp());
        if (f.getBonuses().size()>0) {
            for (Bonus b: f.getBonuses()) {
                switch (b) {
                    case PEPPER: bonusSpeed += 0.01; break;
                    case NUT: bonusSpeed -= 0.01; break;
                }
            }
        }
        levelUp();
    }

    //  for DEBUG
public void setScore(long score) {
    this.score = score;
    levelUp();
}


    @Override
    public void move() {
        System.out.println("Hero move");
    }
}
