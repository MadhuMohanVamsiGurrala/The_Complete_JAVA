import java.net.*;
import java.util.*;

public class DownloadTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com/file.zip");
            Download download = new Download(url);

            // Add an observer to monitor status changes
            download.addObserver(new Observer() {
                @Override
                public void update(Observable o, Object arg) {
                    System.out.println("Download status: " + Download.STATUSES[download.getStatus()]);
                    System.out.println("Progress: " + download.getProgress() + "%");
                }
            });

            // Simulate pause and resume after a few seconds
            Thread.sleep(5000);
            download.pause();
            System.out.println("Download paused.");

            Thread.sleep(5000);
            download.resume();
            System.out.println("Download resumed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
