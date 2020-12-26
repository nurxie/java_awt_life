import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.*;

public class Monitor extends JFrame implements MouseListener {
    int frameWidth = 0;
    int frameHeight = 0;
    char[][] mass = new char[frameWidth][frameHeight];

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }

    public void createFrame() {
        addMouseListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Conway's game of life");
        setSize(frameWidth, frameHeight);
        setResizable(false);
        setVisible(true);
    }



    public void setMass(char[][] mass) {
        this.mass = mass;
    }

    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }
}
