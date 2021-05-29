package de.dapole.gui;

import javax.swing.*;
import java.awt.*;

public class Drawable extends JPanel {

    int x;
    int y;
    int width;
    int height;
    double filled;
    int lvl;

    public Drawable(int x, int y, int width, int height, double filled, int lvl){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.filled = filled;
        this.lvl = lvl;
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x, y, width, height);
        g2d.setColor(Color.GREEN);
        g2d.fillRect(x+1, y +height - (int) (filled * 200), width-1, (int) (filled * 200));

        //trying outline
        g2d.setPaint(Color.black);
        g2d.setFont(new Font("Serif", Font.BOLD, 21));
        String s1 = "lvl " + this.lvl;
        FontMetrics fm1 = g2d.getFontMetrics();
        g2d.drawString(s1, x + (width - fm1.stringWidth(s1)) / 2, y+height+fm1.getHeight());

        //normal
        g2d.setPaint(Color.orange);
        g2d.setFont(new Font("Serif", Font.BOLD, 20));
        String s = "lvl " + this.lvl;
        FontMetrics fm = g2d.getFontMetrics();
        g2d.drawString(s, x + (width - fm.stringWidth(s)) / 2, y+height+fm.getHeight());

    }
}
