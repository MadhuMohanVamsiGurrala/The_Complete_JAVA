import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JButtonDemo extends JFrame implements ActionListener {
    JLabel jlab;

    public JButtonDemo() {
        setTitle("JButton Demo");
        setSize(250, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        makeGUI();
        setVisible(true);
    }

    private void makeGUI() {
        // Change to flow layout.
        setLayout(new FlowLayout());

        // Add buttons to content pane.
        ImageIcon france = new ImageIcon("france.gif");
        JButton jb = new JButton(france);
        jb.setActionCommand("France");
        jb.addActionListener(this);
        add(jb);

        ImageIcon germany = new ImageIcon("germany.gif");
        jb = new JButton(germany);
        jb.setActionCommand("Germany");
        jb.addActionListener(this);
        add(jb);

        ImageIcon italy = new ImageIcon("italy.gif");
        jb = new JButton(italy);
        jb.setActionCommand("Italy");
        jb.addActionListener(this);
        add(jb);

        ImageIcon japan = new ImageIcon("japan.gif");
        jb = new JButton(japan);
        jb.setActionCommand("Japan");
        jb.addActionListener(this);
        add(jb);

        // Create and add the label to content pane.
        jlab = new JLabel("Choose a Flag");
        add(jlab);
    }

    // Handle button events.
    public void actionPerformed(ActionEvent ae) {
        jlab.setText("You selected " + ae.getActionCommand());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JButtonDemo();
            }
        });
    }
}
