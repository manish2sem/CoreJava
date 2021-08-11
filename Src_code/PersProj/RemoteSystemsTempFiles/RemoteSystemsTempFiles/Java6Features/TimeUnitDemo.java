package Java6Features;

import java.util.concurrent.TimeUnit;
public class TimeUnitDemo {

    public static void main(String[] args) {
        TimeUnit tu = TimeUnit.DAYS;
        StringBuilder sb = new StringBuilder();
        sb.append(tu.toDays(1) + " days = ");
        sb.append(tu.toHours(1) + " hours = ");
        sb.append(tu.toMinutes(1) + " minutes");
        System.out.println(sb);
    }
}
