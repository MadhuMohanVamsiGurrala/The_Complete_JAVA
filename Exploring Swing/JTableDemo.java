import java.awt.*;
import javax.swing.*;

public class JTableDemo extends JFrame {
    public JTableDemo() {
        setTitle("JTable Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        makeGUI();
        setVisible(true);
    }

    private void makeGUI() {
        // Initialize column headings.
        String[] colHeads = { "Name", "Extension", "ID#" };
        // Initialize data.
        Object[][] data = {
            { "Gail", "4567", "865" },
            { "Ken", "7566", "555" },
            { "Viviane", "5634", "587" },
            { "Melanie", "7345", "922" },
            { "Anne", "1237", "333" },
            { "John", "5656", "314" },
            { "Matt", "5672", "217" },
            { "Claire", "6741", "444" },
            { "Erwin", "9023", "519" },
            { "Ellen", "1134", "532" },
            { "Jennifer", "5689", "112" },
            { "Ed", "9030", "133" },
            { "Helen", "6751", "145" }
        };
        // Create the table.
        JTable table = new JTable(data, colHeads);
        // Add the table to a scroll pane.
        JScrollPane jsp = new JScrollPane(table);
        // Add the scroll pane to the content pane.
        add(jsp);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JTableDemo();
            }
        });
    }
}
