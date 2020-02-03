package functionalinterfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {
        // Normal java function
        Customer maria = new Customer("Mimi", "0888 90 00 09");
        greetCustomer(maria);
        greetCustomerV2(maria, false);

        // Consumer Functional interface
        greetCustomerConsumer.accept(maria);

        // BiConsumer Functional interface
        greetCustomerBiConsumer.accept(maria, false);
    }

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.name +
                    ", thanks for registering phone number "
                    + customer.phoneNumber);

    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.name +
                    ", thanks for registering phone number "
                    + (showPhoneNumber ? customer.phoneNumber : "*********"));

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.name +
                ", thanks for registering phone number "
                + customer.phoneNumber);
    }

    static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello " + customer.name +
                ", thanks for registering phone number "
                + (showPhoneNumber ? customer.phoneNumber : "**********"));
    }

    static class Customer {

        private final String name;
        private final String phoneNumber;

        Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }
}
