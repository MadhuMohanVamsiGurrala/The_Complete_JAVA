import javax.swing.*;
import java.awt.event.*;

public class InnerClassDemo extends JFrame {
    JLabel statusLabel;

    public InnerClassDemo() {
        setTitle("Inner Class Demo");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        statusLabel = new JLabel("Status: ");
        add(statusLabel);

        addMouseListener(new MyMouseAdapter());

        setVisible(true);
    }

    class MyMouseAdapter extends MouseAdapter {
        public void mousePressed(MouseEvent me) {
            // Update the status label
            statusLabel.setText("Status: Mouse Pressed");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InnerClassDemo::new);
    }
}
