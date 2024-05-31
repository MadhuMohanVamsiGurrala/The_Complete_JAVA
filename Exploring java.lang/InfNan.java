class InfNaN {
    public static void main(String args[]) {
        // Create Double objects with specific values using valueOf() method
        Double d1 = Double.valueOf(1/0.); // Infinity
        Double d2 = Double.valueOf(0/0.); // NaN

        // Print the values and the results of isInfinite() and isNaN() methods
        System.out.println(d1 + ": " + d1.isInfinite() + ", " + d1.isNaN());
        System.out.println(d2 + ": " + d2.isInfinite() + ", " + d2.isNaN());
    }
}
