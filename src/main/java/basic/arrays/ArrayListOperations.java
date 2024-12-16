package src.main.java.basic.arrays;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListOperations {
    public static void main(String[] args) {
        // Creating ArrayList
        ArrayList<String> list = new ArrayList<>();

        // Adding elements
        list.add("Apple");                 // Adds at the end
        list.add(1, "Banana");            // Adds at specific index
        list.addAll(Arrays.asList("Cherry", "Date")); // Adds collection

        // Accessing elements
        String first = list.get(0);        // Get element at index
        int size = list.size();            // Get size
        boolean isEmpty = list.isEmpty();   // Check if empty

        // Updating elements
        list.set(1, "Updated Banana");     // Replace element at index

        // Removing elements
        list.remove(0);                    // Remove by index
        list.remove("Cherry");             // Remove by object
        list.removeAll(Arrays.asList("Date", "Apple")); // Remove multiple
        list.clear();                      // Remove all elements

        // Searching
        list.add("Apple");
        list.add("Banana");
        list.add("Apple");
        int firstIndex = list.indexOf("Apple");      // First occurrence
        int lastIndex = list.lastIndexOf("Apple");   // Last occurrence
        boolean exists = list.contains("Banana");    // Check existence

        // Sublist
        List<String> subList = list.subList(0, 2);  // Get portion of list

        // Converting to array
        String[] array = list.toArray(new String[0]);

        // Sorting
        Collections.sort(list);                      // Natural order
        Collections.sort(list, Collections.reverseOrder()); // Reverse order

        // Custom sort with Comparator
        Collections.sort(list, (a, b) -> a.length() - b.length());

        // Iteration
        // Method 1: For loop
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // Method 2: Enhanced for loop
        for (String item : list) {
            System.out.println(item);
        }

        // Method 3: Iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Method 4: forEach with lambda
        list.forEach(item -> System.out.println(item));

        // Utility operations
        Collections.shuffle(list);         // Randomize order
        Collections.reverse(list);         // Reverse list
        Collections.fill(list, "Same");    // Fill with element
        int frequency = Collections.frequency(list, "Apple"); // Count occurrences

        // Converting between List types
        ArrayList<String> copy = new ArrayList<>(list); // Create copy
        List<String> immutableList = Collections.unmodifiableList(list);

        // Working with primitives
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);

        // Capacity operations
        numbers.ensureCapacity(100);  // Ensure minimum capacity
        numbers.trimToSize();         // Trim to current size

        // Bulk operations
        ArrayList<String> list2 = new ArrayList<>();
        list.retainAll(list2);        // Keep only elements in both lists
        boolean containsAll = list.containsAll(list2); // Check if all elements present

        ArrayList<Integer> list3 = new ArrayList<>(Collections.nCopies(5, -1));
        for(Integer ele: list3){
            System.out.println(ele + " ");
        }
        System.out.println();

        // how to check if the lists are equal

        List<Integer> l1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> l2 = Arrays.asList(1, 2, 3, 4);
        List<Integer> l3 = Arrays.asList(1, 2, 4, 3);

        // Method 1: Using equals() - Checks values and order

        System.out.println("Method 1 (list1 vs list2): " + l1.equals(l2));  // true
        System.out.println("Method 1 (list1 vs list3): " + l1.equals(l3));

    }
}
