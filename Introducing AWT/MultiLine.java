import java.applet.*;
import java.awt.*;

// Define the applet
public class MultiLine extends Applet {
    int curX = 0, curY = 0; // current position

    // Initialize the applet
    public void init() {
        // Set the font
        Font f = new Font("SansSerif", Font.PLAIN, 12);
        setFont(f);
    }

    // Paint method to draw multiline output
    public void paint(Graphics g) {
        // Get the font metrics
        FontMetrics fm = g.getFontMetrics();

        // Draw the lines
        nextLine("This is on line one.", g);
        nextLine("This is on line two.", g);
        sameLine(" This is on same line.", g);
        sameLine(" This, too.", g);
        nextLine("This is on line three.", g);
    }

    // Method to advance to the next line
    void nextLine(String s, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        curY += fm.getHeight(); // advance to next line
        curX = 0;
        g.drawString(s, curX, curY);
        curX = fm.stringWidth(s); // advance to end of line
    }

    // Method to display on the same line
    void sameLine(String s, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        g.drawString(s, curX, curY);
        curX += fm.stringWidth(s); // advance to end of line
    }

    // Main method to test the applet
    public static void main(String[] args) {
        Frame f = new Frame("MultiLine Applet");
        MultiLine applet = new MultiLine();
        f.add("Center", applet);
        f.setSize(300, 100);
        applet.init();
        applet.start();
        f.setVisible(true);
    }
}
