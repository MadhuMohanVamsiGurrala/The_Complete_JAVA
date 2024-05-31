import java.awt.*;
import java.applet.*;

/*
<applet code="Sample" width=300 height=50>
</applet>
*/

@SuppressWarnings("removal")
public class Sample extends Applet {
    String msg;

    // Set the foreground and background colors
    public void init() {
        setBackground(Color.cyan);
        setForeground(Color.red);
        msg = "Inside init() --";
        System.out.println(msg);
    }

    // Initialize the string to be displayed
    public void start() {
        msg += " Inside start() --";
        System.out.println(msg);
    }

    // Display msg in applet window
    public void paint(Graphics g) {
        msg += " Inside paint().";
        g.drawString(msg, 10, 30);
        System.out.println(msg);
    }
}
