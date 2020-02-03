package combinatorpatttern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static combinatorpatttern.CustomerRegistrationValidator.*;
import static combinatorpatttern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator
        extends Function<Customer, ValidationResult> {

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> {
            System.out.println("running email validation");
            return customer.getEmail().contains("@") ?
                    SUCCESS : INVALID_EMAIL;
        };
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("+0") ?
                SUCCESS : INVALID_PHONE_NUMBER;
    }

    static CustomerRegistrationValidator isAnAdult() {
        return customer ->
                Period.between(customer.getBirthday(), LocalDate.now()).getYears() > 16 ?
                        SUCCESS : NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        INVALID_PHONE_NUMBER,
        INVALID_EMAIL,
        NOT_AN_ADULT
    }
}
