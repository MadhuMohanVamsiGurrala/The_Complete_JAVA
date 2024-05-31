import java.net.*;
import java.io.*;
import java.util.*;

class HttpURLDemo {
    public static void main(String[] args) {
        HttpURLConnection hpCon = null;
        try {
            // Using URI to construct the URL to avoid deprecated constructor
            URI uri = new URI("http://www.google.com");
            URL hp = uri.toURL();
            hpCon = (HttpURLConnection) hp.openConnection();

            // Display request method.
            System.out.println("Request method is " + hpCon.getRequestMethod());

            // Display response code.
            System.out.println("Response code is " + hpCon.getResponseCode());

            // Display response message.
            System.out.println("Response Message is " + hpCon.getResponseMessage());

            // Get a list of the header fields and a set of the header keys.
            Map<String, List<String>> hdrMap = hpCon.getHeaderFields();
            Set<String> hdrField = hdrMap.keySet();
            System.out.println("\nHere is the header:");

            // Display all header keys and values.
            for (String k : hdrField) {
                System.out.println("Key: " + k + " Value: " + hdrMap.get(k));
            }

        } catch (URISyntaxException e) {
            System.out.println("URI Syntax Error: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        } finally {
            if (hpCon != null) {
                hpCon.disconnect();
            }
        }
    }
}
