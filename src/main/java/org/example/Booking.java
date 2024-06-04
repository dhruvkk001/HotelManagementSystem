package org.example;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private String name;
    private String aadharId;
    private List<Room> rooms;
    private Services services;
    private static final double GST = 1.5;

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
        double totalCost = roomCost + serviceCost;
        return totalCost + (totalCost * GST);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Booking Summary\n");
        sb.append("========================\n");
        sb.append(String.format("Name: %s\n", name));
        sb.append(String.format("Aadhar ID: %s\n", aadharId));
        sb.append("\nRooms:\n");
        sb.append("------------------------\n");
        for (Room room : rooms) {
            sb.append(room.toString()).append("\n");
        }
        sb.append("\nServices:\n");
        sb.append("------------------------\n");
        sb.append(services.toString()).append("\n");
        sb.append("------------------------\n");
        sb.append(String.format("Total Cost (including GST): %.2f\n", calculateTotalCost()));
        sb.append("========================\n");
        return sb.toString();
    }
}

