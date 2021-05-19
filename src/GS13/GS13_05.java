package GS13;

//BJP Chapter 11, Exercise 2

import java.util.ArrayList;

public class GS13_05 {

    public static ArrayList<Integer> alternate(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> combo = new ArrayList<>();
        int least;
        if(list1.isEmpty() || list2.isEmpty()) {
            if(list1.isEmpty() && list2.isEmpty()) {return null;}
            else if(list1.isEmpty()) {return list2;}
            else {return list1;}
        }
        while(!(list1.isEmpty()) && !(list2.isEmpty())) {
            combo.add(list1.get(0));
            list1.remove(0);
            combo.add(list2.get(0));
            list2.remove(0);
        }
        combo.addAll(list1);
        combo.addAll(list2);
        return combo;
    }

    public static void main(String[] args) {
        int rand1 = (int)(Math.random() * 10);
        int rand2 = (int)(Math.random() * 10);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < rand1; i++) {
            int temp = (int)(Math.random() * 10);
            list1.add(temp);
        }
        for(int i = 0; i < rand2; i++) {
            int temp = (int)(Math.random() * 10);
            list2.add(temp);
        }
        System.out.println("List one: " + list1 + "\n" + "List two: " + list2);
        System.out.println("After method call: " + alternate(list1, list2));
    }
}
