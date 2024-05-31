import javax.swing.*;
import java.awt.*;

public class GridLayoutDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("GridLayoutDemo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.setLayout(new GridLayout(4, 4));

            Font font = new Font("SansSerif", Font.BOLD, 24);

            for (int i = 1; i <= 16; i++) {
                JButton button = new JButton(String.valueOf(i));
                button.setFont(font);
                frame.add(button);
            }

            frame.setVisible(true);
        });
    }
}
