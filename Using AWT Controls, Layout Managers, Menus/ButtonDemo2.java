import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("deprecation")
public class ButtonDemo2 extends Applet {
    MyButton myButton;
    static int i = 0;

    public void init() {
        myButton = new MyButton("Test Button");
        add(myButton);
    }

    class MyButton extends Button {
        public MyButton(String label) {
            super(label);
            enableEvents(AWTEvent.ACTION_EVENT_MASK);
        }

        protected void processActionEvent(ActionEvent ae) {
            showStatus("action event: " + i++);
            super.processActionEvent(ae);
        }
    }
}
