package roulette;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class RouletteUI extends JFrame {

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

    //roulette.Stack chamber = new roulette.Stack();

    ArrayList<Ellipse2D> c = new ArrayList<Ellipse2D>();

    public void drawCircles (Graphics2D g) {
        for (int i = 0; i < c.size(); i++)
            c.remove(i);
        c.add(new Ellipse2D.Double(225, 50, 50, 50));
        c.add(new Ellipse2D.Double(150, 100, 50, 50));
        c.add(new Ellipse2D.Double(150, 175, 50, 50));
        c.add(new Ellipse2D.Double(300, 100, 50, 50));
        c.add(new Ellipse2D.Double(300, 175, 50, 50));
        c.add(new Ellipse2D.Double(225, 225, 50, 50));

        g.setColor(Color.gray);
        for (Ellipse2D e : c)
            g.fill(e);
    }


    boolean dead;

    /*private void fireGun() {
        if (chamber.getObject().STATE == roulette.Bullet.STATE.REAL) {
            dead = true;
        } else {
            chamber.pop();
        }
    }*/

    int paintMode = 1;
    int bulletNumber;
    private void redrawBullet(Ellipse2D c, Graphics2D g) {

    }

    public RouletteUI () {
        //setting standards for color and font
        Font f = new Font("Comic Sans MS", Font.PLAIN, 20);
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
        getContentPane().add(fireButton);

        JButton reloadButton = new JButton("Reset Chamber");
        reloadButton.setBounds(200, 10, 100, 40);
        reloadButton.setBorder(b);
        reloadButton.setBackground(r);
        reloadButton.setOpaque(true);
        reloadButton.setVisible(true);
        getContentPane().add(reloadButton);
    }

}
