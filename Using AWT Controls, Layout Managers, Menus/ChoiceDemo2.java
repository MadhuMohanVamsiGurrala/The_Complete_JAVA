import java.awt.*;
import java.awt.event.*;

public class ChoiceDemo2 extends Frame {
    MyChoice choice;

    public ChoiceDemo2() {
        setTitle("Choice Demo 2");
        setSize(300, 150);

        setLayout(new FlowLayout());

        choice = new MyChoice();
        choice.add("Red");
        choice.add("Green");
        choice.add("Blue");
        add(choice);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ChoiceDemo2();
    }

    class MyChoice extends Choice {
        public MyChoice() {
            enableEvents(AWTEvent.ITEM_EVENT_MASK);
        }

        protected void processItemEvent(ItemEvent ie) {
            System.out.println("Choice selection: " + getSelectedItem());
            super.processItemEvent(ie);
        }
    }
}
