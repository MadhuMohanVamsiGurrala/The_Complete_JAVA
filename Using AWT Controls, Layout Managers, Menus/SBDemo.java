import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SBDemo extends JPanel implements AdjustmentListener, MouseMotionListener {
    String msg = "";
    JScrollBar vertSB, horzSB;
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Scrollbar Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(WIDTH, HEIGHT);
            SBDemo panel = new SBDemo();
            frame.add(panel);
            frame.setVisible(true);
        });
    }

    public SBDemo() {
        vertSB = new JScrollBar(JScrollBar.VERTICAL, 0, 1, 0, HEIGHT);
        horzSB = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, WIDTH);

        vertSB.addAdjustmentListener(this);
        horzSB.addAdjustmentListener(this);
        addMouseMotionListener(this);

        setLayout(new BorderLayout());
        add(vertSB, BorderLayout.EAST);
        add(horzSB, BorderLayout.SOUTH);
    }

    public void adjustmentValueChanged(AdjustmentEvent ae) {
        repaint();
    }

    // Update scroll bars to reflect mouse dragging.
    public void mouseDragged(MouseEvent me) {
        int x = me.getX();
        int y = me.getY();
        vertSB.setValue(y);
        horzSB.setValue(x);
        repaint();
    }

    // Necessary for MouseMotionListener
    public void mouseMoved(MouseEvent me) {
    }

    // Display current value of scroll bars.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        msg = "Vertical: " + vertSB.getValue();
        msg += ", Horizontal: " + horzSB.getValue();
        g.drawString(msg, 6, 160);
        // show current mouse drag position
        g.drawString("*", horzSB.getValue(), vertSB.getValue());
    }
}
