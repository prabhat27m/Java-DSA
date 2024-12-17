package src.main.java.basic.caching;

public class Main {
    public static void main(String[] args) {
        // Create LRU cache with capacity 2
        LRU cache = new LRU(2);

        // Test operations
        cache.put(1, 1);  // cache is {1=1}
        System.out.println("Put (1,1)");

        cache.put(2, 2);  // cache is {1=1, 2=2}
        System.out.println("Put (2,2)");

        System.out.println("Get key 1: " + cache.get(1));  // returns 1

        cache.put(3, 3);  // LRU key was 2, cache is {1=1, 3=3}
        System.out.println("Put (3,3)");

        System.out.println("Get key 2: " + cache.get(2));  // returns -1 (not found)

        cache.put(4, 4);  // LRU key was 1, cache is {4=4, 3=3}
        System.out.println("Put (4,4)");

        System.out.println("Get key 1: " + cache.get(1));  // returns -1 (not found)
        System.out.println("Get key 3: " + cache.get(3));  // returns 3
        System.out.println("Get key 4: " + cache.get(4));  // returns 4
    }
}