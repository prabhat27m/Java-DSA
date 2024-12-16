package src.main.java.basic.hashing;

import java.util.HashMap;
import java.util.Map;

public class HashMapOperations {


    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A',5);
        map.put('B',3);
        map.put('C',2);

        int val = map.getOrDefault('A', 0);

        System.out.println("Value is :" + val);

        System.out.println(map.get('D'));

        map.put('A', map.getOrDefault('A',0) -1);

        if (map.getOrDefault('A', 0) > 0){
            System.out.println("A is found");
        }else{
            System.out.println("A is not found");
        }

        if (map.getOrDefault('D', 0) > 0){
            System.out.println("D is found");
        }else{
            System.out.println("D is not found");
        }


        if (map.containsKey('A')){
            System.out.println("A is found");
        }else{
            System.out.println("A is not found");
        }

        if (map.containsKey('D')){
            System.out.println("D is found");
        }else{
            System.out.println("D is not found");
        }

        // printing the map

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            System.out.println (entry.getKey() +":" + entry.getValue());
        }

    }
}
