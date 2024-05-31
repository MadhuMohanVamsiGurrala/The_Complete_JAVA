import java.awt.*;
import javax.swing.*;

public class ColorsTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Colors Bean Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        Colors colorsBean = new Colors();
        frame.add(colorsBean, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        JButton toggleButton = new JButton("Toggle Shape");
        toggleButton.addActionListener(e -> colorsBean.setRectangular(!colorsBean.isRectangular()));
        controlPanel.add(toggleButton);

        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}