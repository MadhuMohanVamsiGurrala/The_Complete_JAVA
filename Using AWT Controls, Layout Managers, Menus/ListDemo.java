import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListDemo extends JPanel implements ActionListener {
    JList<String> os, browser;
    String msg = "";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("List Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 180);
            ListDemo panel = new ListDemo();
            frame.add(panel);
            frame.setVisible(true);
        });
    }

    public ListDemo() {
        String[] osItems = {"Windows XP", "Windows Vista", "Solaris", "Mac OS"};
        String[] browserItems = {"Internet Explorer", "Firefox", "Opera"};

        os = new JList<>(osItems);
        browser = new JList<>(browserItems);
        browser.setSelectedIndex(1); // Select "Firefox" by default

        os.addListSelectionListener(e -> repaint());
        browser.addListSelectionListener(e -> repaint());

        setLayout(new GridLayout(2, 1));
        add(new JScrollPane(os));
        add(new JScrollPane(browser));
    }

    public void actionPerformed(ActionEvent ae) {
        repaint();
    }

    // Display current selections.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[] osIndices = os.getSelectedIndices();
        msg = "Current OS: ";
        for (int i : osIndices) {
            msg += os.getModel().getElementAt(i) + " ";
        }
        g.drawString(msg, 6, 120);
        msg = "Current Browser: " + browser.getSelectedValue();
        g.drawString(msg, 6, 140);
    }
}
