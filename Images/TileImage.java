import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TileImage extends JPanel {
    private BufferedImage img;
    private Image[] cell = new Image[4 * 4];
    private int iw, ih;
    private int tw, th;

    public TileImage(String imagePath) {
        try {
            img = ImageIO.read(getClass().getResource(imagePath));
            iw = img.getWidth();
            ih = img.getHeight();
            tw = iw / 4;
            th = ih / 4;

            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 4; x++) {
                    int i = y * 4 + x;
                    cell[i] = img.getSubimage(x * tw, y * th, tw, th);
                }
            }

            for (int i = 0; i < 32; i++) {
                int si = (int) (Math.random() * 16);
                int di = (int) (Math.random() * 16);
                Image tmp = cell[si];
                cell[si] = cell[di];
                cell[di] = tmp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                g.drawImage(cell[y * 4 + x], x * tw, y * th, this);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tile Image");
            TileImage tileImage = new TileImage("/picasso.jpg"); // Ensure the image is in the same directory as the class files
            frame.add(tileImage);
            frame.setSize(288, 399);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
