package roulette;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;

public class RouletteUI extends JFrame {
    private final int REAL = 0;
    private final int BLANK = 1;
    private final int FULLCHAMBER = 1;
    private final int ONEBULLET = 2;

    private Stack chamber = new Stack();
    int paintMode = 1;
    int bulletNumber = 0;
    int bulletState;
    ArrayList<Ellipse2D> c = new ArrayList<Ellipse2D>();

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

    public void drawCircles (Graphics2D g) {
        for (int i = 0; i < c.size(); i++)
            c.remove(i);
        c.add(new Ellipse2D.Double(225, 50, 50, 50));
        c.add(new Ellipse2D.Double(300, 100, 50, 50));
        c.add(new Ellipse2D.Double(300, 175, 50, 50));
        c.add(new Ellipse2D.Double(225, 225, 50, 50));
        c.add(new Ellipse2D.Double(150, 100, 50, 50));
        c.add(new Ellipse2D.Double(150, 175, 50, 50));

        g.setColor(Color.gray);
        for (Ellipse2D e : c)
            g.fill(e);
    }

    private void fireGun(JPanel p) {
        Bullet b = (Bullet) chamber.peek();
        bulletState = b.state;
        paintMode = ONEBULLET;
        p.repaint();
        chamber.pop();
        bulletNumber++;
    }

    private void redrawBullet(Ellipse2D c, Graphics2D g, int state) {
        switch (state) {
            case REAL:
                g.setColor(Color.RED);
                break;
            case BLANK:
                g.setColor(Color.BLACK);
                break;
        }

        g.fill(c);
    }

    private void resetGame () {
        bulletNumber = 0;
        chamber = RouletteControl.loadChamber();
        paintMode = FULLCHAMBER;
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

                switch (paintMode) {
                    case 1:
                        drawCircles(g2d);
                        break;
                    case 2:
                        redrawBullet(c.get(bulletNumber), g2d, bulletState);
                }

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
        getContentPane().add(reloadButton);

        resetGame();
    }

}
