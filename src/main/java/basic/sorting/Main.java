package src.main.java.basic.sorting;

public class Main {
    public static void main(String[] args){
        BubbleSort b1 = new BubbleSort(4);
        b1.InsertArray();
        System.out.println("Before sorting the array:");
        b1.printArray();
        System.out.println("===Sorting the values===");
        b1.Sort();
        System.out.println("After sorting the array:");
        b1.printArray();
    }
}
