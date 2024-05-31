import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFieldDemo extends JPanel implements ActionListener {
    JTextField name, pass;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("TextField Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(380, 150);
            TextFieldDemo panel = new TextFieldDemo();
            frame.add(panel);
            frame.setVisible(true);
        });
    }

    public TextFieldDemo() {
        JLabel namep = new JLabel("Name: ", JLabel.RIGHT);
        JLabel passp = new JLabel("Password: ", JLabel.RIGHT);
        name = new JTextField(12);
        pass = new JTextField(8);
        add(namep);
        add(name);
        add(passp);
        add(pass);

        name.addActionListener(this);
        pass.addActionListener(this);
    }

    // User pressed Enter.
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Name: " + name.getText(), 6, 60);
        g.drawString("Selected text in name: " + name.getSelectedText(), 6, 80);
        g.drawString("Password: " + pass.getText(), 6, 100);
    }
}
