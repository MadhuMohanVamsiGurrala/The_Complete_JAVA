import javax.swing.*;
import java.awt.event.*;

public class MousePressedDemo extends JFrame {
    public MousePressedDemo() {
        setTitle("Mouse Pressed Demo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addMouseListener(new MyMouseAdapter());

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MousePressedDemo::new);
    }
}

class MyMouseAdapter extends MouseAdapter {
    public void mousePressed(MouseEvent me) {
        System.out.println("Mouse Pressed.");
    }
}
