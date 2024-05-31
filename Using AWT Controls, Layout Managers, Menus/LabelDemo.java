import javax.swing.*;

public class LabelDemo extends JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Label Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        LabelDemo panel = new LabelDemo();
        frame.add(panel);
        frame.setVisible(true);
    }

    public LabelDemo() {
        JLabel one = new JLabel("One");
        JLabel two = new JLabel("Two");
        JLabel three = new JLabel("Three");
        // Add labels to the panel
        add(one);
        add(two);
        add(three);
    }
}
