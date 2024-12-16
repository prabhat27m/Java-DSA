package src.main.java.basic.stack;

import java.util.*;

public class StackOperations {
    public static void main(String[] args) {
        // Creating a stack
        Stack<String> stack = new Stack<>();

        // 1. Basic Operations
        // Push - adds element to top
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        System.out.println("Stack: " + stack);  // [First, Second, Third]

        // Pop - removes and returns top element
        String popped = stack.pop();  // removes "Third"
        System.out.println("Popped element: " + popped);

        // Peek - views top element without removing
        String top = stack.peek();
        System.out.println("Top element: " + top);  // "Second"

        // 2. Checking stack status
        boolean isEmpty = stack.empty();  // Check if stack is empty
        int size = stack.size();         // Get number of elements

        // 3. Searching
        // Returns 1-based position from top (returns -1 if not found)
        int position = stack.search("First");
        System.out.println("Position of 'First': " + position);

        // 4. Iteration methods
        // Using for-each
        for(String element : stack) {
            System.out.println(element);
        }

        // Using iterator
        Iterator<String> iterator = stack.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 5. Other useful operations
        stack.clear();                    // Remove all elements
        boolean contains = stack.contains("First");  // Check if element exists

        // 6. Vector operations (since Stack extends Vector)
        stack.add("Element");             // Same as push
        stack.elementAt(0);               // Get element at index
        stack.firstElement();             // Get first element
        stack.lastElement();              // Get last element

        // 7. Example of common usage pattern
        Stack<Integer> numbers = new Stack<>();

        // Push some numbers
        numbers.push(1);
        numbers.push(2);
        numbers.push(3);

        // Safe pop pattern
        while(!numbers.empty()) {
            int num = numbers.pop();
            System.out.println("Processing: " + num);
        }

        // 8. Converting to other collections
        ArrayList<String> list = new ArrayList<>(stack);  // Convert to ArrayList
        Object[] array = stack.toArray();                // Convert to array
    }
}
