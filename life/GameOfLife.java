package life;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class GameOfLife extends JFrame {

    Universe universe;
    int uniSize = 20;
    JPanel gridPanel;
    JLabel alive;
    JLabel generations;
    boolean pause = true;
    boolean restart;
    AtomicInteger gen = new AtomicInteger(1);
    public static JToggleButton pauseButton;
    public static JButton restartButton;

    public Universe getUniverse() {
        return universe;
    }

    public GameOfLife() {
        universe = new Universe(uniSize);
        setTitle("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        generations = new JLabel("Generation #" + gen.getAndIncrement());
        generations.setName("GenerationLabel");
//        generations.setBounds(10, 1, getWidth(),15);

        alive = new JLabel("Alive: " + universe.getAlive() + "   ");
        alive.setName("AliveLabel");
//        alive.setBounds(10, 15, getWidth(),15);

         gridPanel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);

//                g.setColor(Color.gray);
                int cells = universe.grid.length;

                for (int i = 0; i < universe.grid.length + 1; i++) {
                    g.drawLine(0, i * getHeight() / cells, getWidth(), i * getHeight() / cells);
                    g.drawLine(i * getWidth() / cells, 0, i * getWidth() / cells, getHeight() );
                }

                for (int i = 0; i < universe.grid.length; i++) {
                    for (int j = 0; j < universe.grid[i].length; j++) {
                        if (universe.grid[i][j]) {
                            g.fillRect(
                                    j * getWidth()/cells,
                                    i * getHeight()/cells,
                                    getWidth()/cells,
                                    getHeight()/cells);
                        }
                    }
                }
            }
        };
        gridPanel.setPreferredSize(new Dimension(400, 400));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));

        pauseButton = new JToggleButton( "pause");//new ImageIcon("data\\pause.png"));
        pauseButton.setName("PlayToggleButton");
        pauseButton.setFont(pauseButton.getFont().deriveFont(9f));
        pauseButton.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        pauseButton.setPreferredSize(new Dimension(40, 30));
        pauseButton.addActionListener(e -> {
            if (pauseButton.isSelected()) {
                pause = false;
            } else {
                pause = true;
            }
        });

        restartButton = new JButton("restart");
        restartButton.setName("ResetButton");
        restartButton.setFont(restartButton.getFont().deriveFont(9f));
        restartButton.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        restartButton.setPreferredSize(new Dimension(40, 30));
        restartButton.addActionListener(e -> {
            restart = true;
        });

        buttonPanel.add(pauseButton);
        buttonPanel.add(restartButton);

        setLayout(new BorderLayout());
        JPanel labPanel = new JPanel();
        labPanel.setLayout(new BoxLayout(labPanel, BoxLayout.PAGE_AXIS));

        JPanel controlPanel = new JPanel(new GridLayout(9, 1, 2, 10));
        labPanel.add(generations);
        labPanel.add(alive);
        controlPanel.add(buttonPanel);
        controlPanel.add(labPanel);
        add(controlPanel, BorderLayout.WEST);
        add(gridPanel, BorderLayout.CENTER);
        pack();
        setVisible(true);


    }

    @Override
    public void repaint() {
        super.repaint();
        gridPanel.repaint();
        alive.setText("Alive: " + universe.getAlive() + "   ");
        generations.setText("Generation #" + gen.getAndIncrement());

    }

    public static void main(String[] args) {
        new GameOfLife();
    }
}
