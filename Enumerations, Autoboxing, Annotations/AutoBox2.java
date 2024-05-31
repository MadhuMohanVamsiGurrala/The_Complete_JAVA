//autoboxing/unboxing takes place with method parameters and return values 
public class AutoBox2 {
    //take an integer parameter and return an int value 
    static int m(Integer v)
    {
        return v; //auto-unbox to int 
    }
    public static void main(String[] args) {
        //pass an int to m() and assign the return value to an integer. Here, the argument 100 is unboxed into an Integer. 
        //The return value is also unboxed into an Integer 
        Integer iOb = m(100);
        System.out.println(iOb);
    }
    
}
