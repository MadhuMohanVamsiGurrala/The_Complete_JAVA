import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEvents extends JFrame implements MouseListener, MouseMotionListener {
    String msg = "";
    int mouseX = 0, mouseY = 0; // coordinates of mouse

    public MouseEvents() {
        setTitle("Mouse Events");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add mouse listeners
        addMouseListener(this);
        addMouseMotionListener(this);

        // Set up the panel
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString(msg, mouseX, mouseY);
            }
        };

        add(panel);
        setVisible(true);
    }

    // Handle mouse clicked.
    public void mouseClicked(MouseEvent me) {
        // save coordinates
        mouseX = 0;
        mouseY = 10;
        msg = "Mouse clicked.";
        repaint();
    }

    // Handle mouse entered.
    public void mouseEntered(MouseEvent me) {
        // save coordinates
        mouseX = 0;
        mouseY = 10;
        msg = "Mouse entered.";
        repaint();
    }

    // Handle mouse exited.
    public void mouseExited(MouseEvent me) {
        // save coordinates
        mouseX = 0;
        mouseY = 10;
        msg = "Mouse exited.";
        repaint();
    }

    // Handle button pressed.
    public void mousePressed(MouseEvent me) {
        // save coordinates
        mouseX = me.getX();
        mouseY = me.getY();
        msg = "Down";
        repaint();
    }

    // Handle button released.
    public void mouseReleased(MouseEvent me) {
        // save coordinates
        mouseX = me.getX();
        mouseY = me.getY();
        msg = "Up";
        repaint();
    }

    // Handle mouse dragged.
    public void mouseDragged(MouseEvent me) {
        // save coordinates
        mouseX = me.getX();
        mouseY = me.getY();
        msg = "*";
        setTitle("Dragging mouse at " + mouseX + ", " + mouseY);
        repaint();
    }

    // Handle mouse moved.
    public void mouseMoved(MouseEvent me) {
        // show status
        setTitle("Moving mouse at " + me.getX() + ", " + me.getY());
    }

    public static void main(String[] args) {
        new MouseEvents();
    }
}
