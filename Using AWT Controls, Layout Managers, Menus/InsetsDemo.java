import javax.swing.*;
import java.awt.*;

public class InsetsDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("InsetsDemo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLayout(new BorderLayout());

            JPanel contentPane = new JPanel(new BorderLayout()) {
                @Override
                public Insets getInsets() {
                    return new Insets(10, 10, 10, 10);
                }
            };

            frame.add(contentPane);

            contentPane.add(new JButton("This is across the top."), BorderLayout.NORTH);
            contentPane.add(new JLabel("The footer message might go here."), BorderLayout.SOUTH);
            contentPane.add(new JButton("Right"), BorderLayout.EAST);
            contentPane.add(new JButton("Left"), BorderLayout.WEST);

            String msg = "The reasonable man adapts himself to the world;\n" +
                    "the unreasonable one persists in trying to adapt the world to himself.\n" +
                    "Therefore all progress depends on the unreasonable man.\n\n" +
                    " - George Bernard Shaw\n\n";
            contentPane.add(new JTextArea(msg), BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}
