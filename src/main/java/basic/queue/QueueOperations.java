package src.main.java.basic.queue;

import java.util.*;
public class QueueOperations {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println("Queue: " + queue);  // [1, 2, 3]

        // front operation - peek at first element
        System.out.println("Front element: " + queue.peek());  // 1

        // pop/dequeue operation
        System.out.println("Removed element: " + queue.poll());  // 1
        System.out.println("Queue after pop: " + queue);  // [2, 3]

        // size operation
        System.out.println("Size: " + queue.size());  // 2

        // empty operation
        System.out.println("Is empty: " + queue.isEmpty());  // false

        // Common operations pattern
        while (!queue.isEmpty()) {
            System.out.println("Processing: " + queue.poll());
        }
    }
}
