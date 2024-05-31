import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTextFieldDemo extends JFrame {
    JTextField jtf;

    public JTextFieldDemo() {
        setTitle("JTextField Demo");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        jtf = new JTextField(15);
        add(jtf);
        jtf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // Show text when user presses ENTER.
                System.out.println(jtf.getText());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JTextFieldDemo();
            }
        });
    }
}
