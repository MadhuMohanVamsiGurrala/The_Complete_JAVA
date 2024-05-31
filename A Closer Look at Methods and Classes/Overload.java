//Automatic type conversions apply to overloading 
class OverloadDemo
{
    void test()
    {
        System.out.println("No Parameters");
    }
    //overload test for two integer parameter
    void test(int a, int b)
    {
        System.out.println("a and b: "+a+" "+b);
    }
    //overload test for a double parameter
    double test(double a)
    {
        System.out.println("double a: "+a);
        return a*a; 
    }
}
class Overload
{
    public static void main(String[] args) {
        OverloadDemo ob = new OverloadDemo();
        int i = 88; 

        //call all versions of test()
        ob.test();
        ob.test(10,20);

       ob.test(i); //this will invoke test (double)
       ob.test(123.2);
    }
}