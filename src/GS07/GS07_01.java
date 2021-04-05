package GS07;

import java.util.ArrayList;

public class GS07_01 {

    static ArrayList scaleByK(ArrayList<Integer> list) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int n = 0;
        for(int l = 0; l < list.size(); l++) {
            n = list.get(l);
            if (n > 0) {
                System.out.println(list.get(l) + " " + list.size());
                for (int i = 0; i < n; i++) {
                    nums.add(n);
                }
            }
        }
        return nums;
    }

    static public void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(-4);
        list.add(3);
        System.out.println(scaleByK(list));
    }
}
