package visual;

import javax.swing.*;

public class Banana extends Fruit {
    Banana(int x, int y, int v, Field field) {
        super(x, y, v, field);
        img = new ImageIcon("src/res/banana.png").getImage();
        points = 30;
    }
}
