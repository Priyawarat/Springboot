import java.util.*;

public class Sorting {
    public static void main(String[] args) {

        // Array of Integer
        int [] arr = {3,5,7,2,4,1,9,8};

        // Sort without collection
        Arrays.sort(arr);

        // Sorting in collection is more flexible but it required a list
        List<Integer> list =new ArrayList<>(List.of(10,6,8,2,5,1,3,9));

        // int -> Integer (Object) Auto boxing
        // Object -> primitive --> Auto Unboxing

        // We added primitve data into list but define List of Integer (Object) so
        // Java automatically converts from primitive to Object here.

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);


        // Custom Object List
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Priye", 4, 23));
        studentList.add(new Student("Rahul", 2, 21));
        studentList.add(new Student("Ankit", 1, 20));
        studentList.add(new Student("Chaman",3, 22));


        System.out.println(studentList);

        // No sort Method because Student is not compatible because
        // the given collection or list is not comparable so can't use Collections.sort()
        //Collections.sort(studentList); -> Exception / Error

        // We have to tell Java that how you will compare student Object so that
        // Java can sort using that sorting method.

        // 1. Comparable and 2. Comparator to tell Java how to sort Student Object
        // Both comes from different interface and different pkg.

        // 1. Comparable Sorting :
        // implement Comparable into Student class to tell Java for sort.
        Collections.sort(studentList);
        System.out.println(studentList);

        // Challenges with Comparable -
        // 1. Inside class need to write impl for sorting
        // 2. If we want multiple sorting impl on different attribute at same time.


        // 2. Comparator sorting
        // Multiple logic in different class
        // Not impl in current class to sort

        // Sort by ID
        Collections.sort(studentList,new IdComparator());
        System.out.println(studentList);

        // Sort By Name
        Collections.sort(studentList,new NameComparator());
        System.out.println(studentList);


        // Set expected comparable object because its inbuilt property to sort objects.
        // If we add Student into Set and not given Comparable then it will throw error.

        Set<Student> set = new TreeSet<>(new IdComparator());
        set.add(new Student("Priye", 4, 23));
        set.add(new Student("Rahul", 2, 21));
        set.add(new Student("Ankit", 1, 20));
        set.add(new Student("Chaman",3, 22));

        System.out.println(set);




    }
}
