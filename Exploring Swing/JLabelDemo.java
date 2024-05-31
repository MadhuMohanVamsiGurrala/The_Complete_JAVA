import javax.swing.*;
import java.awt.*;

public class JLabelDemo extends JFrame {
    public JLabelDemo() {
        setTitle("JLabel Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Specify the full path of the image file
        String imagePath = "E:\\Fullstack Accelerator\\The Complete JAVA\\Exploring Swing\\france.gif";
        
        // Create an icon.
        ImageIcon ii = new ImageIcon(imagePath);

        // Create a label.
        JLabel jl = new JLabel("France", ii, JLabel.CENTER);

        // Add the label to the content pane.
        add(jl);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JLabelDemo());
    }
}
