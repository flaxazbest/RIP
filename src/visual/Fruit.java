package visual;

import javax.swing.*;
import java.awt.*;

class Fruit {

    int x;
    int y;
    private int v;
    private int points;
    Image img = new ImageIcon("src/res/fruit.png").getImage();
    private Field field;

    Fruit(int x, int y, int v, int points, Field field) {
        this.x = x;
        this.y = y;
        this.v = v;
        this.points = points;
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
