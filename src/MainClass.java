import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.JFrame;

public class MainClass extends JFrame implements MouseListener {
    final Random random = new Random();
    final public int  x_define = 29;
    final public int  y_define = 29;
    final public int radius = 12;
    final public int delay = 50;
    final public int b1 = 3;
    final public int s1 = 2;
    final public int s2 = 3;
    final public char UNFILLED = '*';
    final public char FILLED = '#';

    Cell[][] cell = new  Cell[y_define][x_define];

    char[][] mass_income = new char[y_define+1][x_define+1];
    char[][] mass_outcome = new char[y_define+1][x_define+1];


    public int neighbors_counter(char[][] mass, int y_outside, int x_outside) {
        int number_of_neighbors = 0;

        if ((y_outside - 1) >= 0 && mass[y_outside - 1][x_outside] == FILLED) number_of_neighbors++;

        if ((y_outside - 1) >= 0 && (x_outside + 1) <= x_define && mass[y_outside - 1][x_outside + 1] == FILLED) number_of_neighbors++;
        if ((x_outside + 1) <= x_define && mass[y_outside][x_outside + 1] == FILLED) number_of_neighbors++;

        if ((y_outside + 1) <= y_define && (x_outside + 1) <= x_define && mass[y_outside + 1][x_outside + 1] == FILLED) number_of_neighbors++;
        if ((y_outside + 1) <= y_define && mass[y_outside + 1][x_outside] == FILLED) number_of_neighbors++;

        if ((y_outside + 1) <= y_define && (x_outside - 1) >= 0 && mass[y_outside + 1][x_outside - 1] == FILLED) number_of_neighbors++;
        if ((x_outside - 1) >= 0 && mass[y_outside][x_outside - 1] == FILLED) number_of_neighbors++;

        if ((y_outside - 1) >= 0 && (x_outside - 1) >= 0 && mass[y_outside - 1][x_outside - 1] == FILLED) number_of_neighbors++;

        return number_of_neighbors;
    }

    public boolean cell_death(char[][] mass_outcome, int y_outside, int x_outside) {
        mass_outcome[y_outside][x_outside] = UNFILLED;
        return true;
    }

    public boolean cell_remains(char[][] mass_outcome, int y_outside, int x_outside) {
        mass_outcome[y_outside][x_outside] = FILLED;
        return true;
    }

    public boolean cell_survival(char[][] mass_income, char[][] mass_outcome, int y_outside, int x_outside){
        if (neighbors_counter(mass_income, y_outside, x_outside) == s1 || neighbors_counter(mass_income, y_outside, x_outside) == s2)
        {
            cell_remains(mass_outcome, y_outside, x_outside);
            //noting to do, may be + to score?
        }
        if (neighbors_counter(mass_income, y_outside, x_outside) > s2)
        {
            cell_death(mass_outcome, y_outside, x_outside);
        }
        if (neighbors_counter(mass_income, y_outside, x_outside) < s1)
        {
            cell_death(mass_outcome, y_outside, x_outside);
        }
        return true;
    }

    public boolean cell_birth(char[][] mass_income, char[][] mass_outcome, int y_outside, int x_outside) {
        if (neighbors_counter(mass_income, y_outside, x_outside) >= b1) {
            mass_outcome[y_outside][x_outside] = FILLED;
            cell_survival(mass_income, mass_outcome, y_outside, x_outside);
        }
        return true;
    }

    public boolean life_period(char[][] mass_income, char[][] mass_outcome) {
        for (int y = 0; y <= y_define; y++) {
            for (int x = 0; x <= x_define; x++) {
                if (mass_income[y][x] == FILLED) {
                    cell_survival(mass_income, mass_outcome, y, x);
                } else {
                    cell_birth(mass_income, mass_outcome, y, x);
                }
            }
        }
        return true;
    }

    public void cout_mass(char[][] mass_outcome) {
        boolean typeOfCell = false;
        for (int y = 0; y < y_define; y++) {
            for (int x = 0; x < x_define; x++) {
                System.out.print(mass_outcome[y][x]);
                if(mass_outcome[y][x] == FILLED) typeOfCell = true;
                if(mass_outcome[y][x] == UNFILLED) typeOfCell = false;
                cell[y][x].setSelected(typeOfCell);
            }
            System.out.println();
        }
        repaint();
    }

    public boolean fill_mass_with_unfill(char[][] mass) {
        for (int y = 0; y <= y_define; y++) {
            for (int x = 0; x <= x_define; x++) {
                mass[y][x] = UNFILLED;
            }
        }
        return true;
    }

    public void arrayInit(){
        for (int y = 0; y <= y_define; y++) {
            for (int x = 0; x <= x_define; x++) {
                mass_outcome[y][x] = UNFILLED;
            }
        }
        for (int y = 0; y <= y_define; y++) {
            for (int x = 0; x <= x_define; x++) {
                mass_income[y][x] = UNFILLED;
            }
        }
        boolean typeOfCell = false;
        char mode = UNFILLED;
        for (int y = 0; y <= y_define; y++) {
            for (int x = 0; x <= x_define; x++) {
                typeOfCell = random.nextBoolean();
                if(typeOfCell) mode = FILLED;
                if(!typeOfCell) mode = UNFILLED;
                mass_income[y][x] = mode;
            }
        }
    }

    public boolean appropriation_mass(char[][] mass_income, char[][] mass_outcome) {
        for (int y = 0; y <= y_define; y++) {
            for (int x = 0; x <= x_define; x++) {
                mass_income[y][x] = mass_outcome[y][x];
            }
        }
        return true;
    }

    public void waiting(){
         try {
             Thread.sleep(delay);
         } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    public void startGame(){
        initCells();
        arrayInit();
        fill_mass_with_unfill(mass_outcome);
        cout_mass(mass_income);
        appropriation_mass(mass_outcome, mass_income);

        System.out.println("==============================");

        for (int i = 0; i < 99999; i++) {
            waiting();
            life_period(mass_income, mass_outcome);
            cout_mass(mass_outcome);
            appropriation_mass(mass_income, mass_outcome);
            fill_mass_with_unfill(mass_outcome);
            System.out.println("==============================");
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }

    private void initCells(){
        for (int y = 0; y < y_define; y++){
            for (int x = 0; x < x_define; x++){
                cell[y][x] = new Cell();
                cell[y][x].setxCenter(15 + y*2*radius);
                cell[y][x].setyCenter(40 + x*2*radius);
                cell[y][x].setRadius(radius);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int y = 0; y < y_define; y++) {
            for (int x = 0; x < x_define; x++) {
                cell[y][x].draw(g);
            }
        }
    }

    public static void main(String[] args) {
        MainClass game = new MainClass();
        game.createFrame();
        game.startGame();
    }


    public void createFrame() {
        addMouseListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        setTitle("Conway's game of life");
        setSize(x_define*2*radius+10, y_define*2*radius+35);
        setResizable(false);
        setVisible(true);
        getContentPane().setBackground(Color.black);
    }
}