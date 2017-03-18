package visual;

import javax.swing.*;
import java.awt.*;

abstract class Fruit {

    int x;
    int y;
    private int v;
    protected int points;
    Image img;// = new ImageIcon("src/res/fruit.png").getImage();
    private Field field;

    Fruit(int x, int y, int v, Field field) {
        this.x = x;
        this.y = y;
        this.v = v;
        this.field = field;
    }

    void move() {
        x -= 10 + v;
    }

    Rectangle getRectangle() {
        return new Rectangle(x, y, 128, 128);
    }

    int getPoints() {
        return points;
    }
}
