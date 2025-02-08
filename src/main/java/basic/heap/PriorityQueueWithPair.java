package src.main.java.basic.heap;
import java.util.*;
public class PriorityQueueWithPair {
    public static void main(String[] args) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> (a[1]+ a[2])- (b[1] + b[2]));
        priorityQueue.offer(new int[]{4,3,4});
        priorityQueue.offer(new int[]{2,3,2});
        priorityQueue.offer(new int[]{1,3,1});

        while(!priorityQueue.isEmpty()){
            int [] arr = priorityQueue.poll();
            System.out.println(arr[0] + " " + arr[1] +" " + arr[2]);
        }

        int [] arr1 = new int[]{1,3,4};
        System.out.println(Arrays.toString(arr1));
    }
}
