import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChoiceDemo extends JPanel implements ItemListener {
    JComboBox<String> os, browser;
    String msg = "";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Choice Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 180);
            ChoiceDemo panel = new ChoiceDemo();
            frame.add(panel);
            frame.setVisible(true);
        });
    }

    public ChoiceDemo() {
        os = new JComboBox<>();
        os.addItem("Windows XP");
        os.addItem("Windows Vista");
        os.addItem("Solaris");
        os.addItem("Mac OS");

        browser = new JComboBox<>();
        browser.addItem("Internet Explorer");
        browser.addItem("Firefox");
        browser.addItem("Opera");

        os.addItemListener(this);
        browser.addItemListener(this);

        setLayout(new FlowLayout());
        add(new JLabel("Operating System: "));
        add(os);
        add(new JLabel("Browser: "));
        add(browser);
    }

    public void itemStateChanged(ItemEvent ie) {
        repaint();
    }

    // Display current selections.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        msg = "Current OS: " + os.getSelectedItem();
        g.drawString(msg, 6, 120);
        msg = "Current Browser: " + browser.getSelectedItem();
        g.drawString(msg, 6, 140);
    }
}
