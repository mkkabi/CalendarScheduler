package utils;

import controller.Controller;
import controller.FileController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Const {

    public static final DateFormat yearWeekFormatter = new SimpleDateFormat("YYYY ww");
    public static DateFormat dayFormatter = new SimpleDateFormat("EEEE");
    public static final DateFormat numericalDateTimeFormat = new SimpleDateFormat("yyyy,MM,dd HH:mm");
    public static final DateFormat numericalDateFormat = new SimpleDateFormat("yyyy,MM,dd");
    public static final DateFormat timeFormat = new SimpleDateFormat("HH:mm");
    public static final Controller contoller = FileController.getInstance();
}
