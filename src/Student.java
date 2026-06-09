public class Student implements Comparable<Student> {
    String name;
    int rollNo;
    int age;

    public Student(String name, int rollNo, int age) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // CompareTo
    // return positive >0 if this > greater than o
    // return positive  0 if this = greater than o
    // return Negative <0 if this < greater than o

    // Sort by ID
//    @Override
//    public int compareTo(Student o) {
//        return this.rollNo - o.rollNo;
//    }

    // Sort By name used CompareTo to return value because name is String so
    // by using subtract will not work on Alphabets
    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    // We can sort by any attribute

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", age=" + age +
                '}';
    }
}
