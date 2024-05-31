import java.net.*;
import java.io.*;
import java.util.Date;

class UCDemo {
    public static void main(String[] args) {
        HttpURLConnection hpCon = null;
        InputStream input = null;
        int c; // Declare 'c' outside the try block
        try {
            // Using URI to construct the URL to avoid deprecated constructor
            URI uri = new URI("http://www.internic.net");
            URL hp = uri.toURL();
            hpCon = (HttpURLConnection) hp.openConnection();

            // Get and print the date using getHeaderFieldDate
            long d = hpCon.getHeaderFieldDate("Date", 0);
            if (d == 0) {
                System.out.println("No date information.");
            } else {
                System.out.println("Date: " + new Date(d));
            }

            // Get and print the content type
            String contentType = hpCon.getHeaderField("Content-Type");
            if (contentType == null) {
                System.out.println("No content type information.");
            } else {
                System.out.println("Content-Type: " + contentType);
            }

            // Get and print the expiration date using getHeaderFieldDate
            d = hpCon.getHeaderFieldDate("Expires", 0);
            if (d == 0) {
                System.out.println("No expiration information.");
            } else {
                System.out.println("Expires: " + new Date(d));
            }

            // Get and print the last-modified date using getHeaderFieldDate
            d = hpCon.getHeaderFieldDate("Last-Modified", 0);
            if (d == 0) {
                System.out.println("No last-modified information.");
            } else {
                System.out.println("Last-Modified: " + new Date(d));
            }

            // Get and print the content length
            int len = hpCon.getContentLength();
            if (len == -1) {
                System.out.println("Content length unavailable.");
            } else {
                System.out.println("Content-Length: " + len);
            }

            // Get and print the content
            if (len != 0) {
                System.out.println("=== Content ===");
                input = hpCon.getInputStream();
                while ((c = input.read()) != -1) {
                    System.out.print((char) c);
                }
            } else {
                System.out.println("No content available.");
            }
        } catch (URISyntaxException e) {
            System.out.println("URI Syntax Error: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.out.println("Error closing input stream: " + e.getMessage());
                }
            }
            if (hpCon != null) {
                hpCon.disconnect();
            }
        }
    }
}
