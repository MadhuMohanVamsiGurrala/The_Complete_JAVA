import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("BorderLayoutDemo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLayout(new BorderLayout());
            
            frame.add(new JButton("This is across the top."), BorderLayout.NORTH);
            frame.add(new JLabel("The footer message might go here."), BorderLayout.SOUTH);
            frame.add(new JButton("Right"), BorderLayout.EAST);
            frame.add(new JButton("Left"), BorderLayout.WEST);

            String msg = "The reasonable man adapts himself to the world;\n" +
                    "the unreasonable one persists in trying to adapt the world to himself.\n" +
                    "Therefore all progress depends on the unreasonable man.\n\n" +
                    " - George Bernard Shaw\n\n";
            frame.add(new JTextArea(msg), BorderLayout.CENTER);
            
            frame.setVisible(true);
        });
    }
}
