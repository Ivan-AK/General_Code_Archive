package GS08;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class GS08_02 {

    static Set<Integer> sortAndRemoveDuplicates(ArrayList<Integer> nums) { //Method is unneeded. The nature of a TreeSet solves this problem.
         Set<Integer> nums_set = new TreeSet<Integer>();
         nums_set.addAll(nums);
         return nums_set;
    }

    static public void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(7);
        nums.add(4);
        nums.add(-9);
        nums.add(4);
        nums.add(15);
        nums.add(8);
        nums.add(27);
        nums.add(7);
        nums.add(11);
        nums.add(-5);
        nums.add(32);
        nums.add(-9);
        nums.add(-9);
        System.out.println("Welcome! This program will Sort a list and expunge any duplicate elements." +
                "The starting list is printed below, with the modified list below that.");
        for(Integer i : nums) {
            System.out.println(i);
        }
        System.out.println("\n\n");
        for(Integer i : sortAndRemoveDuplicates(nums)) { //Not sure why "i" had to be an Object here...
            System.out.println(i); //How is an Object printed? Somehow, this works, but I have no idea how the values are stored.
        }
    }
}
