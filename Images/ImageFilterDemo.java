import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;

public class ImageFilterDemo extends JPanel implements ActionListener {
    private BufferedImage img;
    private PlugInFilter pif;
    private BufferedImage fimg;
    private LoadedImage lim;
    private JLabel lab;
    private JButton reset;

    public ImageFilterDemo(String imgPath, String filters) {
        setLayout(new BorderLayout());

        JPanel p = new JPanel();
        add(p, BorderLayout.SOUTH);

        reset = new JButton("Reset");
        reset.addActionListener(this);
        p.add(reset);

        StringTokenizer st = new StringTokenizer(filters, "+");
        while (st.hasMoreTokens()) {
            JButton b = new JButton(st.nextToken());
            b.addActionListener(this);
            p.add(b);
        }

        lab = new JLabel("");
        add(lab, BorderLayout.NORTH);

        try {
            img = ImageIO.read(getClass().getResource(imgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        lim = new LoadedImage(img);
        add(lim, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String a = ae.getActionCommand();
        try {
            if (a.equals("Reset")) {
                lim.set(img);
                lab.setText("Normal");
            } else {
                pif = (PlugInFilter) Class.forName(a).getDeclaredConstructor().newInstance();
                fimg = pif.filter(this, img);
                lim.set(fimg);
                lab.setText("Filtered: " + a);
            }
            repaint();
        } catch (ClassNotFoundException e) {
            lab.setText(a + " not found");
            lim.set(img);
            repaint();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            lab.setText("Error: " + a);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Image Filter Demo");
            ImageFilterDemo demo = new ImageFilterDemo("/vincent.jpg", "Grayscale+Invert+Contrast+Blur+Sharpen");
            frame.add(demo);
            frame.setSize(350, 450);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

interface PlugInFilter {
    BufferedImage filter(Component c, BufferedImage img);
}

class LoadedImage extends JPanel {
    private BufferedImage img;

    LoadedImage(BufferedImage img) {
        this.img = img;
    }

    void set(BufferedImage img) {
        this.img = img;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, this);
        }
    }
}

class Grayscale implements PlugInFilter {
    @Override
    public BufferedImage filter(Component c, BufferedImage img) {
        BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                int rgb = img.getRGB(x, y);
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                int gray = (r + g + b) / 3;
                int newPixel = (0xff << 24) | (gray << 16) | (gray << 8) | gray;
                result.setRGB(x, y, newPixel);
            }
        }
        return result;
    }
}
