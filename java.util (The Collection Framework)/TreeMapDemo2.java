import java.util.*;

// Compare last whole words in two strings.
class TComp implements Comparator<String> {
    public int compare(String a, String b) {
        int i, j;
        String aLastName, bLastName;
        // Find index of beginning of last name.
        i = a.lastIndexOf(' ');
        j = b.lastIndexOf(' ');
        // Extract last names
        aLastName = a.substring(i + 1);
        bLastName = b.substring(j + 1);
        // Compare last names
        return aLastName.compareTo(bLastName);
    }
}

class TreeMapDemo2 {
    public static void main(String args[]) {
        // Create a tree map with a custom comparator
        TreeMap<String, Double> tm = new TreeMap<String, Double>(new TComp());
        // Put elements to the map.
        tm.put("John Doe", 3434.34);
        tm.put("Tom Smith", 123.22);
        tm.put("Jane Baker", 1378.00);
        tm.put("Tod Hall", 99.22);
        tm.put("Ralph Smith", -19.08);

        // Get a set of the entries.
        Set<Map.Entry<String, Double>> set = tm.entrySet();
        // Display the elements.
        for (Map.Entry<String, Double> me : set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();
        // Deposit 1000 into John Doe's account.
        double balance = tm.get("John Doe");
        tm.put("John Doe", balance + 1000);
        System.out.println("John Doe's new balance: " +
                tm.get("John Doe"));
    }
}
