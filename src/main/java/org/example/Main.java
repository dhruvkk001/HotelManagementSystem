package org.example;

import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name:");
        String name = scanner.nextLine();

        System.out.println("Enter your Aadhar ID:");
        String aadharId = scanner.nextLine();

        System.out.println("Do you want laundry service? (yes/no):");
        boolean laundry = scanner.nextLine().equalsIgnoreCase("yes");
        int laundryUses = 0;
        if (laundry) {
            System.out.println("How many times do you want to use the laundry service?");
            laundryUses = scanner.nextInt();
            scanner.nextLine(); // consume the newline
        }

        System.out.println("Do you want spa service? (yes/no):");
        boolean spa = scanner.nextLine().equalsIgnoreCase("yes");
        int spaUses = 0;
        if (spa) {
            System.out.println("How many times do you want to use the spa service?");
            spaUses = scanner.nextInt();
            scanner.nextLine(); // consume the newline
        }

        Services services = new Services(laundry, spa, laundryUses, spaUses);
        Booking booking = new Booking(name, aadharId, services);

        while (true) {
            System.out.println("Enter room type to book (GOLD, SILVER, BRONZE) or 'done' to finish:");
            String roomType = scanner.nextLine();

            if (roomType.equalsIgnoreCase("done")) {
                break;
            }

            Room.RoomType type;
            try {
                type = Room.RoomType.valueOf(roomType.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid room type. Try again.");
                continue;
            }

            System.out.println("Enter the number of days to book the room:");
            int daysBooked = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            double pricePerDay;
            switch (type) {
                case GOLD:
                    pricePerDay = 200.0;
                    break;
                case SILVER:
                    pricePerDay = 150.0;
                    break;
                case BRONZE:
                    pricePerDay = 100.0;
                    break;
                default:
                    pricePerDay = 0.0;
            }

            Room room = new Room(type, pricePerDay, daysBooked);
            booking.addRoom(room);
        }

        System.out.println(booking);
    }
}
