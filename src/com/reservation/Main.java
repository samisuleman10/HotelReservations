package com.reservation;

public class Main
{
    //Assumption rooms range is 0-999 and days range is 0-364
    //Assumption inputs are only numbers (no strings or special characters)

    private static final int rooms = 1000;
    private static  final int days = 365;

    public static void main(String[] args)
    {
        BookingRequestSystem bookingSystem = new BookingRequestSystem(rooms,days);

        while (true)
        {
            bookingSystem.BookingRequest();
        }

    }
}
