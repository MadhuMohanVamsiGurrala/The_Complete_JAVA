import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonDemo extends JPanel implements ActionListener {
    String msg = "";
    JButton yes, no, maybe;

    public ButtonDemo() {
        yes = new JButton("Yes");
        no = new JButton("No");
        maybe = new JButton("Undecided");
        add(yes);
        add(no);
        add(maybe);
        yes.addActionListener(this);
        no.addActionListener(this);
        maybe.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        if (str.equals("Yes")) {
            msg = "You pressed Yes.";
        } else if (str.equals("No")) {
            msg = "You pressed No.";
        } else {
            msg = "You pressed Undecided.";
        }
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(msg, 6, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ButtonDemo demo = new ButtonDemo();
        frame.add(demo);
        frame.setSize(250, 150);
        frame.setVisible(true);
    }
}
