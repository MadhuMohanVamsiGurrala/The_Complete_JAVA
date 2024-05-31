package p1;

class Derived extends Protection {
    Derived() {
        System.out.println("derived constructor");
        // Access n_pro and n_pub directly
        System.out.println("n_pro = " + n_pro);
        System.out.println("n_pub = " + n_pub);
    }
}
