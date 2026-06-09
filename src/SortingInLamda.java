import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingInLamda {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>(List.of("Rahul", "Bob", "John", "Charli","Ankit","Priye"));

        List<String> list1 = new ArrayList<>(names);
        List<String> list2 = new ArrayList<>(names);
        List<String> list3 = new ArrayList<>(names);

        // Using Collection
        System.out.println("Sorting using Collections.sort() : ");
        Collections.sort(names);
        System.out.println(names);

        // Using Lamda Expression to Sort
        Comparator<String> criteria1 = (s1,s2) -> s1.compareTo(s2);
        System.out.println("Sorting using list.sort() in Natural order : ");
        list1.sort(criteria1);
        System.out.println(list1);

        // Using Lamda Expression to sort based on length of String
        Comparator<String> criteria2 = (s1,s2)->s1.length()-s2.length();
        System.out.println("Sorting using list.sort() on basis of String Length : ");
        list2.sort(criteria2);
        System.out.println(list2);

        // Using Lamda Expression to sort based on First Char of String
        Comparator<String> criteria3 = (s1,s2)->s1.charAt(0)-s2.charAt(0);
        System.out.println("Sorting using list.sort() on basis of First Char : ");
        list2.sort(criteria2);
        System.out.println(list3);

    }
}
