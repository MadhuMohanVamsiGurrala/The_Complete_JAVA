import java.awt.*;
import java.awt.event.*;

public class ScrollbarDemo2 extends Frame {
    MyScrollbar myScrollbar;

    public ScrollbarDemo2() {
        setTitle("Scrollbar Demo 2");
        setSize(300, 100);

        myScrollbar = new MyScrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 100);
        add(myScrollbar);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ScrollbarDemo2();
    }

    class MyScrollbar extends Scrollbar {
        public MyScrollbar(int style, int initial, int thumb, int min, int max) {
            super(style, initial, thumb, min, max);
            enableEvents(AWTEvent.ADJUSTMENT_EVENT_MASK);
        }

        protected void processAdjustmentEvent(AdjustmentEvent ae) {
            System.out.println("Adjustment event: " + ae.getValue());
            setValue(getValue());
            super.processAdjustmentEvent(ae);
        }
    }
}
