import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SreamAPI {
    public static void main(String[] args) {

        List<Integer> list = List.of(2,3,4,5,6,7,8,9);

        // Get even Numbers ?

        // Traditional way

//        List<Integer> ans = new ArrayList<>();
//        for(int n : list)
//        {
//            if(n%2==0) ans.add(n);
//        }
//
//        System.out.println(ans);


        // Stream using Predicate return true or false and take 1 parameter
//        Stream<Integer> stream = list.stream();
//
//        ans=stream.filter(n->n%2==0).collect(Collectors.toList());
//        System.out.println(ans);

//        list.stream()
//                .filter(n->n>4)
//                .forEach(n-> System.out.println(n));

        // Stream API - Collection process
        // Collection / group of objects

        // 1 way to create Stream Object
        Stream<Object> emptystream = Stream.empty();
        emptystream.forEach(obj-> System.out.println(obj));

        String [] names = {"Priye", "Alice", "Bob", "John"};

        // 2 way using stream.of arrays, object , collection
        Stream<String> streamNames = Stream.of(names);
        streamNames.forEach(name-> System.out.println(name));

        // 3 using Stream Builder
        Stream<Object> stream = Stream.builder().build();

        // 4 using .stream() method to any collection
        Stream<Integer> stream2 = list.stream();
        stream2.forEach(n-> System.out.println(n));
    }
}
