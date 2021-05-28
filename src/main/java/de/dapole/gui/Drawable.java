package de.dapole.gui;

import javax.swing.*;
import java.awt.*;

public class Drawable extends JPanel {

    int x;
    int y;
    int width;
    int height;
    double filled;

    public Drawable(int x, int y, int width, int height, double filled){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.filled = filled;
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x, y, width, height);
        g2d.setColor(Color.GREEN);
        g2d.fillRect(x+1, y +height - (int) filled * 2, width-1, (int) filled * 2);
    }
}
