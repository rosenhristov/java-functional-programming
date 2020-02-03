package functionalinterfaces;

import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {

        System.out.println("Without predicate");
        System.out.println(isPhoneNumberValid("08000000000"));
        System.out.println(isPhoneNumberValid("0800000000"));
        System.out.println(isPhoneNumberValid("09009877300"));

        System.out.println("With predicate");
        System.out.println(isPhoneNumberValidPredicate.test("08000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0800000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09009877300"));

        System.out.println(
                "Is phone number valid and contains number 3: " +
                isPhoneNumberValidPredicate.and(containsNumber3).test("09009877300")
        );

        System.out.println(
                "Is phone number valid and contains number 3: " +
                        isPhoneNumberValidPredicate.or(containsNumber3).test("08000000000")
        );

        System.out.println(
                "Is phone number valid and contains number 3 (negation): " +
                        isPhoneNumberValidPredicate.and(containsNumber3).test("09009877000")
        );

    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("08") && phoneNumber.length() == 10;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("08") && phoneNumber.length() == 10;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");
}
