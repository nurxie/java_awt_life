import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.JFrame;

public class MainClass extends JFrame {
    Settings settings = new Settings();
    Game game = new Game();

    final public int  x_define = 29;
    final public int  y_define = 29;
    final public int radius = 12;
    final public int delay = 1000;
    final public int b1 = 3;
    final public int s1 = 2;
    final public int s2 = 3;
    final public char UNFILLED = '*';
    final public char FILLED = '#';

    public  void start() {
        while (true) {
            System.out.println(settings.nextStep());
            if (settings.nextStep()) {
                game.createFrame();
                game.startGame();
            }
        }
    }

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        mainClass.settingsFrame();
       mainClass.start();
    }

    public void settingsFrame(){
        settings.setRadius(radius);
        settings.setX_define(x_define);
        settings.setY_define(y_define);
        settings.createFrame();
    }
}