import javax.swing.*;
import java.awt.*;

public class SimpleImageLoad {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simple Image Load");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel label = new JLabel();
            ImageIcon imageIcon = new ImageIcon("seattle.jpg");
            label.setIcon(imageIcon);

            frame.getContentPane().add(label);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
