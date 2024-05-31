import javax.swing.*;
import java.awt.*;

public class Lines extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw various lines on the panel
        g.drawLine(0, 0, 100, 100);       // Line from (0,0) to (100,100)
        g.drawLine(0, 100, 100, 0);       // Line from (0,100) to (100,0)
        g.drawLine(40, 25, 250, 180);     // Line from (40,25) to (250,180)
        g.drawLine(75, 90, 400, 400);     // Line from (75,90) to (400,400)
        g.drawLine(20, 150, 400, 40);     // Line from (20,150) to (400,40)
        g.drawLine(5, 290, 80, 19);       // Line from (5,290) to (80,19)
    }

    private static void createAndShowGUI() {
        // Create and set up the window
        JFrame frame = new JFrame("Lines Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the Lines panel to the frame
        frame.add(new Lines());
        frame.setSize(500, 500); // Set the frame size
        frame.setVisible(true);  // Display the window
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
