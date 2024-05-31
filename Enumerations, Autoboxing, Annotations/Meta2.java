import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();
    int val(); 
}

@Retention(RetentionPolicy.RUNTIME)
@interface What {
    String description(); 
}

@What(description = "Ah annotation test class")
@MyAnno(str = "Meta2", val = 99)
public class Meta2 {
    @What(description = "An annotation test method")
    @MyAnno(str = "Testing", val = 100)
    public static void myMeth() {
        Meta2 ob = new Meta2();
        try {
            Annotation[] classAnnos = ob.getClass().getAnnotations(); 
            // Display all annotations for Meta2 
            System.out.println("All annotations for Meta2:");
            for (Annotation a : classAnnos)
                System.out.println(a);
            System.out.println();
            // Display all annotations for myMeth 
            Method m = ob.getClass().getMethod("myMeth"); 
            Annotation[] methodAnnos = m.getAnnotations(); 
            System.out.println("All annotations for myMeth:");
            for (Annotation a : methodAnnos)
                System.out.println(a);
        } catch (NoSuchMethodException exc) {
            System.out.println("Method not Found.");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}
