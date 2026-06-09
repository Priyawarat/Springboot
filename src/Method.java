import java.util.List;

public class Method {
    public static void main(String[] args) {

        // filter(Predicate) takes predicate means boolean value function
        // check each element, if it gives true then process


        //map (Function) - performed operation on each element
         // after operation returns element or value

        List<String> list = List.of("Aman", "Alice","Bob", "John","Priye");

        list.stream()
                .filter(name -> name.startsWith("A"))
                .forEach(name-> System.out.println(name));

        List<Integer> list1 = List.of(10,9,8,5,7,6,4);

        list1.stream()
                .map(n->n*2)
                .forEach(n-> System.out.println(n));

        list.stream().forEach(System.out::println);

        // Sort

        list1.stream().sorted().forEach(System.out::println);

        Integer min = list1.stream().min((x,y)->x.compareTo(y)).get();
        Integer max = list1.stream().max((x,y)->x.compareTo(y)).get();

        System.out.println("Minimum : "+min +" Maximum : "+max);


    }
}
