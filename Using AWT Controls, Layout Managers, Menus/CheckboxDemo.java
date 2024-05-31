import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckboxDemo extends JPanel implements ItemListener {
    String msg = "";
    JCheckBox winXP, winVista, solaris, mac;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Checkbox Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(250, 200);
            CheckboxDemo panel = new CheckboxDemo();
            frame.add(panel);
            frame.setVisible(true);
        });
    }

    public CheckboxDemo() {
        winXP = new JCheckBox("Windows XP", true);
        winVista = new JCheckBox("Windows Vista");
        solaris = new JCheckBox("Solaris");
        mac = new JCheckBox("Mac OS");

        winXP.addItemListener(this);
        winVista.addItemListener(this);
        solaris.addItemListener(this);
        mac.addItemListener(this);

        add(winXP);
        add(winVista);
        add(solaris);
        add(mac);
    }

    public void itemStateChanged(ItemEvent ie) {
        repaint();
    }

    // Display current state of the check boxes.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        msg = "Current state: ";
        g.drawString(msg, 6, 80);
        msg = " Windows XP: " + winXP.isSelected();
        g.drawString(msg, 6, 100);
        msg = " Windows Vista: " + winVista.isSelected();
        g.drawString(msg, 6, 120);
        msg = " Solaris: " + solaris.isSelected();
        g.drawString(msg, 6, 140);
        msg = " Mac OS: " + mac.isSelected();
        g.drawString(msg, 6, 160);
    }
}
