package GS08;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class GS08_04 {

    static boolean isUnique(Map string_map) {
        Set<String> string_set = new HashSet<String>();
        string_set.addAll(string_map.values());
        if(string_map.keySet().size() == string_set.size()) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        Map<String, String> string_map = new HashMap<String, String>(); //Should NOT be unique
        string_map.put("Ivan", "Kapacinskas");
        string_map.put("Macen", "Kapacinskas");

        Map<String, String> string_map_2 = new HashMap<String, String>(); //Should be unique
        string_map.put("Ivan", "Kapacinskas");
        string_map.put("Michael", "Miyoshi");


        System.out.println("Welcome! This program will determine whether maps possess one-to-one pairings" +
                "of keys and values.\n");

        if(isUnique(string_map)) {System.out.println("true");} //Tests 1st map, and should return "false"
        else {System.out.println("false");}

        if(isUnique(string_map_2)) {System.out.println("true");} //Tests 2nd map, and should return "true"
        else {System.out.println("false");}
    }
}
