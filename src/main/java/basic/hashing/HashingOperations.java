package src.main.java.basic.hashing;

import java.util.*;

public class HashingOperations {
    public static void main(String[] args) {
        // 1. HashSet Operations
        System.out.println("=== HashSet ===");
        HashSet<Integer> hashSet = new HashSet<>();

        // Basic operations
        hashSet.add(3);
        hashSet.add(1);
        hashSet.add(1);        // Add element
        hashSet.remove(1);     // Remove element
        boolean exists = hashSet.contains(1);  // Check existence
        int size = hashSet.size();  // Get size
//        hashSet.clear();       // Remove all elements
        System.out.println(hashSet);

        // Bulk operations
        hashSet.addAll(Arrays.asList(1, 2, 3));  // Add multiple elements
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(2, 3, 4));
        hashSet.retainAll(set2);  // Keep only elements present in both sets
        hashSet.removeAll(set2);  // Remove all elements present in set2

        // 2. LinkedHashSet Operations (maintains insertion order)
        System.out.println("\n=== LinkedHashSet ===");
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(3);
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        System.out.println(linkedHashSet);  // Prints in insertion order: [3, 1, 2]

        // 3. TreeSet Operations (sorted set)
        System.out.println("\n=== TreeSet ===");
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);
        System.out.println(treeSet);  // Prints in sorted order: [1, 2, 3]

        // TreeSet specific operations
        System.out.println("First: " + treeSet.first());  // Get minimum
        System.out.println("Last: " + treeSet.last());    // Get maximum
        System.out.println("Higher than 2: " + treeSet.higher(2));  // Next higher
        System.out.println("Lower than 2: " + treeSet.lower(2));    // Next lower

        // 4. HashMap Operations
        System.out.println("\n=== HashMap ===");
        HashMap<String, Integer> hashMap = new HashMap<>();

        // Basic operations
        hashMap.put("One", 1);     // Add key-value pair
        hashMap.remove("One");     // Remove by key
        int value = hashMap.getOrDefault("One", 0);  // Get value (throws NPE if key not present)
        value = hashMap.getOrDefault("One", 0);  // Get value with default if not present
        boolean hasKey = hashMap.containsKey("One");
        boolean hasValue = hashMap.containsValue(1);

        // Bulk operations
        hashMap.putAll(new HashMap<String, Integer>() {{
            put("Two", 2);
            put("Three", 3);
        }});

        // Iteration
        for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 5. LinkedHashMap Operations (maintains insertion order)
        System.out.println("\n=== LinkedHashMap ===");
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Three", 3);
        linkedHashMap.put("One", 1);
        linkedHashMap.put("Two", 2);
        System.out.println(linkedHashMap);  // Prints in insertion order

        // 6. TreeMap Operations (sorted by keys)
        System.out.println("\n=== TreeMap ===");
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Three", 3);
        treeMap.put("One", 1);
        treeMap.put("Two", 2);
        System.out.println(treeMap);  // Prints in sorted key order

        // TreeMap specific operations
        System.out.println("First Entry: " + treeMap.firstEntry());
        System.out.println("Last Entry: " + treeMap.lastEntry());
        System.out.println("Higher Entry than 'One': " + treeMap.higherEntry("One"));
        System.out.println("Lower Entry than 'Three': " + treeMap.lowerEntry("Three"));

        // 7. Custom Comparator examples
        TreeSet<String> customTreeSet = new TreeSet<>((a, b) -> b.compareTo(a));  // Reverse order
        TreeMap<String, Integer> customTreeMap = new TreeMap<>((a, b) -> b.compareTo(a));  // Reverse order

        // 8. Common patterns
        // Check before get
        if(hashMap.containsKey("Key")) {
            value = hashMap.get("Key");
        }

        // Compute if absent
        hashMap.computeIfAbsent("Key", k -> k.length());

        // Update existing value
        hashMap.merge("Key", 1, (oldVal, newVal) -> oldVal + newVal);

    }
}
