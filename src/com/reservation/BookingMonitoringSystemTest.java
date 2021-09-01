package com.reservation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Unit tests for the booking systems
class BookingMonitoringSystemTest
{
    private int days = 365;

    @Test
    void RoomsOutsidePlanningPeriod()
    {
        Database database = new Database(1, days);
        BookingMonitoringSystem bookingMonitoringSystem = new BookingMonitoringSystem();
        assertEquals("Decline", bookingMonitoringSystem.AvailableRooms(-4,2,database));
        assertEquals("Decline", bookingMonitoringSystem.AvailableRooms(200,400,database));
    }

    @Test
    void AcceptRequests()
    {
        Database database = new Database(3, days);
        BookingMonitoringSystem bookingMonitoringSystem = new BookingMonitoringSystem();

        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(0,5,database));
        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(7,13,database));

        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(3,9,database));
        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(5,7,database));

        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(6,6,database));
        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(0,4,database));
    }
    @Test
    void DeclineRequests()
    {
        Database database = new Database(3, days);
        BookingMonitoringSystem bookingMonitoringSystem = new BookingMonitoringSystem();

        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(1,3,database));
        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(2,5,database));

        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(1,9,database));
        assertEquals("Decline", bookingMonitoringSystem.AvailableRooms(0,15,database));
    }

    @Test
    void AcceptAfterDecline()
    {
        Database database = new Database(3, days);
        BookingMonitoringSystem bookingMonitoringSystem = new BookingMonitoringSystem();

        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(1,3,database));
        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(0,15,database));

        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(1,9,database));
        assertEquals("Decline", bookingMonitoringSystem.AvailableRooms(2,5,database));

        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(4,9,database));
    }

    @Test
    void ComplexRequests()
    {
        Database database = new Database(2, days);
        BookingMonitoringSystem bookingMonitoringSystem = new BookingMonitoringSystem();

        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(1,3,database));
        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(0,4,database));

        assertEquals("Decline", bookingMonitoringSystem.AvailableRooms(2,3,database));
        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(5,5,database));

        assertEquals("Decline", bookingMonitoringSystem.AvailableRooms(4,10,database));
        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(10,10,database));

        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(6,7,database));
        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(8,10,database));

        assertEquals("Accept", bookingMonitoringSystem.AvailableRooms(8,9,database));
    }



}