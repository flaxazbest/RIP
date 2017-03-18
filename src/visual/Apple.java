package visual;

import javax.swing.*;

public class Apple extends Fruit {
    Apple(int x, int y, int v, Field field) {
        super(x, y, v, field);
        img = new ImageIcon("src/res/apple.png").getImage();
        points = 15;
    }
}
