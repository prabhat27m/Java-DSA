package src.main.java.leetcode.SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
// Intuition is monotonic decreasing queue
public class SlidingWindowMaximum {
    public int [] maxSlidingWindow(int [] nums, int k){
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {

//            1. first step of removal
            // remove all the smaller values than the incoming values form the deque
            while(!deque.isEmpty() && nums[deque.getFirst()] <= nums[i]){
                deque.pollFirst();
            }

            deque.addLast(i);

//            2. second step of removal
            // remove the out of window element

            if(deque.getFirst() == i-k){
                deque.removeFirst();
            }

//            add from the first window
            if(i>= k-1){
                res.add(nums[deque.getFirst()]);
            }
        }


        return res.stream().mapToInt(i->i).toArray();
    }
    public static void main(String[] args) {
        int [] arr = {1,3,-1,-3,5,3,6,7};

        SlidingWindowMaximum sw = new SlidingWindowMaximum();

        System.out.println(Arrays.toString(sw.maxSlidingWindow(arr,3)));

    }
}


//Dry run

//{1,3,-1,-3,5,3,6,7}

//deq = [1]  -> no res addition as curr index is lesser than k-1   (i=0)
//remove 1 add 3 (1<3)
//deq = [3] no res addition as curr index is lesser than k-1    (i==1)
//deq = [3, -1 ]  -> 3   (i==2)   add 3 to the res  (i>=k-1)
//deq = [3, -1, -3 ]   -> added -3 to the deque
//deq = [5]  remove 3, -1, 3  ( getFirst() == i-k) 1 == 4-3  remove 3
//deq = [1]





