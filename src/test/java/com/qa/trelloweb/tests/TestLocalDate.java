package com.qa.trelloweb.tests;

import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestLocalDate {

    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        System.out.println(date);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String str = date.format(formatter);
        System.out.println(str);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/dd/MM");
        String str2 = date.format(formatter2);
        System.out.println(str2);


        LocalDate parse = LocalDate.parse(str, formatter);// to compare two objects of Local date, you must parse string to LocalDate obj
        System.out.println("converted " + parse);
        Assert.assertEquals(parse, LocalDate.now(), "Assertion is wrong good");

        //below variant with date and time
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date current = new Date();
        System.out.println(dateFormat.format(current));

      /*  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));*/

        String dateAndTime = "10-May-2022 10:06:46";  // this example from interview at CheckPoint where
                                                       // i need to compare retrieved date with current date
        String dateOnly = dateAndTime.substring(0, 11);
        System.out.println(">>>>>>>>>>>>>" + dateOnly);
        Assert.assertEquals(LocalDate.now(), LocalDate.parse(dateOnly, DateTimeFormatter.ofPattern("dd-MMM-yyyy")));

    }
}
