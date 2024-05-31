import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboBoxDemo extends JFrame {
    JLabel jlab;
    JComboBox<String> jcb;
    String flags[] = { "France", "Germany", "Italy", "Japan" };

    public JComboBoxDemo() {
        setTitle("JComboBox Demo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        makeGUI();
        setVisible(true);
    }

    private void makeGUI() {
        // Change to flow layout.
        setLayout(new FlowLayout());
        
        // Instantiate a combo box and add it to the content pane.
        jcb = new JComboBox<>(flags);
        add(jcb);
        
        // Handle selections.
        jcb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String s = (String) jcb.getSelectedItem();
                jlab.setIcon(new ImageIcon(s.toLowerCase() + ".gif"));
            }
        });
        
        // Create a label and add it to the content pane.
        jlab = new JLabel(new ImageIcon("france.gif"));
        add(jlab);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JComboBoxDemo();
            }
        });
    }
}
