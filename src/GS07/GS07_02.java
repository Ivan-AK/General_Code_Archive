package GS07;

import java.util.ArrayList;

public class GS07_02 {

    static ArrayList minToFront(ArrayList<Integer> list) {
        Integer min = list.get(0); //Placeholder for minimum value
        for (Integer integer : list) {
            if (integer.compareTo(min) < 0) {
                min = integer; //The minimum value encountered will be carried along by doing this
            }
        }
        for(int i = 0; i < list.size(); ++i) { //Loop that uses the known minimum value to complete this method's operation
            if(list.get(i).compareTo(min) == 0) {
                list.remove(i);
                list.add(0, min); //Adding the min here allows the method to deal with multiple occurrences of min
            }
        }
        return list;
    }

    static public void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(0);
        list.add(3);
        list.add(-2);
        System.out.println(minToFront(list));
    }
}
