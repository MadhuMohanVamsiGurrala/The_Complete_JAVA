import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CardLayoutDemo {
    private JFrame frame;
    private JPanel osCards;
    private CardLayout cardLO;

    public CardLayoutDemo() {
        frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);

        JPanel buttonPanel = new JPanel();
        JButton windowsButton = new JButton("Windows");
        JButton otherButton = new JButton("Other");
        windowsButton.addActionListener(e -> showWindowsPanel());
        otherButton.addActionListener(e -> showOtherPanel());
        buttonPanel.add(windowsButton);
        buttonPanel.add(otherButton);

        osCards = new JPanel();
        cardLO = new CardLayout();
        osCards.setLayout(cardLO);

        JPanel windowsPanel = new JPanel();
        windowsPanel.add(new JCheckBox("Windows XP", true));
        windowsPanel.add(new JCheckBox("Windows Vista"));
        osCards.add(windowsPanel, "Windows");

        JPanel otherPanel = new JPanel();
        otherPanel.add(new JCheckBox("Solaris"));
        otherPanel.add(new JCheckBox("Mac OS"));
        osCards.add(otherPanel, "Other");

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(osCards, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void showWindowsPanel() {
        cardLO.show(osCards, "Windows");
    }

    private void showOtherPanel() {
        cardLO.show(osCards, "Other");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CardLayoutDemo::new);
    }
}
