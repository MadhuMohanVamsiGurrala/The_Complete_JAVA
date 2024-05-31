//use the built in enumeration methods
//an enumeration of apple varieties 
enum Apple 
{
    Jonathan, GoldenDel, RedDel, Winesap, Cortland
}
public class EnumDemo2 {
    public static void main(String[] args) {
        Apple ap; 
        System.out.println("Here are all Apple constants:");
        //use values()
        Apple allapples[] = Apple.values(); 
        for(Apple a : allapples)
            System.out.println(a);
        System.out.println();
        //use valueof()
        ap = Apple.valueOf("Winesap"); 
        System.out.println("ap contains "+ap);
    }
    
}
