import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class Annuity extends JFrame implements ActionListener {
    JTextField regWDText, initialText, periodText, rateText, numWDText;
    JButton doIt;
    double regWDAmount; // amount of each withdrawal
    double rateOfRet; // rate of return
    double numYears; // length of time in years
    int numPerYear; // number of withdrawals per year
    NumberFormat nf;

    public Annuity() {
        super("Initial Investment Needed for Regular Withdrawals");
        makeGUI();
    }

    // Set up and initialize the GUI.
    private void makeGUI() {
        // Use a grid bag layout.
        GridBagLayout gbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbag);

        JLabel heading = new JLabel("Initial Investment Needed for Regular Withdrawals");
        JLabel regWDLab = new JLabel("Desired Withdrawal ");
        JLabel periodLab = new JLabel("Years ");
        JLabel rateLab = new JLabel("Rate of Return ");
        JLabel numWDLab = new JLabel("Number of Withdrawals per Year ");
        JLabel initialLab = new JLabel("Initial Investment Required ");

        regWDText = new JTextField(10);
        periodText = new JTextField(10);
        initialText = new JTextField(10);
        rateText = new JTextField(10);
        numWDText = new JTextField(10);

        // Initial investment field for display only.
        initialText.setEditable(false);
        doIt = new JButton("Compute");

        // Define the grid bag.
        gbc.weighty = 1.0; // use a row weight of 1
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbag.setConstraints(heading, gbc);

        // Anchor most components to the right.
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbag.setConstraints(regWDLab, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbag.setConstraints(regWDText, gbc);
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbag.setConstraints(periodLab, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbag.setConstraints(periodText, gbc);
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbag.setConstraints(rateLab, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbag.setConstraints(rateText, gbc);
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbag.setConstraints(numWDLab, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbag.setConstraints(numWDText, gbc);
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbag.setConstraints(initialLab, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbag.setConstraints(initialText, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbag.setConstraints(doIt, gbc);

        // Add all the components.
        add(heading);
        add(regWDLab);
        add(regWDText);
        add(periodLab);
        add(periodText);
        add(rateLab);
        add(rateText);
        add(numWDLab);
        add(numWDText);
        add(initialLab);
        add(initialText);
        add(doIt);

        // Register to receive text field action events.
        regWDText.addActionListener(this);
        periodText.addActionListener(this);
        rateText.addActionListener(this);
        numWDText.addActionListener(this);
        doIt.addActionListener(this);

        // Create a number format.
        nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /* User pressed Enter on a text field or
    pressed Compute. Display the result if all
    fields are completed. */
    public void actionPerformed(ActionEvent ae) {
        double result = 0.0;
        String regWDStr = regWDText.getText();
        String periodStr = periodText.getText();
        String rateStr = rateText.getText();
        String numWDStr = numWDText.getText();
        try {
            if (regWDStr.length() != 0 && periodStr.length() != 0 && rateStr.length() != 0 && numWDStr.length() != 0) {
                regWDAmount = Double.parseDouble(regWDStr);
                numYears = Double.parseDouble(periodStr);
                rateOfRet = Double.parseDouble(rateStr) / 100;
                numPerYear = Integer.parseInt(numWDStr);
                result = compute();
                initialText.setText(nf.format(result));
            }
        } catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(this, "Invalid Data", "Error", JOptionPane.ERROR_MESSAGE);
            initialText.setText("");
        }
    }

    // Compute the required initial investment.
    double compute() {
        double b, e;
        double t1, t2;
        t1 = (regWDAmount * numPerYear) / rateOfRet;
        b = (1 + rateOfRet / numPerYear);
        e = numPerYear * numYears;
        t2 = 1 - (1 / Math.pow(b, e));
        return t1 * t2;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Annuity());
    }
}
