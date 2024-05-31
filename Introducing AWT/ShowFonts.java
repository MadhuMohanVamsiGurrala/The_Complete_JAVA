import java.applet.*;
import java.awt.*;

// Define the applet
public class ShowFonts extends Applet {
    // Paint method to display fonts
    public void paint(Graphics g) {
        // Initialize an empty string to store font names
        String msg = "";
        
        // Get the local graphics environment to access font information
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        // Get the list of available font family names
        String[] fontList = ge.getAvailableFontFamilyNames();
        
        // Concatenate all font names into the message string
        for(int i = 0; i < fontList.length; i++) {
            msg += fontList[i] + " ";
        }
        
        // Display the message string with font names
        g.drawString(msg, 4, 16);
    }
}
