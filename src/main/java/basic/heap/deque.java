package src.main.java.basic.heap;
import java.util.*;

public class deque {

    public static void main(String[] args){
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(1);    // Adds at the beginning: [1]
        deque.addLast(2);     // Adds at the end: [1, 2]
        deque.offerFirst(0);  // Similar to addFirst, but returns false if full: [0, 1, 2]
        deque.offerLast(3);   // Similar to addLast, but returns false if full: [0, 1, 2, 3]

        for(Integer element : deque) {
            System.out.println(element);
        }

        // Accessing elements (without removal)
        int first = deque.getFirst();  // Gets first element, throws exception if empty
        int last = deque.getLast();    // Gets last element, throws exception if empty
        Integer peek1 = deque.peekFirst(); // Gets first element, returns null if empty
        Integer peek2 = deque.peekLast();  // Gets last element, returns null if empty

        // Removing elements
        int removed1 = deque.removeFirst(); // Removes and returns first element, throws exception if empty
        int removed2 = deque.removeLast();  // Removes and returns last element, throws exception if empty
        Integer poll1 = deque.pollFirst();  // Removes and returns first element, returns null if empty
        Integer poll2 = deque.pollLast();   // Removes and returns last element, returns null if empty

        // Other useful operations
        int size = deque.size();        // Get number of elements
        boolean isEmpty = deque.isEmpty(); // Check if empty
        // deque.clear();                  // Remove all elements

        System.out.println("The deque is empty? : " + deque.isEmpty());
        // Using as a Stack
        deque.push(5);      // Same as addFirst()
        int pop = deque.pop(); // Same as removeFirst()

        // Checking for elements
        boolean contains = deque.contains(5); // Check if element exists

        // Iteration
        for(Integer element : deque) {
            System.out.println(element);
        }

    }
}
