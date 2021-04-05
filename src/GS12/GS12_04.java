package GS12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GS12_04 {

    public static class Student {
        String fName, lName, letter_grade;
        int student_number;
        double grade_percentage;

        public Student(String lName, String fName, int student_number, double grade_percentage, String letter_grade) {
            this.lName = lName;
            this.fName = fName;
            this.student_number = student_number;
            this.grade_percentage = grade_percentage;
            this.letter_grade = letter_grade;
        }

        public String toString() {
            return this.lName + " " + this.fName + " " + this.student_number + " " + this.grade_percentage + " " + this.letter_grade;
        }
    }

    static class SortbyFirstName implements Comparator<Student> {
        // Used for sorting in ascending order of first names
        public int compare(Student a, Student b) {
            return a.fName.compareTo(b.fName);
        }
    }

    static class SortbyLastName implements Comparator<Student> {
        // Used for sorting in ascending order of last names
        public int compare(Student a, Student b) {
            return a.lName.compareTo(b.lName);
        }
    }

    static class SortbyStudentNumber implements Comparator<Student> {
        // Used for sorting in ascending order of student numbers
        public int compare(Student a, Student b) {
            return a.student_number - b.student_number;
        }
    }

    static class SortbyGradePercentage implements Comparator<Student> {
        // Used for sorting in ascending order of grade percentages
        public int compare(Student a, Student b) {
            return (int)(a.grade_percentage * 10 - b.grade_percentage * 10);
        }
    }

    static class SortbyLetterGrade implements Comparator<Student> {
        // Used for sorting in ascending order of letter grades
        public int compare(Student a, Student b) {
            return a.letter_grade.compareTo(b.letter_grade);
        }
    }

    static public void main(String[] args) throws FileNotFoundException {
        ArrayList<Student> student_data = new ArrayList<>();
        Scanner fr = new Scanner(new File("student_data.txt"));
        while(fr.hasNextLine()) {
            String[] temp = fr.nextLine().split(",");
            String lName = temp[0];
            String fName = temp[1];
            int student_number = Integer.parseInt(temp[2]);
            double grade_percentage = Double.parseDouble(temp[3]);
            String letter_grade = temp[4];
            student_data.add(new Student(lName, fName, student_number, grade_percentage, letter_grade));
        }

        Scanner console = new Scanner(System.in);
        System.out.println("Welcome! This program can sort student data by differing criteria.");
        System.out.print("Sorting options are listed below:\n" +
                "\t1: Sort by first name\n" +
                "\t2: Sort by last name\n" +
                "\t3: Sort by Student Number\n" +
                "\t4: Sort by grade percentage\n" +
                "\t5: Sort by letter grade");
        System.out.print("\nPlease input your selection number here ---> ");
        String input = console.nextLine();

        for (int i = 0; i < student_data.size(); i++)
            System.out.println(student_data.get(i));
        System.out.println("\n\n");

        if(input.compareTo("1") == 0) {Collections.sort(student_data, new SortbyFirstName());}
        else if(input.compareTo("2") == 0) {Collections.sort(student_data, new SortbyLastName());}
        else if(input.compareTo("3") == 0) {Collections.sort(student_data, new SortbyStudentNumber());}
        else if(input.compareTo("4") == 0) {Collections.sort(student_data, new SortbyGradePercentage());}
        else if(input.compareTo("5") == 0) {Collections.sort(student_data, new SortbyLetterGrade());}
        else {return;}

        System.out.print("1: Sorted in ascending order\n2: Sorted in descending order");
        System.out.print("\nPlease input your selection number here ---> ");
        input = console.nextLine();

        if(input.compareTo("2") == 0) {Collections.reverse(student_data);}

        for (int i = 0; i < student_data.size(); i++)
            System.out.println(student_data.get(i));
    }
}
