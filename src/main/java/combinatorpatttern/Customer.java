package combinatorpatttern;

import java.time.LocalDate;

public class Customer {

    private final String name;
    private final String email;
    private final String phoneNumber;
    private final LocalDate birthday;

    public Customer(String name, String email, String phoneNumber, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
