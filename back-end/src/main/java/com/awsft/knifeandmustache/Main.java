package com.awsft.knifeandmustache;

import java.time.DayOfWeek;
import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {

        // Payments pa1 = new Payments(100.00, false, PaymentMethods.PIX);

        // System.out.println(pa1.getStatusPayment());
        // System.out.println(pa1.getPaymentMethods());

        LocalDateTime ldt = LocalDateTime.parse("2025-09-17T14:00:00");
        DayOfWeek day = ldt.getDayOfWeek();

        System.out.println(day);

        ldt = LocalDateTime.parse("2025-09-18T14:00:00");
        day = ldt.getDayOfWeek();

        System.out.println(day);


    }
}
