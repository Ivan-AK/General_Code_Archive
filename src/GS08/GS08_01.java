package GS08;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;

public class GS08_01 {

    static List removeInRange(List<Integer> list, Integer target, int start, int end) {
        Iterator<Integer> itr = list.iterator(); //Using an iterator to get acquainted with them
        int i = 0; //Counter
        while(itr.hasNext()) {
            Integer element = itr.next();
            if(element.equals(target) && i >=start && i < end) { //imposing the proper criteria
                itr.remove();
            }
            i++;
        }
        return list;
    }

    static public void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> list = new LinkedList<Integer>();
        list.add(4);
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(0);
        list.add(3);
        list.add(4);
        List<Integer> modded_list = new LinkedList<Integer>();
        System.out.println("Welcome! This program will remove a value within a certain range of indexes. " +
                "The current list of values is printed below. Enter the value you wish to remove and the starting " +
                "(inclusive) and ending (exclusive) indexes between which the desired value will be removed.");
        for(Integer i : list) {
            System.out.println(i);
        }
        System.out.println("Input the element/value to be removed: ");
        Integer input = console.nextInt();
        System.out.println("Input the starting index: ");
        int start = console.nextInt();
        System.out.println("Input the ending index: ");
        int end = console.nextInt();

        modded_list.addAll(removeInRange(list, input, start, end)); //calling the method
        for(Integer i : modded_list) {
            System.out.println(i);
        }
    }
}
