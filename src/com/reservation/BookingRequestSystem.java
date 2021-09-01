package com.reservation;
import java.util.Scanner;

// Manages the input from the user
public class BookingRequestSystem
{
    private final Database database;
    private final BookingMonitoringSystem bookingMonitoringSystem;

    BookingRequestSystem(int rooms ,int days)
    {
        bookingMonitoringSystem = new BookingMonitoringSystem();
        database = new Database(rooms,days);
    }

    public void BookingRequest()
    {
        int startDay, endDay;

        Scanner scanner = new Scanner(System.in);
        // Get input from customer
        System.out.println("Please enter the booking date: (Start day, End day)");
        System.out.print("Please enter the Start day: ");
        startDay = scanner.nextInt();
        System.out.print("Please enter the End day: ");
        endDay = scanner.nextInt();
        String result = bookingMonitoringSystem.AvailableRooms(startDay, endDay, database);
        System.out.println(result);
    }

}
