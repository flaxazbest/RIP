package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    Image img = new ImageIcon("src/res/hero.png").getImage().getScaledInstance(250, 123, 0);

    double v = 10.0;
    double s = 0.0;
    double layer1 = 0.0;
    double layer2 = 800.0;
    String tt;

    int points = 0;

    int x = 200;
    int y = 30;

    public void move() {
        s += v;
        if (layer2 - v <= 0) {
            layer1 = 0;
            layer2 = 800;
        } else {
            layer1 -= v;
            layer2 -= v;
        }

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP)
            y-=5;
        if (key == KeyEvent.VK_DOWN)
            y+=5;
    }

    public void keyReleased(KeyEvent e) {
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, 200, 123);
    }
}
