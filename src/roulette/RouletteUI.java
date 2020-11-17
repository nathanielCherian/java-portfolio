package roulette;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.Arrays;

public class RouletteUI extends JFrame {
    private final int REAL = 0;
    private final int BLANK = 1;

    private Stack chamber = new Stack();
    int bulletNumber = 0;
    ArrayList<Ellipse2D> c = new ArrayList<Ellipse2D>();
    ArrayList<Color> co = new ArrayList<Color>();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                RouletteUI frame = new RouletteUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void initCircles () {
        for (int i = 0; i < c.size(); i++)
            c.remove(i);

        c.add(new Ellipse2D.Double(225, 50, 50, 50));
        c.add(new Ellipse2D.Double(300, 100, 50, 50));
        c.add(new Ellipse2D.Double(300, 175, 50, 50));
        c.add(new Ellipse2D.Double(225, 225, 50, 50));
        c.add(new Ellipse2D.Double(150, 175, 50, 50));
        c.add(new Ellipse2D.Double(150, 100, 50, 50));

        for (int i = 0; i < co.size(); i++)
            co.remove(i);

        for (int i = 0; i < 6; i++) {
            co.add(Color.gray);
        }
    }

    private void fireGun(JPanel p) {
        Bullet b = (Bullet) chamber.peek();
        if (b.state == REAL)
            co.set(bulletNumber, Color.red);
        if (b.state == BLANK)
            co.set(bulletNumber, Color.black);

        p.repaint();
        chamber.pop();
        bulletNumber++;
    }

    private void redrawBullets(Graphics2D g) {
        for (int i = 0; i < 6; i++) {
            g.setColor(co.get(i));
            g.fill(c.get(i));
        }
    }

    private void resetGame () {
        bulletNumber = 0;
        chamber = RouletteControl.loadChamber();
        initCircles();
        repaint();
    }

    public RouletteUI () {
        //setting standards for color and font
        Font f = new Font("Gadugi", Font.PLAIN, 20);
        MatteBorder b = new MatteBorder(4, 4, 4, 4, Color.BLACK);
        Color r = new Color(208, 75, 75);
        Color bl = new Color(0, 0, 0);

        //operations to set up the JFrame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        getContentPane().setLayout(null);

        //setting up JPanel
        JPanel p = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                redrawBullets(g2d);

            }
        };
        getContentPane().add(p);
        p.setSize(500, 500);
        p.setBackground(bl);

        JButton fireButton = new JButton("Fire");
        fireButton.setBounds(150, 350, 200, 50);
        fireButton.setBorder(b);
        fireButton.setBackground(r);
        fireButton.setOpaque(true);
        fireButton.setVisible(true);
        fireButton.setFont(f);
        fireButton.addActionListener(e -> fireGun(p));
        getContentPane().add(fireButton);

        JButton reloadButton = new JButton("Reset Chamber");
        reloadButton.setBounds(200, 10, 100, 40);
        reloadButton.setBorder(b);
        reloadButton.setBackground(r);
        reloadButton.setOpaque(true);
        reloadButton.setVisible(true);
        reloadButton.setFont(new Font("Gadugi", Font.PLAIN, 10));
        reloadButton.addActionListener(e -> resetGame());
        getContentPane().add(reloadButton);

        resetGame();
    }

}
