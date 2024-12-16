package src.main.java.basic.sorting;

public class Main {
    public static void main(String[] args){
        BubbleSort bubbleSort = new BubbleSort(4);
        bubbleSort.InsertArray();
        System.out.println("Before sorting the array:");
        bubbleSort.printArray();
        System.out.println("===Sorting the values===");
        bubbleSort.Sort();
        System.out.println("After sorting the array:");
        bubbleSort.printArray();

        SelectionSort selectionSort = new SelectionSort(4);
        selectionSort.InsertArray();
        System.out.println("Before sorting the array:");
        selectionSort.printArray();
        System.out.println("===Sorting the values===");
        selectionSort.Sort();
        System.out.println("After sorting the array:");
        selectionSort.printArray();

        InsertionSort insertionSort1 = new InsertionSort(4);
        insertionSort1.InsertArray();
        System.out.println("Before sorting the array:");
        insertionSort1.printArray();
        System.out.println("===Sorting the values===");
        insertionSort1.Sort();
        System.out.println("After sorting the array:");
        insertionSort1.printArray();


    }
}
