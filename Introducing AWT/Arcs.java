import javax.swing.*;
import java.awt.*;

public class Arcs extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw various arcs
        g.drawArc(10, 40, 70, 70, 0, 75);         // Draw an outlined arc
        g.fillArc(100, 40, 70, 70, 0, 75);        // Draw a filled arc
        g.drawArc(10, 100, 70, 80, 0, 175);       // Draw an outlined arc
        g.fillArc(100, 100, 70, 90, 0, 270);      // Draw a filled arc
        g.drawArc(200, 80, 80, 80, 0, 180);       // Draw an outlined arc
    }

    private static void createAndShowGUI() {
        // Create and set up the window
        JFrame frame = new JFrame("Arcs Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the Arcs panel to the frame
        frame.add(new Arcs());
        frame.setSize(300, 200); // Set the frame size
        frame.setVisible(true);  // Display the window
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
