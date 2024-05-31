import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class HistoGrab extends JPanel {
    private BufferedImage img;
    private int iw, ih;
    private int[] pixels;
    private int[] hist = new int[256];
    private int max_hist = 0;

    public HistoGrab(String imagePath) {
        try {
            img = ImageIO.read(getClass().getResource(imagePath));
            iw = img.getWidth();
            ih = img.getHeight();
            pixels = new int[iw * ih];
            img.getRGB(0, 0, iw, ih, pixels, 0, iw);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < iw * ih; i++) {
            int p = pixels[i];
            int r = 0xff & (p >> 16);
            int g = 0xff & (p >> 8);
            int b = 0xff & p;
            int y = (int) (.33 * r + .56 * g + .11 * b);
            hist[y]++;
        }

        for (int i = 0; i < 256; i++) {
            if (hist[i] > max_hist) {
                max_hist = hist[i];
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        g.drawImage(img, 0, 0, null);

        int x = (w - 256) / 2;
        int lasty = h - h * hist[0] / max_hist;
        for (int i = 0; i < 256; i++, x++) {
            int y = h - h * hist[i] / max_hist;
            g.setColor(new Color(i, i, i));
            g.fillRect(x, y, 1, h);
            g.setColor(Color.red);
            g.drawLine(x - 1, lasty, x, y);
            lasty = y;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("HistoGrab");
            HistoGrab histoGrab = new HistoGrab("/vermeer.jpg");  // Ensure the image is in the same directory as the class files
            frame.add(histoGrab);
            frame.setSize(341, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
