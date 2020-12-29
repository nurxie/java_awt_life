import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.JFrame;
import java.lang.Object;
import java.awt.Component;
import java.awt.Choice;
import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class Settings extends JFrame {

    Game game = new Game();

      int  x_define = 29;
      int  y_define = 29;
      int radius = 12;
      int delay = 50;
      int b1 = 3;
      int s1 = 2;
      int s2 = 3;
    char UNFILLED = '*';
    char FILLED = '#';

    boolean next = false;
    String colorCells = "";
    String colorBackground = "";
    String FPS = "";
    String dimensions = "";

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
        JFrame settingsFrame = new JFrame("Settings");
        settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settingsFrame.getContentPane().setBackground(Color.WHITE);
        //setSize(400, 200);
        settingsFrame.setResizable(false);
        //setVisible(true);

        String colorOfCells[]={"Green","Black","White","Pink","Blue"};
        JComboBox colorOfCellsCB=new JComboBox(colorOfCells);
        colorOfCellsCB.setBounds(30, 20,90,20);
        settingsFrame.add(colorOfCellsCB);
        //settingsFrame.setLayout(null);
        settingsFrame.setSize(280,350);
        //settingsFrame.setVisible(true);

        JLabel colorOfCellsText = new JLabel();
        colorOfCellsText.setText("Color of cells");
        settingsFrame.add(colorOfCellsText);
        colorOfCellsText.setBounds(37, -5, 200, 30);

        String colorOfBackground[]={"Black","Green","White","Pink","Blue"};
        JComboBox colorOfBackgroundCB=new JComboBox(colorOfBackground);
        colorOfBackgroundCB.setBounds(145, 20,90,20);
        settingsFrame.add(colorOfBackgroundCB);
        /*settingsFrame.setLayout(null);
        settingsFrame.setVisible(true);*/

        JLabel colorOfBackgroundText = new JLabel();
        colorOfBackgroundText.setText("Color of background");
        settingsFrame.add(colorOfBackgroundText);
        colorOfBackgroundText.setBounds(130, -5, 200, 30);

        String speedOfLife[]={"5fps","10fps","24fps","30fps","42fps", "60fps", "120fps"};
        JComboBox speedOfLifeCB=new JComboBox(speedOfLife);
        speedOfLifeCB.setBounds(30, 85,90,20);
        settingsFrame.add(speedOfLifeCB);
        /*settingsFrame.setLayout(null);
        settingsFrame.setVisible(true);*/

        JLabel speedOfLifeText = new JLabel();
        speedOfLifeText.setText("Speed of life");
        settingsFrame.add(speedOfLifeText);
        speedOfLifeText.setBounds(37, 60, 200, 30);

        String frameDimensions[]={"5x5","8x8","12x12","16x16","24x24", "32x32", "48x48", "64x64"};
        JComboBox frameDimensionsCB=new JComboBox(frameDimensions);
        frameDimensionsCB.setBounds(145, 85,90,20);
        settingsFrame.add(frameDimensionsCB);
        /*settingsFrame.setLayout(null);
        settingsFrame.setVisible(true);*/

        JLabel frameDimensionsText = new JLabel();
        frameDimensionsText.setText("Frame dimensions");
        settingsFrame.add(frameDimensionsText);
        frameDimensionsText.setBounds(140, 60, 200, 30);

        JButton b=new JButton("Start!");
        b.setBounds(80,130,95,30);
        settingsFrame.add(b);
        settingsFrame.setLayout(null);
        settingsFrame.setVisible(true);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                settingsFrame.dispose();
                next = true;
                colorCells = "" + colorOfCellsCB.getItemAt(colorOfCellsCB.getSelectedIndex());
                colorBackground = "" + colorOfBackgroundCB.getItemAt(colorOfBackgroundCB.getSelectedIndex());
                FPS = "" + speedOfLifeCB.getItemAt(speedOfLifeCB.getSelectedIndex());
                dimensions = "" + frameDimensionsCB.getItemAt(frameDimensionsCB.getSelectedIndex());
                nextStep();
            }
        });
    }

    boolean nextStep(){
        if(next) {
        /*game.createFrame();
        game.startGame();*/   //"5x5","8x8","12x12","16x16","24x24", "32x32", "48x48", "64x64"
            //if(dimensions == "5x5") {
            game.setX_define(5);
            game.setY_define(5);
            //}
        }
        return next;
    }
}
