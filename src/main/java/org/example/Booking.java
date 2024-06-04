package org.example;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private String name;
    private String aadharId;
    private List<Room> rooms;
    private Services services;
    private static final double GST =1.5;

    public Booking(String name, String aadharId, Services services) {
        this.name = name;
        this.aadharId = aadharId;
        this.rooms = new ArrayList<>();
        this.services = services;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public String getName() {
        return name;
    }

    public String getAadharId() {
        return aadharId;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Services getServices() {
        return services;
    }

    public double calculateTotalCost() {
        double roomCost = rooms.stream().mapToDouble(Room::getPrice).sum();
        double serviceCost = services.getLaundryCost() + services.getSpaCost();
        double  totalCost = roomCost + serviceCost;
        return totalCost +(totalCost * GST);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "name='" + name + '\'' +
                ", aadharId='" + aadharId + '\'' +
                ", rooms=" + rooms +
                ", services=" + services +
                ", totalCostWithGST=" + calculateTotalCost() +
                '}';
    }
}

