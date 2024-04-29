//using break to exit a while loop
public class BreakLoop2 {
    public static void main(String[] args) {
        int i=0;

        while (i<100) {
            if(i == 100)
            break; //terminate loop if i is 10 
            i++;
        }
        System.out.println("Loop Complete.");
    }
    
}
