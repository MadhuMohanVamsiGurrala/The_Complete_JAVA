import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MySwingApplet extends JPanel {
    JButton jbtnAlpha;
    JButton jbtnBeta;
    JLabel jlab;

    // Initialize the applet.
    public MySwingApplet() {
        makeGUI(); // initialize the GUI
    }

    // Set up and initialize the GUI.
    private void makeGUI() {
        // Set the panel to use flow layout.
        setLayout(new FlowLayout());

        // Make two buttons.
        jbtnAlpha = new JButton("Alpha");
        jbtnBeta = new JButton("Beta");

        // Add action listener for Alpha.
        jbtnAlpha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent le) {
                jlab.setText("Alpha was pressed.");
            }
        });

        // Add action listener for Beta.
        jbtnBeta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent le) {
                jlab.setText("Beta was pressed.");
            }
        });

        // Add the buttons to the panel.
        add(jbtnAlpha);
        add(jbtnBeta);

        // Create a text-based label.
        jlab = new JLabel("Press a button.");

        // Add the label to the panel.
        add(jlab);
    }

    // Create a JFrame to display the applet
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("My Swing Applet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MySwingApplet applet = new MySwingApplet();
        frame.getContentPane().add(applet);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
