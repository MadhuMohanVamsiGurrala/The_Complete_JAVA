import java.util.*;

class OldStyle {
    public static void main(String args[]) {
        // Use generics to specify the type of objects stored in the list
        ArrayList<String> list = new ArrayList<String>();

        // Store strings in the list
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        // Use an iterator to iterate over the elements in the list
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            // No explicit type casting is needed when retrieving elements
            // because the list is parameterized with the type String
            String str = itr.next();
            System.out.println(str + " is " + str.length() + " chars long.");
        }
    }
}
