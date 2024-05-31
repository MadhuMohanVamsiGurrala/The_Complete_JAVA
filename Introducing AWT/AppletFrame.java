import javax.swing.*;
import java.awt.*;

public class AppletFrame extends JPanel {
    private JFrame frame;

    public void init() {
        frame = new JFrame("A Frame Window");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(250, 250);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString("This is in applet window", 10, 20);
            }
        };
        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }

    public void start() {
        frame.setVisible(true);
    }

    public void stop() {
        frame.setVisible(false);
    }
}
