package visual;

import javax.swing.*;

public class Strawberry extends Fruit {
    Strawberry(int x, int y, int v, Field field) {
        super(x, y, v, field);
        img = new ImageIcon("src/res/fruit.png").getImage();
        points = 5;
    }
}
