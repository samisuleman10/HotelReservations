package com.reservation;

//Checks for the valid room requests
public class BookingMonitoringSystem
{
    // Accepts or decline the availability of rooms in the hotel
    public String AvailableRooms(int startDay, int endDay, Database database)
    {
        boolean isRoomAvailable;
        //boolean isRoomVacant;
        int rooms = database.hotelReservations.length;
        int days = database.hotelReservations[0].length;

        //isRoomVacant = false;

        //Checks for the limits of days
        if ((startDay >= 0 && startDay < days) && (endDay >= 0 && endDay < days) && startDay <= endDay)
        {
            // Iterates through the 2D array and finds the room available for complete duration.
            for (int room = 0; room < rooms; room++)
            {
                isRoomAvailable = true ;

                // Checks the availability on the particular date
                if (database.hotelReservations[room][startDay] == 0)
                {
                    // Checks for the availability for the complete duration
                    for (int day = startDay; day <= endDay; day++)
                    {
                        if(database.hotelReservations[room] [day] != 0)
                        {
                            isRoomAvailable = false;
                            break;
                        }
                    }
                }
                else
                    isRoomAvailable = false;

                // Change the status of the room to occupied for the requested duration
                if (isRoomAvailable)
                {
                    //isRoomVacant = true;
                    for (int day = startDay; day <= endDay; day++)
                    {
                        database.hotelReservations[room][day] = 1;
                    }
                    //System.out.println("Accepted: Room "+ room + " is allotted ");
                    //System.out.println(Arrays.deepToString(database.roomsDays));
                    return "Accept";
                }
            }

            // No room was available for the requested duration
            //System.out.println("No room is available");
            //System.out.println(Arrays.deepToString(database.roomsDays));
            return "Decline";
        }
        else
        {
            //System.out.println("Out of range");
            //System.out.println(Arrays.deepToString(database.roomsDays));
            return "Decline";
        }
    }
}
