import java.awt.*;
import javax.swing.*;

/*
<applet code="SimpleBanner" width=300 height=50>
</applet>
*/

@SuppressWarnings("removal")
public class SimpleBanner extends JApplet {
    String msg = " A Simple Moving Banner.";
    int index = 0;
    Timer timer;

    // Set colors and initialize timer.
    public void init() {
        setBackground(Color.cyan);
        setForeground(Color.red);
        timer = new Timer(250, e -> {
            char ch = msg.charAt(0);
            msg = msg.substring(1) + ch;
            repaint();
        });
    }

    // Start timer
    public void start() {
        timer.start();
    }

    // Pause the banner.
    public void stop() {
        timer.stop();
    }

    // Display the banner.
    public void paint(Graphics g) {
        g.drawString(msg, 50, 30);
    }
}
