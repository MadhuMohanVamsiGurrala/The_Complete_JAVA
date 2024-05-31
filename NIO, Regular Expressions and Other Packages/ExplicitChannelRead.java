import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ExplicitChannelRead {
    public static void main(String[] args) {
        FileInputStream fIn = null;
        FileChannel fChan = null;
        long fSize;
        ByteBuffer mBuf;

        try {
            // First, open a file for input.
            fIn = new FileInputStream("test.txt");

            // Next, obtain a channel to that file.
            fChan = fIn.getChannel();

            // Now, get the file's size.
            fSize = fChan.size();

            // Allocate a buffer of the necessary size.
            mBuf = ByteBuffer.allocate((int)fSize);

            // Read the file into the buffer.
            fChan.read(mBuf);

            // Rewind the buffer so that it can be read.
            mBuf.rewind();

            // Read bytes from the buffer.
            for (int i = 0; i < fSize; i++) {
                System.out.print((char) mBuf.get());
            }
            System.out.println();
        } catch (IOException exc) {
            System.out.println(exc);
            System.exit(1);
        } finally {
            try {
                if (fChan != null) {
                    fChan.close(); // close channel
                }
                if (fIn != null) {
                    fIn.close(); // close file
                }
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }
}
