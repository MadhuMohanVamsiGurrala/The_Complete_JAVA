import java.io.*;

public class ByteArrayInputStreamDemo {
    public static void main(String args[]) throws IOException {
        String tmp = "abcdefghijklmnopqrstuvwxyz";
        byte b[] = tmp.getBytes();

        // Create a new ByteArrayInputStream using the entire byte array
        ByteArrayInputStream input1 = new ByteArrayInputStream(b);

        // Create a new ByteArrayInputStream using a portion of the byte array
        ByteArrayInputStream input2 = new ByteArrayInputStream(b, 0, 3);
    }
}
