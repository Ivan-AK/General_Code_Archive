package GS14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GS14_03 {

    public static class canonical_comparator implements Comparator<String> {
        public int compare(String a, String b) {
            char[] a_chararray = a.toCharArray();
            Arrays.sort(a_chararray);
            String c = new String(a_chararray);
            char[] b_chararray = b.toCharArray();
            Arrays.sort(b_chararray);
            String d = new String(b_chararray);
            return c.compareTo(d);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        canonical_comparator anagram_detector = new canonical_comparator();
        Scanner fr = new Scanner(new File("dictionary.txt"));
        ArrayList<String> sorted_dictionary = new ArrayList<>();
        System.out.println("Welcome! This program will find the anagrams of all the words listed in the anagram.txt file.\n\n");
        while(fr.hasNextLine()) {
            String temp = fr.nextLine();
            sorted_dictionary.add(temp);
        }
        Collections.sort(sorted_dictionary, new canonical_comparator());
        int i = 0;
        while(i != sorted_dictionary.size()) {
            System.out.print(sorted_dictionary.get(i) + " ");
            if(i + 1 != sorted_dictionary.size()) {
                if (anagram_detector.compare(sorted_dictionary.get(i), sorted_dictionary.get(i + 1)) != 0) {
                    System.out.println();
                }
            }
            ++i;
        }
    }
}
