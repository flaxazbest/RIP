package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Field extends JPanel implements ActionListener {

    Timer mainTimer = new Timer(20, this);

    Image img = new ImageIcon("src/res/grass.jpg").getImage();

    Player p = new Player();

    public Field() {
        mainTimer.start();
        addKeyListener(new myKeyAdapter());
        setFocusable(true);
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
        g.drawImage(p.img, (int)p.x, (int)p.y, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        p.move();
        repaint();
    }
}
