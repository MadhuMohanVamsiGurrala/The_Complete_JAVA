// Demonstrate the precision modifier.
import java.util.*;
class PrecisionDemo {
public static void main(String args[]) {
Formatter fmt = new Formatter();
// Format 4 decimal places.
fmt.format("%.4f", 123.1234567);
System.out.println(fmt);
// Format to 2 decimal places in a 16 character field.
fmt = new Formatter();
fmt.format("%16.2e", 123.1234567);
System.out.println(fmt);
// Display at most 15 characters in a string.
fmt = new Formatter();
fmt.format("%.15s", "Formatting with Java is now easy.");
System.out.println(fmt);
}
}