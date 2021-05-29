package de.dapole.gui.util;

import de.dapole.util.Leveling;
import de.dapole.util.user.User;

import javax.swing.*;
import java.awt.*;

public class Drawable extends JPanel {

    int x;
    int y;
    int width;
    int height;
    double filled;
    double exp;
    int lvl;

    //die Saeulen die auf dem Profilbildschirm rechts und links sind
    public Drawable(int x, int y, int width, int height, double exp, int lvl){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.exp = exp;
        this.filled = exp / Leveling.calcNextLevelEXP(lvl);
        this.lvl = lvl;
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //Saeule
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x, y, width, height);
        g2d.setColor(Color.GREEN);
        g2d.fillRect(x+1, y +height - (int) (filled * 200), width-1, (int) (filled * 200) - 1);

        //Umrandung schwarz
        g2d.setPaint(Color.black);
        g2d.setFont(new Font("Serif", Font.BOLD, 21));
        String s1 = "lvl " + this.lvl;
        FontMetrics fm1 = g2d.getFontMetrics();
        g2d.drawString(s1, x + (width - fm1.stringWidth(s1)) / 2, y+height+fm1.getHeight());

        //Levelanzeige orange
        g2d.setPaint(Color.orange);
        g2d.setFont(new Font("Serif", Font.BOLD, 20));
        String s = "lvl " + this.lvl;
        FontMetrics fm = g2d.getFontMetrics();
        g2d.drawString(s, x + (width - fm.stringWidth(s)) / 2, y+height+fm.getHeight());

        //exp anzeige schwarz
        g2d.setPaint(Color.black);
        g2d.setFont(new Font("Serif", Font.BOLD, 10));
        String s2 = this.exp + " / " + Leveling.calcNextLevelEXP(this.lvl);
        FontMetrics fm2 = g2d.getFontMetrics();
        g2d.drawString(s2, x + (width - fm2.stringWidth(s2)) / 2, y+height+fm1.getHeight()+fm2.getHeight());

    }
}
