package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {

    final int WIDTH = 300;
    final int HEIGHT = 330;

    public GameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setLocationRelativeTo(null);

        JLabel generations = new JLabel("Generation # 1");
        generations.setName("GenerationLabel");
        generations.setBounds(10, 1, WIDTH,15);

        JLabel alive = new JLabel("Alive: 82");
        alive.setName("AliveLabel");
        alive.setBounds(10, 15, WIDTH,15);

        add(generations);
        add(alive);

        Canvas canvas = new Canvas() {

            public void paint(Graphics g) {
                for (int i = 0, j = 30; i < getWidth(); i+=15, j+=15) {
                    g.drawLine(i, 30, i, getHeight());
                    g.drawLine(0, j, getWidth(), j);
                }
            }
        };
        canvas.setBounds(1, 25, WIDTH - 2, WIDTH - 2);
        add(canvas);


    }

    public static void main(String[] args) {
        new GameOfLife();
    }
}
