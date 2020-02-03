package streams;

import java.util.List;

import static streams.StreamDemo.Gender.*;

public class StreamDemo {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Rosen", MALE),
                new Person("Mimi", FEMALE),
                new Person("Elena", FEMALE),
                new Person("Aleks", MALE),
                new Person("Kalina", FEMALE),
                new Person("Bobi", MALE)
        );

        System.out.println("Print people:");
        people.stream()
                .map(person -> person.toString())
                .forEach(System.out::println);

        System.out.println("Print every person's name's length:");
        people.stream()
                .forEach(
                    person -> System.out.printf(
                                    "%s: %d\n", person.name, person.name.length()));

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);
    }

    static class Person {

        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person {"
                    + "name: " + name
                    + ", gender: " + gender.toString().toLowerCase()
                    + '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
