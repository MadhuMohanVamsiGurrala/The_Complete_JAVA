import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("deprecation")
public class CheckboxDemo2 extends Frame {
    MyCheckbox myCheckbox1, myCheckbox2, myCheckbox3;
    CheckboxGroup group;

    public CheckboxDemo2() {
        setTitle("Checkbox Demo 2");
        setSize(300, 150);

        setLayout(new FlowLayout());

        group = new CheckboxGroup();

        myCheckbox1 = new MyCheckbox("Item 1", group);
        add(myCheckbox1);

        myCheckbox2 = new MyCheckbox("Item 2", group);
        add(myCheckbox2);

        myCheckbox3 = new MyCheckbox("Item 3", group);
        add(myCheckbox3);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckboxDemo2();
    }

    class MyCheckbox extends Checkbox {
        public MyCheckbox(String label, CheckboxGroup group) {
            super(label, group, false);
            enableEvents(AWTEvent.ITEM_EVENT_MASK);
        }

        protected void processItemEvent(ItemEvent ie) {
            System.out.println("Checkbox name/state: " + getLabel() + "/" + getState());
            super.processItemEvent(ie);
        }
    }
}
