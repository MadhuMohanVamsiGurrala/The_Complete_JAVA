import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();
    int val();
}

public class Meta {
    @MyAnno(str = "Two Parameters", val = 19)
    public static void myMeth(String str, int i) {
        try {
            Method m = Meta.class.getMethod("myMeth", String.class, int.class);
            MyAnno anno = m.getAnnotation(MyAnno.class);
            if (anno != null) {
                System.out.println(anno.str() + " " + anno.val());
            } else {
                System.out.println("Annotation not found.");
            }
        } catch (NoSuchMethodException exc) {
            System.out.println("Method not found.");
        }
    }

    public static void main(String[] args) {
        myMeth("test", 10);
    }
}
