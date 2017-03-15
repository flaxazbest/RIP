package visual;

import javax.swing.*;

public class VisualApp {

    public static void main(String[] args) {
        JFrame frame = new JFrame("R.I.P.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new Field());
        frame.setVisible(true);
    }

}
