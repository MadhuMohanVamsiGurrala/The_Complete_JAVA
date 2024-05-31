import java.awt.*;
import java.applet.*;

/*
<applet code="AppletSkel" width=300 height=100>
</applet>
*/

@SuppressWarnings("removal")  // Suppress the deprecation warning
public class AppletSkel extends Applet {
    // Called first
    public void init() {
        // Initialization code
        System.out.println("Applet initialized.");
    }

    /* Called second, after init(). Also called whenever
       the applet is restarted. */
    public void start() {
        // Start or resume execution
        System.out.println("Applet started.");
    }

    // Called when the applet is stopped
    public void stop() {
        // Suspend execution
        System.out.println("Applet stopped.");
    }

    /* Called when applet is terminated. This is the last
       method executed. */
    public void destroy() {
        // Perform shutdown activities
        System.out.println("Applet destroyed.");
    }

    // Called when an applet's window must be restored
    public void paint(Graphics g) {
        // Redisplay contents of window
        g.drawString("Hello, Applet!", 20, 20);
    }
}
