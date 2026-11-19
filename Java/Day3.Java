import java.util.*;
import java.util.stream.Collectors;

class Order {
    int id;
    String customer;
    String product;
    String category;
    double amount;
    String status;
    String city;

    Order(int id, String customer, String product, String category,
         double amount, String status, String city) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.category = category;
        this.amount = amount;
        this.status = status;
        this.city = city;
    }

    public String toString() {
        return id + " | " + customer + " | " + product + " | "
                + category + " | " + amount + " | " + status + " | " + city;
    }
}

public class Day3 {
    public static void main(String[] args) {

        List<Order> orderList = Arrays.asList(
            new Order(101, "Ravi", "Laptop", "Electronics", 55000, "Delivered", "Hyderabad"),
            new Order(102, "Raj", "Mobile", "Electronics", 25000, "Pending", "Vijayawada"),
            new Order(103, "Kiran", "Shoes", "Fashion", 3000, "Delivered", "Chennai"),
            new Order(104, "Arjun", "Watch", "Fashion", 5000, "Cancelled", "Hyderabad"),
            new Order(105, "Sai", "Tablet", "Electronics", 30000, "Delivered", "Bangalore"),
            new Order(106, "Manoj", "Chair", "Furniture", 8000, "Pending", "Chennai"),
            new Order(107, "Karthik", "Sofa", "Furniture", 45000, "Delivered", "Hyderabad"),
            new Order(108, "Pavan", "Headphones", "Electronics", 4000, "Delivered", "Vijayawada"),
            new Order(109, "Teja", "T-Shirt", "Fashion", 1500, "Pending", "Bangalore"),
            new Order(110, "Ajay", "Table", "Furniture", 12000, "Delivered", "Chennai")
        );

        System.out.println("--- DELIVERED ORDERS ABOVE 10000 ---");
        orderList.stream()
            .filter(o -> o.amount > 10000 && o.status.equals("Delivered"))
            .forEach(System.out::println);

        System.out.println("\n--- ORDERS IN ASCENDING ORDER ---");
        orderList.stream()
            .sorted((a, b) -> Double.compare(a.amount, b.amount))
            .forEach(System.out::println);

        System.out.println("\n--- MAXIMUM ORDER AMOUNT ---");
        double max = orderList.stream()
            .mapToDouble(o -> o.amount)
            .max().orElse(0);
        System.out.println(max);

        System.out.println("\n--- MINIMUM ORDER AMOUNT ---");
        double min = orderList.stream()
            .mapToDouble(o -> o.amount)
            .min().orElse(0);
        System.out.println(min);

        System.out.println("\n--- TOTAL SALES ---");
        double sales = orderList.stream()
            .mapToDouble(o -> o.amount)
            .sum();
        System.out.println(sales);

        System.out.println("\n--- ORDER COUNT ---");
        long totalOrders = orderList.stream().count();
        System.out.println(totalOrders);

        System.out.println("\n--- CATEGORY WISE ORDERS ---");
        Map<String, List<Order>> byCategory = orderList.stream()
            .collect(Collectors.groupingBy(o -> o.category));

        byCategory.forEach((key, value) -> {
            System.out.println("\n" + key);
            value.forEach(System.out::println);
        });

        System.out.println("\n--- CITY WISE ORDERS ---");
        Map<String, List<Order>> byCity = orderList.stream()
            .collect(Collectors.groupingBy(o -> o.city));

        byCity.forEach((key, value) -> {
            System.out.println("\n" + key);
            value.forEach(System.out::println);
        });

        System.out.println("\n--- AVERAGE ORDER VALUE ---");
        double average = orderList.stream()
            .mapToDouble(o -> o.amount)
            .average().orElse(0);
        System.out.println(average);

        System.out.println("\n--- CATEGORY WISE SALES ---");
        Map<String, Double> categorySales = orderList.stream()
            .collect(Collectors.groupingBy(
                o -> o.category,
                Collectors.summingDouble(o -> o.amount)
            ));

        categorySales.forEach((key, value) ->
            System.out.println(key + " : " + value)
        );
    }
}