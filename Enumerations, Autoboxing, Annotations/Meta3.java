import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str() default "Testing";
    int val() default 9000; 
}

public class Meta3 {
    // Annotate a method using default values 
    @MyAnno()
    public static void myMeth() {
        Meta3 ob = new Meta3(); 
        // Obtain the annotation for this method and display the values of the members 
        try {
            Class<?> c = ob.getClass(); 
            Method m = c.getMethod("myMeth"); 
            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno.str() + " " + anno.val());
        } catch(NoSuchMethodException exc) {
            System.out.println("Method not found.");
        }
    }
    
    public static void main(String[] args) {
        myMeth();
    }
}
