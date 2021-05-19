package GS13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GS13_04 {

    public static int maxOccurrences(ArrayList<Integer> int_list) {
        if(int_list.isEmpty()) {return 0;}
        HashMap<Integer, Integer> occurrence_storage = new HashMap<>();
        for(int a : int_list) {
            if(occurrence_storage.containsKey(a)) {
                occurrence_storage.put(a, occurrence_storage.get(a) + 1);
            }
            else {
                occurrence_storage.put(a, 1);
            }
        }
        return Collections.max(occurrence_storage.values());
    }

    public static void main(String[] args) {
        ArrayList<Integer> int_list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            int temp = (int)(Math.random() * 10);
            int_list.add(temp);
        }
        System.out.println("List: " + int_list);
        System.out.println("The mode occurs " + maxOccurrences(int_list) + " times.");
    }
}
