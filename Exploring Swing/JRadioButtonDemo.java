import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JRadioButtonDemo extends JFrame implements ActionListener {
    JLabel jlab;

    public JRadioButtonDemo() {
        setTitle("JRadioButton Demo");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        makeGUI();
        setVisible(true);
    }

    private void makeGUI() {
        // Change to flow layout.
        setLayout(new FlowLayout());

        // Create radio buttons and add them to the content pane.
        JRadioButton b1 = new JRadioButton("A");
        b1.addActionListener(this);
        add(b1);

        JRadioButton b2 = new JRadioButton("B");
        b2.addActionListener(this);
        add(b2);

        JRadioButton b3 = new JRadioButton("C");
        b3.addActionListener(this);
        add(b3);

        // Define a button group.
        ButtonGroup bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);

        // Create a label and add it to the content pane.
        jlab = new JLabel("Select One");
        add(jlab);
    }

    // Handle button selection.
    public void actionPerformed(ActionEvent ae) {
        jlab.setText("You selected " + ae.getActionCommand());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JRadioButtonDemo();
            }
        });
    }
}
