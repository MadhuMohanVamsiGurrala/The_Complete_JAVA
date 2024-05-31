import java.awt.*;
import javax.swing.*;

public class JScrollPaneDemo extends JFrame {
    public JScrollPaneDemo() {
        setTitle("JScrollPane Demo");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        makeGUI();
        setVisible(true);
    }

    private void makeGUI() {
        // Add 400 buttons to a panel.
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(20, 20));
        int b = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                jp.add(new JButton("Button " + b));
                ++b;
            }
        }

        // Create the scroll pane.
        JScrollPane jsp = new JScrollPane(jp);

        // Add the scroll pane to the content pane.
        // Because the default border layout is used,
        // the scroll pane will be added to the center.
        add(jsp, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JScrollPaneDemo();
            }
        });
    }
}
