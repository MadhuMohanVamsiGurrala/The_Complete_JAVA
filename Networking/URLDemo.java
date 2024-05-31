import java.net.*;

class URLDemo {
    public static void main(String args[]) {
        try {
            URI uri = new URI("http://www.osborne.com/downloads");
            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("Host: " + uri.getHost());
            System.out.println("Path: " + uri.getPath());
            System.out.println("Query: " + uri.getQuery());
            System.out.println("URI: " + uri.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
