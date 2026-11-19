import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class Day1 {
    public static void main(String[] args) {

        List<Integer> attendance = Arrays.asList(95, 45, 80, 30, 100);

        Predicate<Integer> eligible = a -> a >= 75;

        Consumer<Integer> printAttendance = a ->
                System.out.println("Eligible Attendance: " + a + "%");

        System.out.println("Eligible Employees Attendance Report:");

        attendance.forEach(a -> {
            if (eligible.test(a)) {
                printAttendance.accept(a);
            }
        });
    }
}