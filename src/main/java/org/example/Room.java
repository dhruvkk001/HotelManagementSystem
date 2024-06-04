package org.example;

public class Room {
    public enum RoomType { GOLD, SILVER, BRONZE }
    private RoomType type;
    private double price;
    private int daysBooked;

    public Room(RoomType type, double price, int daysBooked) {
        this.type = type;
        this.price = price;
        this.daysBooked = daysBooked;
    }

    public RoomType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
    public int getDaysBooked(){
        return daysBooked;
    }
    public double getTotalRoomCost(){
        return price * daysBooked;
    }
    //comments
    /* multiline comments*/

    @Override
    public String toString() {
        return String.format("Room Type: %-7s | Price per Day: %8.2f | Days Booked: %3d | Total Cost: %8.2f",
                type, price, daysBooked, getTotalRoomCost());
    }
}

