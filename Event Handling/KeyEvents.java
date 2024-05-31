import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyEvents extends JFrame implements KeyListener {
    String msg = "";
    int X = 10, Y = 20; // output coordinates

    public KeyEvents() {
        setTitle("Key Events");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add key listener
        addKeyListener(this);

        // Set up the panel
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString(msg, X, Y);
            }
        };

        add(panel);
        setVisible(true);
    }

    // Handle key pressed
    public void keyPressed(KeyEvent ke) {
        setTitle("Key Down");
        int key = ke.getKeyCode();
        switch (key) {
            case KeyEvent.VK_F1:
                msg += "<F1>";
                break;
            case KeyEvent.VK_F2:
                msg += "<F2>";
                break;
            case KeyEvent.VK_F3:
                msg += "<F3>";
                break;
            case KeyEvent.VK_PAGE_DOWN:
                msg += "<PgDn>";
                break;
            case KeyEvent.VK_PAGE_UP:
                msg += "<PgUp>";
                break;
            case KeyEvent.VK_LEFT:
                msg += "<Left Arrow>";
                break;
            case KeyEvent.VK_RIGHT:
                msg += "<Right Arrow>";
                break;
        }
        repaint();
    }

    // Handle key released
    public void keyReleased(KeyEvent ke) {
        setTitle("Key Up");
    }

    // Handle key typed
    public void keyTyped(KeyEvent ke) {
        msg += ke.getKeyChar();
        repaint();
    }

    // Main method to run the application
    public static void main(String[] args) {
        new KeyEvents();
    }
}
