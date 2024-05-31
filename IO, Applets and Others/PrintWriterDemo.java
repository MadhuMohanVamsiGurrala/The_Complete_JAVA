//Demonstrate PrintWriter 
import java.io.*;

public class PrintWriterDemo {
    public static void main(String[] args) {
        // Create a PrintWriter that writes to the standard output stream (System.out)
        // The second parameter 'true' enables autoflush, meaning the buffer is automatically flushed after each println
        PrintWriter pw = new PrintWriter(System.out, true);

        // Write a string to the output stream
        pw.println("This is a string");

        // Write an integer to the output stream
        int i = -7;
        pw.println(i);

        // Write a double to the output stream
        double d = 4.5e-7;
        pw.println(d);
    }
}
