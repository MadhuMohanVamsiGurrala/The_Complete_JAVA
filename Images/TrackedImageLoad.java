import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.StringTokenizer;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TrackedImageLoad extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;
    private int tracked;
    private int frame_rate = 5;
    private int current_img = 0;
    private Thread motor;
    private static final int MAXIMAGES = 10;
    private BufferedImage img[] = new BufferedImage[MAXIMAGES];
    private String name[] = new String[MAXIMAGES];
    private boolean stopFlag;

    public TrackedImageLoad() {
        StringTokenizer st = new StringTokenizer("vincent+leonardo+matisse+picasso+renoir+seurat+vermeer", "+");
        while (st.hasMoreTokens() && tracked <= MAXIMAGES) {
            name[tracked] = st.nextToken();
            try {
                img[tracked] = ImageIO.read(getClass().getResourceAsStream(name[tracked] + ".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            tracked++;
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        String loaded = "";
        int donecount = 0;
        for (int i = 0; i < tracked; i++) {
            if (img[i] != null) {
                donecount++;
                loaded += name[i] + " ";
            }
        }
        int w = getWidth();
        int h = getHeight();
        if (donecount == tracked) {
            frame_rate = 1;
            BufferedImage i = img[current_img++];
            int iw = i.getWidth();
            int ih = i.getHeight();
            g.drawImage(i, (w - iw) / 2, (h - ih) / 2, null);
            if (current_img >= tracked)
                current_img = 0;
        } else {
            int x = w * donecount / tracked;
            g.setColor(Color.black);
            g.fillRect(0, h / 3, x, 16);
            g.setColor(Color.white);
            g.fillRect(x, h / 3, w - x, 16);
            g.setColor(Color.black);
            g.drawString(loaded, 10, h / 2);
        }
    }

    public void start() {
        motor = new Thread(this);
        stopFlag = false;
        motor.start();
    }

    public void stop() {
        stopFlag = true;
    }

    public void run() {
        motor.setPriority(Thread.MIN_PRIORITY);
        while (true) {
            repaint();
            try {
                Thread.sleep(1000 / frame_rate);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                return;
            }
            if (stopFlag)
                return;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tracked Image Load");
            TrackedImageLoad trackedImageLoad = new TrackedImageLoad();
            frame.add(trackedImageLoad);
            frame.setSize(300, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            trackedImageLoad.start();
        });
    }
}
