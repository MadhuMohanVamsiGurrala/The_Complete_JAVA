/*A Program that uses the box class
 * call this file BoxDemo.java
 */
class Box
{
    double width;
    double height;
    double depth;
}
//This class declares an object of type box
/**
 * BoxDemo
 */
public class BoxDemo {

    public static void main(String[] args) {
        Box mybox = new Box();
        double vol;

        //assign values to mybox's instance variables 
        mybox.width = 10;
        mybox.height = 20;
        mybox.depth = 15; 

        //compare volume of box
        vol = mybox.width*mybox.height*mybox.depth;
        System.out.println("Volume is "+vol);
    }
}