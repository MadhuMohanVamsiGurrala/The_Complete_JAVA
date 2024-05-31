import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.util.*;

public class Animation extends JPanel implements Runnable {
    private static final int MAXSEQ = 64;

    private Image[] cell;
    private int[] sequence;
    private int nseq;
    private int idx;
    private int framerate;
    private boolean stopFlag;

    private int intDef(String s, int def) {
        int n = def;
        if (s != null) {
            try {
                n = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Number Format Exception");
            }
        }
        return n;
    }

    public void init() {
        framerate = 5; // Default framerate
        int tilex = 1; // Default tilex
        int tiley = 1; // Default tiley

        // Default sequence
        sequence = new int[] { 0 };

        // No need to initialize cell[], we'll load images dynamically

        // Attempt to load the images
try {
    Image img = ImageIO.read(getClass().getResource("E:\\Fullstack Accelerator\\The Complete JAVA\\Images\\matisse.jpg")); // Replace "/path/to/your/image.jpg" with the actual path
    int iw = img.getWidth(null);
    int ih = img.getHeight(null);
    int tw = iw / tilex;
    int th = ih / tiley;
    CropImageFilter f;
    FilteredImageSource fis;
    ArrayList<Image> cellList = new ArrayList<>();
    for (int y = 0; y < tiley; y++) {
        for (int x = 0; x < tilex; x++) {
            f = new CropImageFilter(tw * x, th * y, tw, th);
            fis = new FilteredImageSource(img.getSource(), f);
            cellList.add(createImage(fis));
        }
    }
    cell = cellList.toArray(new Image[0]);
} catch (Exception e) {
    System.out.println("Image Load Interrupted: " + e.getMessage());
}
    }
    public void update(Graphics g) { }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (idx < nseq) {
            g.drawImage(cell[sequence[idx]], 0, 0, this);
        }
    }

    private Thread animationThread;

    public void start() {
        animationThread = new Thread(this);
        stopFlag = false;
        animationThread.start();
    }

    public void stop() {
        stopFlag = true;
    }

    public void run() {
        idx = 0;
        while (true) {
            repaint();
            idx = (idx + 1) % nseq;
            try {
                Thread.sleep(1000 / framerate);
            } catch (InterruptedException e) {
                System.out.println("Animation Interrupted");
                return;
            }
            if (stopFlag) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Animation");
            Animation animation = new Animation();
            animation.init();
            frame.add(animation);
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            animation.start();
        });
    }
}
