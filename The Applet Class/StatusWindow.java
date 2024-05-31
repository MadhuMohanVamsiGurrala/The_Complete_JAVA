import javax.swing.*;
import java.awt.*;

/*
<applet code="StatusWindow" width=300 height=50>
</applet>
*/

@SuppressWarnings("removal")
public class StatusWindow extends JApplet {
    public void init() {
        setBackground(Color.cyan);
    }

    // Display msg in applet window.
    public void paint(Graphics g) {
        g.drawString("This is in the applet window.", 10, 20);
        showStatus("This is shown in the status window.");
    }
}
