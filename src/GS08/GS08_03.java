package GS08;

import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public class GS08_03 {

    static Set removeEvenLength(Set<String> list) {
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String element = itr.next();
            if (element.length() % 2 == 0) {
                itr.remove();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Set<String> list = new HashSet<String>();
        list.add("Hello");
        list.add("I'm");
        list.add("Jack");
        list.add("How");
        list.add("Are");
        list.add("Your");
        list.add("Children");
        list.add("Doing");
        list.add("?");
        System.out.println("Welcome! This program will remove any strings of even length from the original list.");
        for(Object s : removeEvenLength(list)) {
            System.out.println(s);
        }
    }
}
