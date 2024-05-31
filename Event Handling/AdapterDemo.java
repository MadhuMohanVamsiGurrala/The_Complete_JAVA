import javax.swing.*;
import java.awt.event.*;

public class AdapterDemo extends JFrame {
    public AdapterDemo() {
        setTitle("Adapter Demo");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add mouse adapter
        addMouseListener(new MyMouseAdapter());

        // Add mouse motion adapter
        addMouseMotionListener(new MyMouseMotionAdapter());

        setVisible(true);
    }

    public static void main(String[] args) {
        new AdapterDemo();
    }
}

class MyMouseAdapter extends MouseAdapter {
    // Handle mouse clicked
    public void mouseClicked(MouseEvent me) {
        System.out.println("Mouse clicked");
    }
}

class MyMouseMotionAdapter extends MouseMotionAdapter {
    // Handle mouse dragged
    public void mouseDragged(MouseEvent me) {
        System.out.println("Mouse dragged");
    }
}
