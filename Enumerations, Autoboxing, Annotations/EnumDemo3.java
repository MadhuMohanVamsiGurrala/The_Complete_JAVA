//use an enum constructor, instance variable, and method 
enum Apple
{ 
    Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cortland(8);
private int price; //price of each apple 
//constructor 
Apple(int p)
    {price = p;}
int getPrice()
    {return price;}
}
public class EnumDemo3 {
    public static void main(String[] args) {
        Apple ap; 
        //display price of winesap 
        System.out.println("Winesap costs "+Apple.Winesap.getPrice()+"cents.\n");
        //display all apples and prices 
        System.out.println("All apple prices:");
        for(Apple a: Apple.values())
            System.out.println(a+" costs "+a.getPrice()+" cents.");
    }
    
}
