import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlowLayoutDemo extends JPanel implements ItemListener {
    String msg = "";
    JCheckBox winXP, winVista, solaris, mac;

    public FlowLayoutDemo() {
        // set left-aligned flow layout
        setLayout(new FlowLayout(FlowLayout.LEFT));

        winXP = new JCheckBox("Windows XP", true);
        winVista = new JCheckBox("Windows Vista");
        solaris = new JCheckBox("Solaris");
        mac = new JCheckBox("Mac OS");

        add(winXP);
        add(winVista);
        add(solaris);
        add(mac);

        // register to receive item events
        winXP.addItemListener(this);
        winVista.addItemListener(this);
        solaris.addItemListener(this);
        mac.addItemListener(this);
    }

    // Repaint when status of a check box changes.
    public void itemStateChanged(ItemEvent ie) {
        repaint();
    }

    // Display current state of the check boxes.
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        msg = "Current state: ";
        g.drawString(msg, 6, 80);
        msg = " Windows XP: " + winXP.isSelected();
        g.drawString(msg, 6, 100);
        msg = " Windows Vista: " + winVista.isSelected();
        g.drawString(msg, 6, 120);
        msg = " Solaris: " + solaris.isSelected();
        g.drawString(msg, 6, 140);
        msg = " Mac: " + mac.isSelected();
        g.drawString(msg, 6, 160);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayoutDemo");
        FlowLayoutDemo panel = new FlowLayoutDemo();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
