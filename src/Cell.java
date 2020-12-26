import java.awt.*;

public class Cell {
    private int xCenter;
    private int yCenter;
    private int radius;
    boolean isSelected = false;

    public void draw(Graphics g){
        /*g.setColor(Color.black);
        g.drawString("Score: " + " ", 20,50);*/
        g.setColor(Color.black);
        g.fillOval(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius);
        if (isSelected){
            g.setColor(Color.green);
            g.fillOval(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius);
        }
    }

    public boolean isMouseUnderMe(int yMouse, int xMouse){
        return (xMouse-xCenter)*(xMouse-xCenter)+(yMouse-yCenter)*(yMouse-yCenter) <= radius*radius;
    }

    public void setxCenter(int xCenter) {
        this.xCenter = xCenter;
    }

    public void setyCenter(int yCenter) {
        this.yCenter = yCenter;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

}
