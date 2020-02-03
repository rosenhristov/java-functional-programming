package functionalinterfaces;

import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlsSupplier.get());
    }

    static String getDBConnectionUrl() {
        return "jdbc://localhost:5432/user";
    }

    static Supplier<List<String>> getDBConnectionUrlsSupplier = ()
            -> List.of(
                "jdbc://localhost:5432/user",
                "jdbc://localhost:5432/client");

}
