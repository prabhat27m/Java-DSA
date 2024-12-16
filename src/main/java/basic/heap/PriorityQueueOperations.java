package src.main.java.basic.heap;

import java.util.*;

public class PriorityQueueOperations {
    public static void main(String[] args) {
        // 1. Creating PriorityQueue
        // Natural ordering (min heap)
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();

        // With initial capacity
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(10);

        // Custom comparator (max heap)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Custom comparator for objects
        PriorityQueue<String> customPQ = new PriorityQueue<>((s1, s2) -> s2.length() - s1.length());

        // 2. Basic Operations
        // Adding elements
        pq1.offer(5);        // Preferred way
        pq1.add(3);         // Alternative way
        pq1.offer(1);
        pq1.offer(4);
        pq1.offer(2);
        System.out.println("Queue: " + pq1);  // Note: toString might not show sorted order

        // Remove and return head element
        int head = pq1.poll();    // Returns null if empty
        System.out.println("Removed head: " + head); // Will print 1 (smallest)

        // Remove specific element
        boolean removed = pq1.remove(3); // Returns true if element was present

        // Peek at head without removing
        Integer peek = pq1.peek();    // Returns null if empty
        System.out.println("Head element: " + peek);

        // 3. Size operations
        int size = pq1.size();
        boolean isEmpty = pq1.isEmpty();

        // 4. Clearing the queue
        pq1.clear();

        // 5. Example with custom class
        class Task implements Comparable<Task> {
            String name;
            int priority;

            Task(String name, int priority) {
                this.name = name;
                this.priority = priority;
            }

            @Override
            public int compareTo(Task other) {
                return this.priority - other.priority;
            }

            @Override
            public String toString() {
                return name + "(" + priority + ")";
            }
        }

        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
        taskQueue.offer(new Task("Low", 5));
        taskQueue.offer(new Task("High", 1));
        taskQueue.offer(new Task("Medium", 3));

        // Process tasks in priority order
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println("Processing: " + task);
        }

        // 6. Converting to other collections
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        numbers.addAll(Arrays.asList(3, 1, 4, 1, 5));

        // Convert to array
        Object[] array = numbers.toArray();

        // Convert to List
        List<Integer> list = new ArrayList<>(numbers);

        // 7. Iteration (Note: iteration order is not guaranteed)
        PriorityQueue<Integer> iterPQ = new PriorityQueue<>();
        iterPQ.addAll(Arrays.asList(3, 1, 4, 1, 5));

        // Using for-each (not in sorted order)
        for (Integer num : iterPQ) {
            System.out.print(num + " ");
        }
        System.out.println();

        // To get sorted order, need to poll
        while (!iterPQ.isEmpty()) {
            System.out.print(iterPQ.poll() + " ");
        }
    }
}