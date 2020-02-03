package optionals;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalsDemo {

    public static void main(String[] args) {
        Optional.ofNullable("user@email.com")
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Cannot send email"));

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Cannot send email"));

        String value = Optional.ofNullable("Hello")
                .orElseGet(() -> "default value");
        System.out.println(value);

        value = (String) Optional.ofNullable(null)
                .orElseGet(() -> "default value");
        System.out.println(value);

        value = Optional.ofNullable("Hello")
                .orElseThrow(() -> new NoSuchElementException());
        System.out.println(value);

        Optional.ofNullable(null)
                .orElseThrow(() -> new NoSuchElementException());
        System.out.println(value);


    }
}
