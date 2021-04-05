package GS10;

import java.util.Arrays;

public class GS10_04 {

    public static void main(String[] args) {
        char[] words = {'a', 'b', 'l', 'a', 'c', 'k', 'c', 'a', 't', 'f', 'e', 'l', 'l'};
        System.out.println("before: " + Arrays.toString(words));
        mergeSort(words);
        System.out.println("after : " + Arrays.toString(words));
    }
        // Places the elements of the given array into sorted order
        // using the merge sort algorithm.
        // post: array is in sorted (nondecreasing) order
        public static void mergeSort(char[] a) {
        if (a.length > 1) {
            // split array into two halves
            char[] left = Arrays.copyOfRange(a, 0, a.length / 2);
            char[] right = Arrays.copyOfRange(a, a.length / 2,
                    a.length);
            // recursively sort the two halves
            mergeSort(left);
            mergeSort(right);
            // merge the sorted halves into a sorted whole
            merge(a, left, right);
            }
    }
        // Merges the given left and right arrays into the given
        // result array.
        // pre : result is empty; left/right are sorted
        // post: result contains result of merging sorted lists;
        public static void merge(char[] result, char[] left, char[] right) {
        int i1 = 0; // index into left array
        int i2 = 0; // index into right array
        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length &&
                    left[i1] <= right[i2])) {
                result[i] = left[i1]; // take from left
                i1++;
                } else {
                result[i] = right[i2]; // take from right
                i2++;
                }
            }
    }
}