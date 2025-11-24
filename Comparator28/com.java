package Comparator28;
import java.util.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }
}

public class com {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("songhaolin", 19),
                new Person("shiyinhuan", 20),
                new Person("lvcen", 18)
        );

        System.out.println("排序前：" + list);

        // 使用 Comparator 按年龄升序
        list.sort(Comparator.comparingInt(p -> p.age));

        System.out.println("排序后：" + list);
    }
}