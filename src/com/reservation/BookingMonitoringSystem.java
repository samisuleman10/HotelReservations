package com.reservation;
import java.util.Arrays;

public class BookingMonitoringSystem
{
    // Finds available rooms and decline if no room is availalbe in the hotel
    public void AvailableRooms(int startDay, int endDay)
    {
        boolean isRoomAvailable;
        boolean isRoomVacant;
        int rooms = Database.rooms;
        int days = Database.days;
        isRoomVacant = false;

        System.out.println("Previous rooms status");
        System.out.println(Arrays.deepToString(Database.roomsDays));

        for (int room = 0; room < rooms; room++)
        {
            isRoomAvailable = true ;
            if (Database.roomsDays [room][startDay] == 0)
            {   // now see if all days are available
                for (int s = startDay; s <= endDay; s++)
                {
                    if(Database.roomsDays [room] [s] != 0)
                    {
                        isRoomAvailable = false;
                        break;
                    }
                }
            }
            else
                isRoomAvailable = false;

            if (isRoomAvailable)
            {
                isRoomVacant = true;
                for (int s = startDay; s <= endDay; s++)
                {
                    Database.roomsDays [room][s] = 1;
                }
                System.out.println("Accepted: Room "+ room + " is allotted ");
                break;
            }
        }

        if (!isRoomVacant)
            System.out.println("No room is available");

        System.out.println("Current rooms status");
        System.out.println(Arrays.deepToString(Database.roomsDays));
    }
}
