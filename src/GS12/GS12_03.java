package GS12;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class GS12_03 {

    public static List<Integer> selectionSort(List<Integer> list) {
        int list_size = list.size();
        for(int i = 0; i < list_size; i++) {
            Integer largest = 0;
            Integer smallest = 0;
            for(int k = 0; k < list_size - i; k++) {
                if (list.get(k) > largest) {
                    largest = list.get(k);
                    Collections.swap(list, k, list_size - 1 - i);
                }
                else if (list.get(k) < smallest) {
                    smallest = list.get(k);
                    Collections.swap(list, k, i);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i < 10; i++) {
            list.add(rand.nextInt(10));
        }
        System.out.println("Welcome! This program takes a preset list of numbers and sorts them.");
        System.out.println("Original list: " + list);
        System.out.println("Modified list: " + selectionSort(list));
    }
}

