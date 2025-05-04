package src.main.java.leetcode.Arrays;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+ 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(new int [] {entry.getValue(), entry.getKey()});

            if(pq.size() > k){
                pq.poll();
            }

        }

        int [] res = new int[k];

        for(int i = k-1 ; i >= 0 ; i--){
            res[i] = pq.poll()[1];
        }

        return res;

    }

    public static void main(String[] args) {
        TopKFrequentElements sol = new TopKFrequentElements();

        int[] nums1 = {1,1,1,2,2,3};
        int k1 = 2;
        int[] res1 = sol.topKFrequent(nums1, k1);
        System.out.println("Top K Frequent Elements: " + Arrays.toString(res1));

        int[] nums2 = {1};
        int k2 = 1;
        int[] res2 = sol.topKFrequent(nums2, k2);
        System.out.println("Top K Frequent Elements: " + Arrays.toString(res2));

        int[] nums3 = {4,4,4,6,6,7,7,7,7};
        int k3 = 2;
        int[] res3 = sol.topKFrequent(nums3, k3);
        System.out.println("Top K Frequent Elements: " + Arrays.toString(res3));
    }
}
