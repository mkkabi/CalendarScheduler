package utils;

public class DayName {
        public static String getDayName(int weekday) {
            if(weekday == 1) {
                return "Monday";
            } else if(weekday == 2) {
                return "Tuesday";
            } else if(weekday == 3) {
                return "Wednesday";
            } else if(weekday == 4) {
                return "Thursday";
            } else if(weekday == 5) {
                return "Friday";
            } else if(weekday == 6) {
                return "Saturday";
            } else if(weekday == 7) {
                return "Sunday";
            } else {
                return "Please enter weekday number between 1-7.";
            }
        }
    }

