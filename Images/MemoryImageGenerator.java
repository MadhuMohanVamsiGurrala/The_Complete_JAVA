import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class MemoryImageGenerator extends JPanel {
    private BufferedImage img;

    public MemoryImageGenerator() {
        int w = 256;
        int h = 256;
        int[] pixels = new int[w * h];
        int i = 0;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int r = (x ^ y) & 0xff;
                int g = (x * 2 ^ y * 2) & 0xff;
                int b = (x * 4 ^ y * 4) & 0xff;
                pixels[i++] = (255 << 24) | (r << 16) | (g << 8) | b;
            }
        }
        img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        img.setRGB(0, 0, w, h, pixels, 0, w);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Memory Image Generator");
            MemoryImageGenerator panel = new MemoryImageGenerator();
            frame.add(panel);
            frame.setSize(256, 256);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
