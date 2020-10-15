package app;

import javax.swing.*;
import java.awt.*;

public interface AnimatedShape {
    public void update();
    public void paint(JComponent parent, Graphics2D g2d, Color color);

}
