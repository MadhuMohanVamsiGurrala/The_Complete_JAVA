//Demonstrate when constructors are called
//create a super class
class A 
{
    A()
    {
        System.out.println("Inside A's constructor.");
    }
}
//create a sub class by extending class A
class B extends A
{
    B()
    {
        System.out.println("Inside B's constructor.");
    }
}
//create another subclass by extending B
class C extends B
{
    C()
    {
        System.out.println("Inside C's constructor.");
    }
}
public class CallingCons {
    public static void main(String[] args) {
        C c = new C();
    }
    
}
