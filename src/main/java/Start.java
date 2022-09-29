import controller.DB;
import model.Schedule;

import java.util.HashSet;
import java.util.Set;

public class Start {
    public static void main(String[] args) {


        Schedule schedule = new Schedule();
        schedule.createScheduleForGroup("One");

        Set<String> set = new HashSet<>();
        set.add("One");
        set.add("Two");
        set.add("One");

        for(String s : set){
            System.out.println(s);
        }
    }
}
