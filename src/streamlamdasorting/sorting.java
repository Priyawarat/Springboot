package streamlamdasorting;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class sorting {
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001,"Priye",26, LocalDate.of(2023,1,27),35000,"Junior Developer"));
        list.add(new Employee(1005,"Ankit",30, LocalDate.of(2019,3,30),80000,"Team Lead"));
        list.add(new Employee(1002,"Rahul",28, LocalDate.of(2022,8,16),50000,"Senior Developer"));
        list.add(new Employee(1004,"Nitin",32, LocalDate.of(2017,5,1),100000,"Architecture"));
        list.add(new Employee(1003,"Shubham",35, LocalDate.of(2015,1,25),150000,"Manager"));
        list.add(new Employee(1006,"Karan",24, LocalDate.of(2025,12,15),15000,"Intern"));

        // Problem 1 : Print all employees whose salary is greater than 50000.
        System.out.println("Employee having Salary > 50000 : ");
        list.stream()
                .filter(emp->emp.getSalary()>50000)
                .forEach(System.out::println);

        //Problem 2 : Print all employees whose age is less than 30.
        System.out.println("Employee having age > 30 : ");
        list.stream()
                .filter(emp->emp.age>30)
                .forEach(System.out::println);

        // Problem 3 : Print all employees whose role is "Junior Developer".
        System.out.println("Employee having role Junior Developer : ");
        list.stream()
                .filter(emp->emp.role.equals("Junior Developer"))
                .forEach(System.out::println);

        // Problem 4 : Print employees whose name starts with "A".
        System.out.println("Employee Name starts with 'A' : ");
        list.stream()
                .filter(emp->emp.name.startsWith("A"))
                .forEach(System.out::println);

        //Problem 5 : Print employees who joined after 2020.
        System.out.println("Employee who Joined after 2020 : ");
        list.stream()
                .filter(emp->emp.doj.getYear()>2020)
                .forEach(System.out::println);

        // Problem 6 : Sort employees by salary ascending.
        System.out.println("Sorting Employee in ascending by Salary : ");
        list.stream()
                .sorted((e1,e2)->e1.salary-e2.salary)
                .forEach(System.out::println);

        // Problem 7 : Sort employees by salary descending.
        System.out.println("Sorting Employee in descending by Salary : ");
        list.stream()
                .sorted((e1,e2)->e2.salary-e1.salary)
                .forEach(System.out::println);

        // Problem 8 : Sort employees by name alphabetically.
        System.out.println("Sorting Employee in ascending order by Name : ");
        list.stream()
                .sorted((e1,e2)->e1.name.compareTo(e2.name))
                .forEach(System.out::println);

        // Problem 9 : Sort employees by age ascending..
        System.out.println("Sorting Employee in ascending by age : ");
        list.stream()
                .sorted((e1,e2)->e1.age- e2.age)
                .forEach(System.out::println);

        // Problem 10 : Sort employees by Date Of Joining oldest to new
        System.out.println("Sorting Employee in ascending by Date Of Joining : ");
        list.stream()
                .sorted((e1,e2)->e1.doj.compareTo(e2.doj))
                .forEach(System.out::println);

        // Problem 11 : Sort employees by Date Of Joining new to oldest
        System.out.println("Sorting Employee in descending by Date Of Joining : ");
        list.stream()
                .sorted((e1,e2)->e2.doj.compareTo(e1.doj))
                .forEach(System.out::println);

        // Problem 12 : Find employees with salary > 50000 and sort by salary.
        System.out.println("Sorting Employee in ascending by Salary where salary > 50000 : ");
        list.stream()
                .filter(emp->emp.salary>50000)
                .sorted((e1,e2)->e1.salary-e2.salary)
                .forEach(System.out::println);

        //Problem 13 : Find employees with age > 25 and sort by name.
        System.out.println("Sorting Employee in ascending by name where age > 25 : ");
        list.stream()
                .filter(emp->emp.age>25)
                .sorted((e1,e2)->e1.name.compareTo(e2.name))
                .forEach(System.out::println);

        // Problem 14 : Find all SE employees and sort by DOJ.
        System.out.println("Sorting Employee in ascending by DOJ where role is Manager : ");
        list.stream()
                .filter(emp->emp.role.equals("Manager"))
                .sorted((e1,e2)->e1.doj.compareTo(e2.doj))
                .forEach(System.out::println);

        // Problem 15 : Find employees who joined after 2018 and sort by salary descending.
        System.out.println("Employees who joined after 2018 and sort by salary descending.");
        list.stream()
                .filter(emp->emp.doj.getYear()>2018)
                .sorted((e1,e2)->e2.salary-e1.salary)
                .forEach(System.out::println);

        // Problem 16 : Get only employee names.
        System.out.println("Get only employee names.");
        list.stream()
                .map(epm->epm.getName())
                .forEach(System.out::println);

        // Problem 17 : Get all Salary.
        System.out.println("Get all Salary");
        list.stream()
                .map(epm->epm.getSalary())
                .forEach(System.out::println);

        // Problem 18 : Convert all employee names to uppercase.
        System.out.println("Convert all employee names to uppercase.");
        list.stream()
                .map(epm->epm.name.toUpperCase())
                .forEach(System.out::println);

        // Problem 19 : Count employees having salary > 50000.
        System.out.println("Count employees having salary > 50000.");
        long count = list.stream()
                .filter(emp->emp.salary>50000)
                .count();
        System.out.println(count);

        // Problem 20 : Count employees whose role is Intern
        System.out.println("Count employees whose role is Intern");
         count = list.stream()
                .filter(emp->emp.role.equals("Intern"))
                .count();
        System.out.println(count);

        // Problem 21 : Count employees joined after 2018.
        System.out.println("Count employees joined after 2018.");
        count = list.stream()
                .filter(emp->emp.doj.getYear()>2018)
                .count();
        System.out.println(count);

        // Problem 22 : Find first employee whose salary > 70000.
        System.out.println("Find first employee whose salary > 70000.");
        list.stream()
                .filter(emp->emp.salary>70000)
                .limit(1)
                .forEach(System.out::println);

        //Optimized and interview approached
        list.stream()
                .filter(emp->emp.salary>70000)
                .findFirst()
                        .ifPresent(System.out::println);

        // Problem 23 : Find first employee with role Intern
        System.out.println("Find first employee with role Intern");
        list.stream()
                .filter(emp->emp.role.equals("Intern"))
                .limit(1)
                .forEach(System.out::println);

        //Optimized
        list.stream()
                .filter(emp->emp.role.equals("Intern"))
                .findFirst()
                .ifPresentOrElse(System.out::println,null);

        // Problem 24 : Find highest paid employee.
        System.out.println("Find highest paid employee.");
        list.stream()
                .sorted((e1,e2)->e2.salary-e1.salary)
                .limit(1)
                .forEach(System.out::println);

        //Optimized
        list.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);

        // Problem 25 : Find lowest paid employee.
        System.out.println("Find lowest paid employee.");
        list.stream()
                .sorted((e1,e2)->e1.salary-e2.salary)
                .limit(1)
                .forEach(System.out::println);

        //Optimized
        list.stream()
                .min(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);

        // Problem 26 : Find youngest employee.
        System.out.println("Find youngest employee.");
        list.stream()
                .sorted((e1,e2)->e1.age-e2.age)
                .limit(1)
                .forEach(System.out::println);

        //Optimized
        list.stream()
                .min(Comparator.comparing(Employee::getAge))
                .ifPresent(System.out::println);

        // Problem 27 : Find oldest employee.
        System.out.println("Find oldest employee.");
        list.stream()
                .sorted((e1,e2)->e2.age-e1.age)
                .limit(1)
                .forEach(System.out::println);

        //Optimized
        list.stream()
                .max(Comparator.comparing(Employee::getAge))
                .ifPresent(System.out::println);

        // Problem 28 : Sort by role and then name.
        System.out.println("Sort by role and then name.");
        list.stream()
                .sorted((e1,e2)->{
                    int roleCompare = e1.role.compareTo(e2.role);
                    if(roleCompare!=0) return roleCompare;
                    return e1.name.compareTo(e2.name);
                })
                .forEach(System.out::println);

        // more optimized for twice compare - Comparator.comparing(Employee::getX)
        //          .thenComparing(Employee::getY)

        list.stream()
                .sorted(Comparator.comparing(Employee::getRole).thenComparing(Employee::getName))
                .forEach(System.out::println);


        // Problem 29 : Sort by salary and then age.
        System.out.println("Sort by salary and then age.");
        list.stream()
                .sorted((e1,e2)->{
                    int compare = e1.salary- e2.salary;
                    if(compare!=0) return compare;
                    return e1.age-e2.age;
                })
                .forEach(System.out::println);

        //optimized
        list.stream()
                .sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getAge))
                .forEach(System.out::println);

        // Problem 30 : Sort by role and then salary descending.
        System.out.println("Sort by salary and then age.");
        list.stream()
                .sorted((e1,e2)->{
                    int compare = e1.role.compareTo(e2.role);
                    if(compare!=0) return compare;
                    return e1.salary-e2.salary;
                })
                .forEach(System.out::println);

        //optimized
        list.stream()
                .sorted(Comparator.comparing(Employee::getRole).thenComparing(Employee::getSalary))
                .forEach(System.out::println);

        // Problem 31 : Find top 3 highest paid employees.
        System.out.println("Find top 3 highest paid employees.");
        list.stream()
                .sorted((e1,e2)->e2.salary - e1.salary)
                .limit(3)
                .forEach(System.out::println);

        //optimized
        list.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(2)
                .findFirst()
                .ifPresent(System.out::println);

        // Problem 32 : Find second highest salary employee.
        System.out.println("Find second highest salary employee.");
        list.stream()
                .sorted((e1,e2)->e2.salary - e1.salary)
                .limit(2)
                .sorted((e1,e2)->e1.salary-e2.salary)
                .limit(1)
                .forEach(System.out::println);

        list.stream()
                .sorted((e1,e2)->e2.salary-e1.salary)
                .skip(1)
                .limit(1)
                .forEach(System.out::println);

        // for nth - Skip =  n-1 Employee

        list.stream()
                .sorted((e1,e2)->e2.salary-e1.salary)
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);

        //optimized
        list.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);

        // Problem 33 : Find employee with longest name.
        System.out.println("Find employee with longest name.");
        list.stream()
                .sorted((e1,e2)->e2.name.length()-e1.name.length())
                .limit(1)
                .forEach(System.out::println);

        // Problem 34 : Find employee who joined earliest.
        System.out.println("Find employee who joined earliest.");
        list.stream()
                .sorted((e1,e2)->e1.doj.compareTo(e2.doj))
                .limit(1)
                .forEach(System.out::println);

        // Problem 35 : Find employees whose salary lies between 40000 and 80000.
        System.out.println("Find employees whose salary lies between 40000 and 80000.");
        list.stream()
                .filter(emp->emp.salary>40000 && emp.salary<80000)
                .forEach(System.out::println);

        // Problem 36 : Group employees by role.
        System.out.println("Group employees by role.");
        Map<String, List<Employee>> groupByRole =  list.stream()
                .collect(Collectors.groupingBy(Employee::getRole));
        System.out.println(groupByRole);


        // Problem 37 : Count employees in each role.
        System.out.println("Count employees in each role.");
        Map<String, Long> countByRole =  list.stream()
                .collect(Collectors.groupingBy(Employee::getRole,Collectors.counting()));
        System.out.println(countByRole);


        // Problem 38 : Find highest paid employee in each role.
        System.out.println("Find highest paid employee in each role.");
        Map<String, Optional<Employee>> highestPaidEmployeInEachRole =  list.stream()
                .collect(Collectors.groupingBy(
                        Employee::getRole,
                        Collectors.maxBy(
                        Comparator.comparing(Employee::getSalary)
                        ))
                );
        System.out.println(highestPaidEmployeInEachRole);


        // Problem 39 : Find average salary per role.
        System.out.println("Find average salary per role.");
        Map<String, Double> avgSalary =  list.stream()
                .collect(Collectors.groupingBy(
                        Employee::getRole,
                        Collectors.averagingDouble(
                                Employee::getSalary)
                  )
                );
        System.out.println(avgSalary);


        // Problem 40 : List = Role -> List<Employee>
        System.out.println("List of Role from Employee : ");
        Map<String, List<Employee>> roleEmployee =  list.stream()
                .collect(Collectors.groupingBy(Employee::getRole));
        System.out.println(roleEmployee);

    }
}
