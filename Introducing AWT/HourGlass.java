import javax.swing.*;
import java.awt.*;

public class HourGlass extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Define the points of the polygon (hourglass shape)
        int xpoints[] = {30, 200, 30, 200, 30};
        int ypoints[] = {30, 30, 200, 200, 30};
        int num = 5;
        // Draw the polygon
        g.drawPolygon(xpoints, ypoints, num);
    }

    private static void createAndShowGUI() {
        // Create and set up the window
        JFrame frame = new JFrame("HourGlass Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the HourGlass panel to the frame
        frame.add(new HourGlass());
        frame.setSize(230, 210); // Set the frame size
        frame.setVisible(true);  // Display the window
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
