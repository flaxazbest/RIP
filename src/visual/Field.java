package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

public class Field extends JPanel implements ActionListener, Runnable {

    Timer mainTimer = new Timer(20, this);

    Image img = new ImageIcon("src/res/grass.jpg").getImage();

    Player p = new Player();

    Thread fruitFactory = new Thread(this);
    LinkedList<Fruit> fruits = new LinkedList<Fruit>();
    Random rand = new Random();

    Font font = new Font("Georgia", Font.ITALIC | Font.BOLD, 20);

    public Field() {
        mainTimer.start();
        fruitFactory.start();
        addKeyListener(new myKeyAdapter());
        setFocusable(true);
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(2000);
                fruits.add(new Fruit(900, rand.nextInt(600), rand.nextInt(5), rand.nextInt(20), this));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class myKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            p.keyReleased(e);
        }
    }

    public void paint(Graphics g) {
        g.drawImage(img, (int)p.layer1, 0, null);
        g.drawImage(img, (int)p.layer2, 0, null);
        g.drawImage(p.img, p.x, p.y, null);

        for (Fruit f: fruits) {
            if (f.x < -10) fruits.remove(f);
            else {
                f.move();
                g.drawImage(f.img, f.x, f.y, null);
            }
        }

        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString("Points " + p.points, 50, 15);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        p.move();
        repaint();
        testCrossWithFruit();


    }

    private void testCrossWithFruit() {
        for (Fruit f: fruits) {
            if (f.getRectangle().intersects(p.getRectangle())) {
                p.points += f.getPoints();
                fruits.remove(f);
            }
        }
    }


}
