//Use varargs with standard arguments
public class VarArgs2 {
    //Here, msg is a normal parameter and v is a varagrs parameter
    static void vaTest(String msg, int ... v)
    {
        System.out.print(msg+v.length+"Contents: ");
        for(int x:v)
            System.out.println(x+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        vaTest("One  vararg: ", 10);
        vaTest("Three varagrs: ", 1,2,3);
        vaTest("No varargs: ");
    }
}
