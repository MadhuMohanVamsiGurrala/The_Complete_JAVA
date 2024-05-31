import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class DownloadManager extends JFrame {
    private JTextField urlField;
    private DownloadsTableModel tableModel;

    public DownloadManager() {
        setTitle("Download Manager");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DownloadsTableModel();
        JTable table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight((int) (new JProgressBar().getPreferredSize().getHeight()));

        JButton addButton = new JButton("Add Download");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addDownload();
            }
        });

        urlField = new JTextField(30);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("URL: "), BorderLayout.WEST);
        panel.add(urlField, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.EAST);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void addDownload() {
        try {
            URL url = new URL(urlField.getText());
            Download download = new Download(url);
            tableModel.addDownload(download);
            urlField.setText(""); // clear text field
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid URL", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DownloadManager().setVisible(true);
            }
        });
    }
}
