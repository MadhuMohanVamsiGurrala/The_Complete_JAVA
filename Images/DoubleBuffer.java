import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DoubleBuffer extends JPanel {
    private static final long serialVersionUID = 1L;
    private int gap = 3;
    private int mx, my;
    private boolean flicker = true;
    private int w, h;

    public DoubleBuffer() {
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent me) {
                mx = me.getX();
                my = me.getY();
                flicker = false;
                repaint();
            }

            public void mouseMoved(MouseEvent me) {
                mx = me.getX();
                my = me.getY();
                flicker = true;
                repaint();
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (flicker) {
            g.setColor(Color.blue);
            g.fillRect(0, 0, w, h);
            g.setColor(Color.red);
            for (int i = 0; i < w; i += gap)
                g.drawLine(i, 0, w - i, h);
            for (int i = 0; i < h; i += gap)
                g.drawLine(0, i, w, h - i);
            g.setColor(Color.black);
            g.drawString("Press mouse button to double buffer", 10, h / 2);
            g.setColor(Color.yellow);
            g.fillOval(mx - gap, my - gap, gap * 2 + 1, gap * 2 + 1);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Double Buffer");
            DoubleBuffer doubleBuffer = new DoubleBuffer();
            frame.add(doubleBuffer);
            frame.setSize(250, 250);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
