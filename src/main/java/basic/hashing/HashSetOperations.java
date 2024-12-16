package src.main.java.basic.hashing;

import java.util.HashSet;

public class HashSetOperations {

    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(3);

        System.out.println(hashSet);

        System.out.println("Present :"+ hashSet.contains(3));

        System.out.println(hashSet.isEmpty());

//        hashSet.remove(3);

        if (hashSet.remove(2)){
            System.out.println("Removed from the queue");
        }else{
            System.out.println("Not found");
        }


        if (hashSet.remove(4)){
            System.out.println("Removed from the queue");
        }else{
            System.out.println("Not found");
        }

        System.out.println(hashSet);

    }

}
