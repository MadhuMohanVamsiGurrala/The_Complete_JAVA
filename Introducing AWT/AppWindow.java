import java.awt.*;
import java.awt.event.*;

public class AppWindow extends Frame {
    String keymsg = "This is a test.";
    String mousemsg = "";
    int mouseX = 30, mouseY = 30;

    public AppWindow() {
        // Register listeners for key, mouse, and window events
        addKeyListener(new MyKeyAdapter(this));
        addMouseListener(new MyMouseAdapter(this));
        addWindowListener(new MyWindowAdapter());
    }

    @Override
    public void paint(Graphics g) {
        // Draw key and mouse messages
        g.drawString(keymsg, 10, 40);
        g.drawString(mousemsg, mouseX, mouseY);
    }

    // Create the window.
    public static void main(String[] args) {
        AppWindow appwin = new AppWindow();
        appwin.setSize(new Dimension(300, 200));
        appwin.setTitle("An AWT-Based Application");
        appwin.setVisible(true);
    }
}

class MyKeyAdapter extends KeyAdapter {
    AppWindow appWindow;

    public MyKeyAdapter(AppWindow appWindow) {
        this.appWindow = appWindow;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        // Append the typed character to the key message and repaint
        appWindow.keymsg += ke.getKeyChar();
        appWindow.repaint();
    }
}

class MyMouseAdapter extends MouseAdapter {
    AppWindow appWindow;

    public MyMouseAdapter(AppWindow appWindow) {
        this.appWindow = appWindow;
    }

    @Override
    public void mousePressed(MouseEvent me) {
        // Update mouse coordinates and message, then repaint
        appWindow.mouseX = me.getX();
        appWindow.mouseY = me.getY();
        appWindow.mousemsg = "Mouse Down at " + appWindow.mouseX + ", " + appWindow.mouseY;
        appWindow.repaint();
    }
}

class MyWindowAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent we) {
        // Exit the application when the window is closed
        System.exit(0);
    }
}
