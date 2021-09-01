package com.reservation;

// Stores the information for room reservations
public  class Database
{
    public int [][] hotelReservations;

    Database(int roomQuantity, int totalDays)
    {
        hotelReservations = new int [roomQuantity] [totalDays];
    }


}
