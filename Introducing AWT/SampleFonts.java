import java.applet.*;
import java.awt.*;
import java.awt.event.*;

// Define the applet
public class SampleFonts extends Applet {
    int next = 0;
    Font f;
    String msg;

    // Initialize the applet
    public void init() {
        f = new Font("Dialog", Font.PLAIN, 12);
        msg = "Dialog";
        setFont(f);
        addMouseListener(new MyMouseAdapter(this));
    }

    // Paint method to display text
    public void paint(Graphics g) {
        g.drawString(msg, 4, 20);
    }

    // Inner class to handle mouse events
    class MyMouseAdapter extends MouseAdapter {
        SampleFonts sampleFonts;

        // Constructor
        public MyMouseAdapter(SampleFonts sampleFonts) {
            this.sampleFonts = sampleFonts;
        }

        // Handle mouse click events
        public void mousePressed(MouseEvent me) {
            // Switch fonts with each mouse click
            sampleFonts.next++;
            switch(sampleFonts.next) {
                case 0:
                    sampleFonts.f = new Font("Dialog", Font.PLAIN, 12);
                    sampleFonts.msg = "Dialog";
                    break;
                case 1:
                    sampleFonts.f = new Font("DialogInput", Font.PLAIN, 12);
                    sampleFonts.msg = "DialogInput";
                    break;
                case 2:
                    sampleFonts.f = new Font("SansSerif", Font.PLAIN, 12);
                    sampleFonts.msg = "SansSerif";
                    break;
                case 3:
                    sampleFonts.f = new Font("Serif", Font.PLAIN, 12);
                    sampleFonts.msg = "Serif";
                    break;
                case 4:
                    sampleFonts.f = new Font("Monospaced", Font.PLAIN, 12);
                    sampleFonts.msg = "Monospaced";
                    break;
            }
            // Reset next to loop back to the first font
            if(sampleFonts.next == 4) {
                sampleFonts.next = -1;
            }
            // Set the font and repaint the applet
            sampleFonts.setFont(sampleFonts.f);
            sampleFonts.repaint();
        }
    }
}
