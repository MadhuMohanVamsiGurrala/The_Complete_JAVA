import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridBagDemo implements ItemListener {
    private JFrame frame;
    private JCheckBox winXP, winVista, solaris, mac;
    private JLabel label;

    public GridBagDemo() {
        frame = new JFrame("GridBagDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 4, 0, 0);

        winXP = new JCheckBox("Windows XP ", true);
        panel.add(winXP, gbc);

        winVista = new JCheckBox("Windows Vista");
        panel.add(winVista, gbc);

        solaris = new JCheckBox("Solaris");
        panel.add(solaris, gbc);

        mac = new JCheckBox("Mac OS");
        panel.add(mac, gbc);

        label = new JLabel("Current state: ");
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(label, gbc);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        winXP.addItemListener(this);
        winVista.addItemListener(this);
        solaris.addItemListener(this);
        mac.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e) {
        StringBuilder sb = new StringBuilder("Current state: ");
        if (winXP.isSelected()) sb.append("Windows XP ");
        if (winVista.isSelected()) sb.append("Windows Vista ");
        if (solaris.isSelected()) sb.append("Solaris ");
        if (mac.isSelected()) sb.append("Mac OS ");
        label.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GridBagDemo::new);
    }
}
