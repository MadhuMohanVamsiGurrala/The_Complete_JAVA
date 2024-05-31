import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class RegPay extends JPanel implements ActionListener {
    JTextField amountText, paymentText, periodText, rateText;
    JButton doIt;
    double principal;
    double intRate;
    double numYears;
    final int payPerYear = 12;
    NumberFormat nf;

    public RegPay() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        JLabel heading = new JLabel("Compute Monthly Loan Payments");
        add(heading, gbc);

        JLabel amountLab = new JLabel("Principal ");
        amountText = new JTextField(10);
        add(amountLab);
        add(amountText, gbc);

        JLabel periodLab = new JLabel("Years ");
        periodText = new JTextField(10);
        add(periodLab);
        add(periodText, gbc);

        JLabel rateLab = new JLabel("Interest Rate ");
        rateText = new JTextField(10);
        add(rateLab);
        add(rateText, gbc);

        JLabel paymentLab = new JLabel("Monthly Payments ");
        paymentText = new JTextField(10);
        paymentText.setEditable(false);
        add(paymentLab);
        add(paymentText, gbc);

        doIt = new JButton("Compute");
        add(doIt, gbc);

        nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);

        amountText.addActionListener(this);
        periodText.addActionListener(this);
        rateText.addActionListener(this);
        doIt.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        double result = 0.0;
        String amountStr = amountText.getText();
        String periodStr = periodText.getText();
        String rateStr = rateText.getText();
        try {
            if (amountStr.length() != 0 && periodStr.length() != 0 && rateStr.length() != 0) {
                principal = Double.parseDouble(amountStr);
                numYears = Double.parseDouble(periodStr);
                intRate = Double.parseDouble(rateStr) / 100;
                result = compute();
                paymentText.setText(nf.format(result));
            }
        } catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog(this, "Invalid Data", "Error", JOptionPane.ERROR_MESSAGE);
            paymentText.setText("");
        }
    }

    double compute() {
        double numer;
        double denom;
        double b, e;
        numer = intRate * principal / payPerYear;
        e = -(payPerYear * numYears);
        b = (intRate / payPerYear) + 1.0;
        denom = 1.0 - Math.pow(b, e);
        return numer / denom;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("RegPay");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new RegPay());
            frame.pack();
            frame.setVisible(true);
        });
    }
}
