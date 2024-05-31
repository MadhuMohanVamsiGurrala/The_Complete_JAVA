import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowEvents extends JPanel implements MouseListener, MouseMotionListener {
    private JFrame frame;
    private String msg = "";
    private int mouseX = 0, mouseY = 10;
    private int movX = 0, movY = 0;

    public WindowEvents() {
        // Create a frame window.
        frame = new SampleFrame("Handle Mouse Events");
        frame.setSize(300, 200);
        frame.setVisible(true);

        // Register this object to receive its own mouse events
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Applet in JPanel");
        WindowEvents appletPanel = new WindowEvents();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(300, 100);
        mainFrame.add(appletPanel);
        mainFrame.setVisible(true);
    }

    // Handle mouse clicked.
    public void mouseClicked(MouseEvent me) {}

    // Handle mouse entered.
    public void mouseEntered(MouseEvent me) {
        // save coordinates
        mouseX = 0;
        mouseY = 24;
        msg = "Mouse just entered applet window.";
        repaint();
    }

    // Handle mouse exited.
    public void mouseExited(MouseEvent me) {
        // save coordinates
        mouseX = 0;
        mouseY = 24;
        msg = "Mouse just left applet window.";
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
        movX = me.getX();
        movY = me.getY();
        msg = "*";
        repaint();
    }

    // Handle mouse moved.
    public void mouseMoved(MouseEvent me) {
        // save coordinates
        movX = me.getX();
        movY = me.getY();
        repaint(0, 0, 100, 20);
    }

    // Display msg in applet window.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(msg, mouseX, mouseY);
        g.drawString("Mouse at " + movX + ", " + movY, 0, 10);
    }
}

// Create a subclass of JFrame.
class SampleFrame extends JFrame implements MouseListener, MouseMotionListener {
    private String msg = "";
    private int mouseX = 10, mouseY = 40;
    private int movX = 0, movY = 0;

    SampleFrame(String title) {
        super(title);
        // register this object to receive its own mouse events
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    // Handle mouse clicked.
    public void mouseClicked(MouseEvent me) {}

    // Handle mouse entered.
    public void mouseEntered(MouseEvent me) {
        // save coordinates
        mouseX = 10;
        mouseY = 54;
        msg = "Mouse just entered child.";
        repaint();
    }

    // Handle mouse exited.
    public void mouseExited(MouseEvent me) {
        // save coordinates
        mouseX = 10;
        mouseY = 54;
        msg = "Mouse just left child window.";
        repaint();
    }

    // Handle mouse pressed.
    public void mousePressed(MouseEvent me) {
        // save coordinates
        mouseX = me.getX();
        mouseY = me.getY();
        msg = "Down";
        repaint();
    }

    // Handle mouse released.
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
        movX = me.getX();
        movY = me.getY();
        msg = "*";
        repaint();
    }

    // Handle mouse moved.
    public void mouseMoved(MouseEvent me) {
        // save coordinates
        movX = me.getX();
        movY = me.getY();
        repaint(0, 0, 100, 60);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(msg, mouseX, mouseY);
        g.drawString("Mouse at " + movX + ", " + movY, 10, 40);
    }
}
