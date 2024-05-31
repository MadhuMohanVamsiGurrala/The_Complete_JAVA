import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonList extends JPanel implements ActionListener {
    String msg = "";
    JButton[] bList = new JButton[3];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Button List");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(250, 150);
            ButtonList panel = new ButtonList();
            frame.add(panel);
            frame.setVisible(true);
        });
    }

    public ButtonList() {
        JButton yes = new JButton("Yes");
        JButton no = new JButton("No");
        JButton maybe = new JButton("Undecided");

        // Store references to buttons as added
        bList[0] = yes;
        bList[1] = no;
        bList[2] = maybe;

        // Register to receive action events
        for (JButton button : bList) {
            button.addActionListener(this);
            add(button);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < 3; i++) {
            if (ae.getSource() == bList[i]) {
                msg = "You pressed " + bList[i].getText();
            }
        }
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(msg, 6, 100);
    }
}
