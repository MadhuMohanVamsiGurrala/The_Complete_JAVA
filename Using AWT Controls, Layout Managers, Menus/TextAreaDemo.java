import javax.swing.*;
import java.awt.*;

public class TextAreaDemo extends JPanel {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("TextArea Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 250);
            TextAreaDemo panel = new TextAreaDemo();
            frame.add(panel);
            frame.setVisible(true);
        });
    }

    public TextAreaDemo() {
        String val =
            "Java SE 6 is the latest version of the most\n" +
            "widely-used computer language for Internet programming.\n" +
            "Building on a rich heritage, Java has advanced both\n" +
            "the art and science of computer language design.\n\n" +
            "One of the reasons for Java's ongoing success is its\n" +
            "constant, steady rate of evolution. Java has never stood\n" +
            "still. Instead, Java has consistently adapted to the\n" +
            "rapidly changing landscape of the networked world.\n" +
            "Moreover, Java has often led the way, charting the\n" +
            "course for others to follow.";
        JTextArea text = new JTextArea(val, 10, 30);
        add(new JScrollPane(text));
    }
}
