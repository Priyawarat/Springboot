import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Lamda {
    public static void main(String[] args) {

        // Lamda Expression

        // Without LE
//        Walkable obj = new WalkFast();
//        obj.walk();

        // With LE
//        Walkable obj = ()-> System.out.println("Walking Fast..");
//        obj.walk();

        // With LE
//        Calculate obj1 = (a,b)-> a+b;
//        int ans = obj1.add(1,2);
//        System.out.println(ans);

        // Stream
        // Like a water flow and help to do operation of flowing data.
        List<String> fruits = List.of("Banana" ,"Apple", "Kiwi");

//        Stream<String> stream = fruits.stream();

        // Multiple methods in Stream

//        stream.forEach((fruit)->{
//            System.out.println(fruit);
//        });

        // If we use the stream then it will throw exception that stream already used
        // It prevents memory leak and help not to wasted memory by creating data again and again in heap memory
//        stream.forEach((fruit)->{
//            System.out.println(fruit);
//        });

        // Sorted
//        stream.
//                sorted().
//                forEach((fruit)->{System.out.println(fruit);});

        // map - used to convert one type to another type
        // converted to integer after sorting
//        stream.
//                sorted()
//                .map(fruit->fruit.length())
//                .forEach(fruit -> System.out.println(fruit));

//        stream.
//                sorted()
//                .map(fruit->fruit.length())
//                .map(fruitlen->2*fruitlen)
//                .forEach(fruit -> System.out.println(fruit));

        // Filter - True or False
//        stream.
//                filter(fruit->fruit.length()>4)
//                .sorted()
//                .map(fruit->fruit.length())
//                .map(fruitlen->2*fruitlen)
//                .forEach(fruit -> System.out.println(fruit));

//        stream.
//                filter(fruit->fruit.length()>4)
//                .sorted()
////                .map(fruit->fruit.length())
////                .map(fruitlen->2*fruitlen)
//                .forEach(fruit -> System.out.println(fruit));

        // converted to integer and collecting in list
        // we can collect in map, set and other collection
        List<Integer> integerlist =fruits
                .stream()
                .map(fruit->fruit.length())
                .collect(Collectors.toList());

        System.out.println(integerlist);

        // If we want to remove duplicate collect in set
        Set<Integer> integerSet =fruits
                .stream()
                .map(fruit->fruit.length())
                .collect(Collectors.toSet());

        System.out.println(integerSet);

        // Collecting in map
        Map<String, Integer> map =fruits
                .stream()
                .collect(Collectors.toMap(
                        fruit-> fruit,
                        fruit->fruit.length()));

        System.out.println(map);
    }
}

// Functional Interface contain only one abstract method
interface Walkable{
    void walk();
}

class WalkFast implements Walkable{
    @Override
    public void walk() {
        System.out.println("Walking fast..");
    }
}

interface Calculate{
    int add(int a, int b);
}