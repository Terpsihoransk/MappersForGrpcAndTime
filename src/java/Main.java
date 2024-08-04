import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        String startTimeString = "09:00";
        int timeZone = 3;

        LocalTime startTime = LocalTime.parse(startTimeString, DateTimeFormatter.ofPattern("HH:mm")).minusHours(timeZone);

        System.out.println(startTime);

    }
}