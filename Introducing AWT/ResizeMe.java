import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResizeMe extends JPanel {
    final int inc = 25;
    int max = 500;
    int min = 200;
    Dimension d;

    public ResizeMe() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent me) {
                int w = (d.width + inc) > max ? min : (d.width + inc);
                int h = (d.height + inc) > max ? min : (d.height + inc);
                setPreferredSize(new Dimension(w, h));
                revalidate();
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        d = getSize();
        g.drawLine(0, 0, d.width - 1, d.height - 1);
        g.drawLine(0, d.height - 1, d.width - 1, 0);
        g.drawRect(0, 0, d.width - 1, d.height - 1);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("ResizeMe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ResizeMe panel = new ResizeMe();
        frame.add(panel);
        frame.pack();
        frame.setSize(new Dimension(200, 200));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ResizeMe::createAndShowGUI);
    }
}
