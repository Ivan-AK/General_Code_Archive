package GS09;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

public class GS09_01 {

    static public LinkedList<Integer> partition(LinkedList<Integer> list, Integer E) {
        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()) {
            Integer i = itr.next();
            if(i.compareTo(E) < 0) {
                itr.remove();
                list.addFirst(i);
            }
            else if(i.compareTo(E) > 0) {
                itr.remove();
                list.addLast(i);
            }
        }
        return list;
    }

    static public void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(0);
        list.add(0);
        list.add(3);
        list.add(7);
        list.add(5);
        list.add(9);
        list.add(2);
        list.add(8);
        list.add(4);
        list.add(5);
        System.out.print("Welcome! This program will partition a list of integers. Please input a separating value: ");
        Integer E = console.nextInt();
        System.out.println("\n" + partition(list, E));
    }
}