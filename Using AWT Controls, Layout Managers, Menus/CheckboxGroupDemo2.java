import java.awt.*;
import java.awt.event.*;

public class CheckboxGroupDemo2 extends Frame {
    CheckboxGroup cbg;
    MyCheckbox myCheckbox1, myCheckbox2, myCheckbox3;

    public CheckboxGroupDemo2() {
        setTitle("CheckboxGroup Demo 2");
        setSize(300, 150);

        setLayout(new FlowLayout());

        cbg = new CheckboxGroup();

        myCheckbox1 = new MyCheckbox("Item 1", cbg, true);
        add(myCheckbox1);

        myCheckbox2 = new MyCheckbox("Item 2", cbg, false);
        add(myCheckbox2);

        myCheckbox3 = new MyCheckbox("Item 3", cbg, false);
        add(myCheckbox3);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckboxGroupDemo2();
    }

    class MyCheckbox extends Checkbox {
        public MyCheckbox(String label, CheckboxGroup cbg, boolean flag) {
            super(label, cbg, flag);
            enableEvents(AWTEvent.ITEM_EVENT_MASK);
        }

        protected void processItemEvent(ItemEvent ie) {
            System.out.println("Checkbox name/state: " + getLabel() + "/" + getState());
            super.processItemEvent(ie);
        }
    }
}
