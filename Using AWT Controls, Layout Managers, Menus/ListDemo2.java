import java.awt.*;
import java.awt.event.*;

public class ListDemo2 extends Frame {
    MyList list;

    public ListDemo2() {
        setTitle("List Demo 2");
        setSize(300, 150);

        list = new MyList();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        add(list);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ListDemo2();
    }

    class MyList extends List {
        public MyList() {
            enableEvents(AWTEvent.ITEM_EVENT_MASK | AWTEvent.ACTION_EVENT_MASK);
        }

        protected void processActionEvent(ActionEvent ae) {
            System.out.println("Action event: " + ae.getActionCommand());
            super.processActionEvent(ae);
        }

        protected void processItemEvent(ItemEvent ie) {
            System.out.println("Item event: " + getSelectedItem());
            super.processItemEvent(ie);
        }
    }
}
