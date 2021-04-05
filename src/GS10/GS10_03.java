package GS10;

import java.util.Arrays;

public class GS10_03 {

    public static int[] selectionSort(int[] list) {
        for(int k = list.length - 1; k >= 0; k--) {
            int mark = k;
            int largest = list[k];
            for (int i = 0; i <= k; i++) {
                if (list[i] > largest) {
                    largest = list[i];
                    mark = i;
                }
            }
            list[mark] = list[k];
            list[k] = largest;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] list = {7, 4, 2, 6, 9, 8, 1, 3, 5};
        System.out.println("Welcome! This program takes a list of integers and sorts them from least to greatest.");
        System.out.println("Original array: " + Arrays.toString(list));
        System.out.println(Arrays.toString(selectionSort(list)));
    }
}

/* This is simply a reversed selection sort algorithm, it is not faster or slower since it uses the same method of sifting
*  through the array as the original algorithm.
*
*  Complexity Rating: O(N^2) */
