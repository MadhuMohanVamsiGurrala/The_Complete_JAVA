import java.applet.*;
import java.awt.*;

// Define the applet
public class FontInfo extends Applet {
    // Paint method to display font info
    public void paint(Graphics g) {
        // Get the current font
        Font f = g.getFont();

        // Extract font attributes
        String fontName = f.getName();
        String fontFamily = f.getFamily();
        int fontSize = f.getSize();
        int fontStyle = f.getStyle();

        // Construct the message to display font info
        String msg = "Family: " + fontName;
        msg += ", Font: " + fontFamily;
        msg += ", Size: " + fontSize + ", Style: ";

        // Check font style and add to the message
        if ((fontStyle & Font.BOLD) == Font.BOLD) {
            msg += "Bold ";
        }
        if ((fontStyle & Font.ITALIC) == Font.ITALIC) {
            msg += "Italic ";
        }
        if ((fontStyle & Font.PLAIN) == Font.PLAIN) {
            msg += "Plain ";
        }

        // Draw the message on the applet
        g.drawString(msg, 4, 16);
    }
}
