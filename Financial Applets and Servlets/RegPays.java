import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.text.*;

public class RegPayS extends HttpServlet {
    private double principal; // original principal
    private double intRate; // interest rate
    private double numYears; // length of loan in years
    private final int payPerYear = 12; // Number of payments per year.
    private NumberFormat nf;

    @Override
    public void init() throws ServletException {
        nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String payStr = "";
        String amountStr = request.getParameter("amount");
        String periodStr = request.getParameter("period");
        String rateStr = request.getParameter("rate");

        try {
            if (amountStr != null && periodStr != null && rateStr != null) {
                principal = Double.parseDouble(amountStr);
                numYears = Double.parseDouble(periodStr);
                intRate = Double.parseDouble(rateStr) / 100;
                payStr = nf.format(compute());
            } else { // One or more parameters missing
                amountStr = "";
                periodStr = "";
                rateStr = "";
            }
        } catch (NumberFormatException exc) {
            amountStr = "";
            periodStr = "";
            rateStr = "";
            payStr = "Invalid input";
        }

        response.setContentType("text/html");
        try (PrintWriter pw = response.getWriter()) {
            pw.print("<html><body>");
            pw.print("<form name=\"Form1\" action=\"RegPayS\">");
            pw.print("<h2>Loan Payment Calculator</h2>");
            pw.print("<label for=\"amount\"><b>Enter amount to finance:</b></label>");
            pw.print("<input type=\"text\" name=\"amount\" size=\"12\" value=\"" + escapeHTML(amountStr) + "\"><br>");
            pw.print("<label for=\"period\"><b>Enter term in years:</b></label>");
            pw.print("<input type=\"text\" name=\"period\" size=\"12\" value=\"" + escapeHTML(periodStr) + "\"><br>");
            pw.print("<label for=\"rate\"><b>Enter interest rate:</b></label>");
            pw.print("<input type=\"text\" name=\"rate\" size=\"12\" value=\"" + escapeHTML(rateStr) + "\"><br>");
            pw.print("<label for=\"payment\"><b>Monthly Payment:</b></label>");
            pw.print("<input type=\"text\" name=\"payment\" size=\"12\" value=\"" + escapeHTML(payStr) + "\" readonly><br>");
            pw.print("<input type=\"submit\" value=\"Submit\">");
            pw.print("</form>");
            pw.print("</body></html>");
        }
    }

    // Compute the loan payment.
    private double compute() {
        double numer = intRate * principal / payPerYear;
        double e = -(payPerYear * numYears);
        double b = (intRate / payPerYear) + 1.0;
        double denom = 1.0 - Math.pow(b, e);
        return numer / denom;
    }

    // Utility method to escape HTML characters
    private String escapeHTML(String input) {
        if (input == null) {
            return "";
        }
        return input.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#x27;")
                    .replace("/", "&#x2F;");
    }
}
