import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.JFrame;
import java.lang.Object;
import java.awt.Component;
import java.awt.Choice;
public class Settings extends JFrame{
    int x_define = 10;
    int y_define = 10;
    int radius = 5;
    static Choice choiceColorOfCells;
    static Choice choiceColorOfBackground;
    static Choice choiceQuantityOfCells;
    static Choice choiceSpeedOfLife;

    static JFrame settings;

    public void setX_define(int x_define) {
        this.x_define = x_define;
    }

    public void setY_define(int y_define) {
        this.y_define = y_define;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void createFrame() {
        settings = new JFrame("Settings Of Life");
        JPanel p = new JPanel();
        Button b=new Button("Click Here");
        b.setBounds(50,100,60,50);

        choiceColorOfCells = new Choice();
        choiceColorOfCells.add("Green");
        choiceColorOfCells.add("White");
        choiceColorOfCells.add("Red");
        choiceColorOfCells.add("Blue");
        choiceColorOfCells.add("Black");
        choiceColorOfCells.add("Cyan");

        choiceColorOfBackground = new Choice();
        choiceColorOfBackground.add("Green");
        choiceColorOfBackground.add("White");
        choiceColorOfBackground.add("Red");
        choiceColorOfBackground.add("Blue");
        choiceColorOfBackground.add("Black");
        choiceColorOfBackground.add("Cyan");

        choiceQuantityOfCells = new Choice();
        choiceQuantityOfCells.add("5x5");
        choiceQuantityOfCells.add("8x8");
        choiceQuantityOfCells.add("12x12");
        choiceQuantityOfCells.add("16x16");
        choiceQuantityOfCells.add("24x24");
        choiceQuantityOfCells.add("32x32");
        choiceQuantityOfCells.add("42x42");
        choiceQuantityOfCells.add("48x48");

        choiceSpeedOfLife = new Choice();
        choiceSpeedOfLife.add("5ps");
        choiceSpeedOfLife.add("10ps");
        choiceSpeedOfLife.add("24ps");
        choiceSpeedOfLife.add("35ps");
        choiceSpeedOfLife.add("48ps");
        choiceSpeedOfLife.add("52ps");
        choiceSpeedOfLife.add("60ps");
        choiceSpeedOfLife.add("72ps");

        p.add(choiceColorOfCells);
        p.add(choiceColorOfBackground);
        p.add(choiceQuantityOfCells);
        p.add(choiceSpeedOfLife);
        settings.add(b);
        settings.add(p);
        settings.show();
        settings.setSize(300, 200);
    }
}
