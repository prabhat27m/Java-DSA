package src.main.java.basic.recursion;


public class BasicRecursion {
    void PrintKElements(int n){
        if(n==5){
            return;
        }

        System.out.println(n);
        PrintKElements(n+1);
        return;
    }

    public static void main(String[] args) {
        BasicRecursion basicRecursion = new BasicRecursion();
        basicRecursion.PrintKElements(0);
    }
}
