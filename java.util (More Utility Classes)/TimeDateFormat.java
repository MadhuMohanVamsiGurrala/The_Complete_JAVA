// Formatting time and date.
import java.util.*;
class TimeDateFormat {
public static void main(String args[]) {
Formatter fmt = new Formatter();
Calendar cal = Calendar.getInstance();
// Display standard 12-hour time format.
fmt.format("%tr", cal);
System.out.println(fmt);
// Display complete time and date information.
fmt = new Formatter();
fmt.format("%tc", cal);
System.out.println(fmt);
// Display just hour and minute.
fmt = new Formatter();
fmt.format("%tl:%tM", cal, cal);
System.out.println(fmt);
// Display month by name and number.
fmt = new Formatter();
fmt.format("%tB %tb %tm", cal, cal, cal);
System.out.println(fmt);
}
}