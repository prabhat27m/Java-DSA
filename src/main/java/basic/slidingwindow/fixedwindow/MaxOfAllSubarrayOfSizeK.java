package src.main.java.basic.slidingwindow.fixedwindow;

public class MaxOfAllSubarrayOfSizeK {
    public static void main(String[] args) {
        int [] arr = new int[]{1, -2, -3, 4, -1, -4};
        int size =2;
        int n = arr.length;

        int left =0;
        int right =0;
        int res = Integer.MIN_VALUE;
        int sum =0;

        while(right < n){
            sum += arr[right];

            if(right - left + 1 == size){
                res = Math.max(res, sum);

                sum -= arr[left];
                left++;
            }

            right++;
        }

        System.out.println(res);
    }

}
