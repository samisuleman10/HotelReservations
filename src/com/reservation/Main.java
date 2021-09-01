package com.reservation;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        BookingRequestSystem bookingSystem = new BookingRequestSystem();

        while (true)
        {
            bookingSystem.BookingRequest();
        }

    }
}
