public class Wrap {
    public static void main(String[] args) {
        // Create an Integer object wrapping the value 100
        Integer iOb = new Integer(100);
        
        // Extract the primitive int value from the Integer object
        int i = iOb.intValue();
        
        // Print the primitive int value and the Integer object
        System.out.println(i + " " + iOb);
    }
}
