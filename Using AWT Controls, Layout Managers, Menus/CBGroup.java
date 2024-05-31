import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CBGroup extends JPanel implements ItemListener {
    String msg = "";
    JRadioButton winXP, winVista, solaris, mac;
    ButtonGroup group;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Checkbox Group Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(250, 200);
            CBGroup panel = new CBGroup();
            frame.add(panel);
            frame.setVisible(true);
        });
    }

    public CBGroup() {
        group = new ButtonGroup();

        winXP = new JRadioButton("Windows XP", true);
        winVista = new JRadioButton("Windows Vista");
        solaris = new JRadioButton("Solaris");
        mac = new JRadioButton("Mac OS");

        group.add(winXP);
        group.add(winVista);
        group.add(solaris);
        group.add(mac);

        winXP.addItemListener(this);
        winVista.addItemListener(this);
        solaris.addItemListener(this);
        mac.addItemListener(this);

        setLayout(new GridLayout(4, 1));
        add(winXP);
        add(winVista);
        add(solaris);
        add(mac);
    }

    public void itemStateChanged(ItemEvent ie) {
        repaint();
    }

    // Display current state of the radio buttons.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        msg = "Current selection: " + group.getSelection().getActionCommand();
        g.drawString(msg, 6, 100);
    }
}