import javax.swing.*;
import java.awt.*;

public class Ellipses extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw various ellipses
        g.drawOval(10, 10, 50, 50);                // Draw an outlined circle
        g.fillOval(100, 10, 75, 50);               // Draw a filled ellipse
        g.drawOval(190, 10, 90, 30);               // Draw an outlined ellipse
        g.fillOval(70, 90, 140, 100);              // Draw a filled ellipse
    }

    private static void createAndShowGUI() {
        // Create and set up the window
        JFrame frame = new JFrame("Ellipses Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the Ellipses panel to the frame
        frame.add(new Ellipses());
        frame.setSize(300, 200); // Set the frame size
        frame.setVisible(true);  // Display the window
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
