import javax.swing.*;
import java.awt.event.*;

public class AnonymousInnerClassDemo extends JFrame {
    JLabel statusLabel;

    public AnonymousInnerClassDemo() {
        setTitle("Anonymous Inner Class Demo");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        statusLabel = new JLabel("Status: ");
        add(statusLabel);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                // Update the status label
                statusLabel.setText("Status: Mouse Pressed");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AnonymousInnerClassDemo::new);
    }
}
