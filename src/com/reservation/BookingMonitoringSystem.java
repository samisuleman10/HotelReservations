package com.reservation;
import java.util.Arrays;

public class BookingMonitoringSystem
{
    // Size of hotel max 1000
    final int rooms = 3;
    //Total number of days
    final int days = 10;
    
    public void AvailableRooms(int startDay, int endDay)
    {
        boolean isRoomAvailble;
        boolean isRoomVacant = false;
        System.out.println(Arrays.deepToString(Database.roomsDays));

        for (int room = 0; room < rooms; room++)
        {
            isRoomAvailble = true ;
            //System.out.println(startDay);
            if (Database.roomsDays [room][startDay] == 0)
            {   // now see if all days are availble
                for (int s = startDay; s <= endDay; s++)
                {
                    if(Database.roomsDays [room] [s] != 0)
                    {
                        isRoomAvailble = false;
                        break;
                    }
                }
            }
            else
                isRoomAvailble = false;

            if (isRoomAvailble)
            {
                isRoomVacant = true;
                for (int s = startDay; s <= endDay; s++)
                {
                    Database.roomsDays [room][s] = 1;
                }
                System.out.println("Room "+ room + " is Available ");
                break;
            }

        }
        if (!isRoomVacant)
            System.out.println("No room is available");

        System.out.println(Arrays.deepToString(Database.roomsDays));
    }
}
