class MemoryDemo {
    public static void main(String args[]) {
        // Get the current runtime environment
        Runtime r = Runtime.getRuntime();
        
        long mem1, mem2;

        // Create an array of Integers to allocate memory
        Integer someints[] = new Integer[1000];

        // Print the total memory available to the JVM
        System.out.println("Total memory is: " + r.totalMemory());

        // Get the initial amount of free memory
        mem1 = r.freeMemory();
        System.out.println("Initial free memory: " + mem1);

        // Request garbage collection
        r.gc();

        // Get the amount of free memory after garbage collection
        mem1 = r.freeMemory();
        System.out.println("Free memory after garbage collection: " + mem1);

        // Allocate memory by creating Integer objects
        for(int i = 0; i < 1000; i++)
            someints[i] = Integer.valueOf(i); // Allocate integers

        // Get the amount of free memory after allocation
        mem2 = r.freeMemory();
        System.out.println("Free memory after allocation: " + mem2);
        
        // Calculate memory used by allocation
        System.out.println("Memory used by allocation: " + (mem1 - mem2));

        // Discard the Integer objects
        for(int i = 0; i < 1000; i++)
            someints[i] = null;

        // Request garbage collection again
        r.gc();

        // Get the amount of free memory after collecting discarded Integers
        mem2 = r.freeMemory();
        System.out.println("Free memory after collecting discarded Integers: " + mem2);
    }
}
