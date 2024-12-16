package src.main.java.basic.sorting;
import java.util.*;

public class BubbleSort
{
    private
        final int  size;
        int [] arr;
    public
    BubbleSort(int size){
        this.size = size;
        this.arr = new int[size];
    }

    int getSize(){
        return this.size;
    }

    void InsertArray(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the values of the array:");
        for(int i=0; i<size; i++){
            int ele = scanner.nextInt();
            arr[i]  = ele;
        }
    }

    void printArray(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void Sort(){
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
