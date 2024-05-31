import javax.swing.*;
import java.awt.*;

public class Rectangles extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw various rectangles
        g.drawRect(10, 10, 60, 50);                // Draw an outlined rectangle
        g.fillRect(100, 10, 60, 50);               // Draw a filled rectangle
        g.drawRoundRect(190, 10, 60, 50, 15, 15);  // Draw an outlined rounded rectangle
        g.fillRoundRect(70, 90, 140, 100, 30, 40); // Draw a filled rounded rectangle
    }

    private static void createAndShowGUI() {
        // Create and set up the window
        JFrame frame = new JFrame("Rectangles Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the Rectangles panel to the frame
        frame.add(new Rectangles());
        frame.setSize(300, 200); // Set the frame size
        frame.setVisible(true);  // Display the window
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
