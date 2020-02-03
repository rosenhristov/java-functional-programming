package finalsection;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Lambdas {

    public static void main(String[] args) {

        Function<String, String> toUpperCase = String::toUpperCase;

        Function<String, String> upperCaseName = (name) -> {
            if (name.isBlank()) {
                throw new IllegalArgumentException("");
            }
            return name.toUpperCase();
        };

        BiFunction<String, Integer, String> upperCaseNameAndAge = (name, age) -> {
            if (name.isBlank() || age == null) {
                throw new IllegalArgumentException("");
            }
            System.out.println(age);
            return name.toUpperCase();
        };

        System.out.println(toUpperCase.apply("Rosen"));
        System.out.println(upperCaseName.apply("Kalina"));
        System.out.println(upperCaseNameAndAge.apply("Vera", 35));
        System.out.println(upperCaseNameAndAge.apply("Iva", null));

    }

}
