package com.reservation;

import java.util.Scanner;

public class BookingRequestSystem
{
    private int startDay;
    private int endDay;
    private BookingMonitoringSystem bookingMonitoringSystem;

    BookingRequestSystem()
    {
        bookingMonitoringSystem = new BookingMonitoringSystem();
    }

    public void BookingRequest()
    {

        Scanner scanner = new Scanner(System.in);
        // Get input from customer
        System.out.println("Please enter the booking date: (Start day, End day)");
        System.out.print("Please enter the Start day: ");
        this.startDay = scanner.nextInt();
        System.out.print("Please enter the End day: ");
        this.endDay = scanner.nextInt();

        //Check availbility of room
        bookingMonitoringSystem.AvailableRooms(startDay,endDay);
    }

}
