/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eventmanagement;

/**
 *
 * @author PC
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EventManagement {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        while (true) {
            System.out.println("Event Management System:");
            System.out.println("1. Add Event");
            System.out.println("2. Remove Event");
            System.out.println("3. Update Event");
            System.out.println("4. List Events");
            System.out.println("5. Add Attendee");
            System.out.println("6. Remove Attendee");
            System.out.println("7. List Attendees");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter event name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter event date (dd-MM-yyyy): ");
                        String dateStr = scanner.nextLine();
                        Date date = sdf.parse(dateStr);
                        System.out.print("Enter event location: ");
                        String location = scanner.nextLine();
                        Event event = new Event(name, date, location);
                        if (eventManager.addEvent(event)) {
                            System.out.println("Event added successfully.");
                        } else {
                            System.out.println("Event with this name already exists.");
                        }
                        break;
                    case 2:
                        System.out.print("Enter event name to remove: ");
                        String removeName = scanner.nextLine();
                        if (eventManager.removeEvent(removeName)) {
                            System.out.println("Event removed successfully.");
                        } else {
                            System.out.println("Event not found.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter existing event name: ");
                        String oldName = scanner.nextLine();
                        System.out.print("Enter new event name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new event date (dd-MM-yyyy): ");
                        String newDateStr = scanner.nextLine();
                        Date newDate = sdf.parse(newDateStr);
                        System.out.print("Enter new event location: ");
                        String newLocation = scanner.nextLine();
                        if (eventManager.updateEvent(oldName, newName, newDate, newLocation)) {
                            System.out.println("Event updated successfully.");
                        } else {
                            System.out.println("Event not found or new event name already exists.");
                        }
                        break;
                    case 4:
                        System.out.println("Events:");
                        for (Event e : eventManager.listEvents()) {
                            System.out.println(e);
                        }
                        break;
                    case 5:
                        System.out.print("Enter event name: ");
                        String eventName = scanner.nextLine();
                        System.out.print("Enter attendee name: ");
                        String attendeeName = scanner.nextLine();
                        System.out.print("Enter attendee contact info: ");
                        String contactInfo = scanner.nextLine();
                        Attendee attendee = new Attendee(attendeeName, contactInfo);
                        if (eventManager.addAttendee(eventName, attendee)) {
                            System.out.println("Attendee added successfully.");
                        } else {
                            System.out.println("Event not found.");
                        }
                        break;
                    case 6:
                        System.out.print("Enter event name: ");
                        String eventRemoveName = scanner.nextLine();
                        System.out.print("Enter attendee name to remove: ");
                        String attendeeRemoveName = scanner.nextLine();
                        Attendee attendeeToRemove = new Attendee(attendeeRemoveName, "");
                        if (eventManager.removeAttendee(eventRemoveName, attendeeToRemove)) {
                            System.out.println("Attendee removed successfully.");
                        } else {
                            System.out.println("Event or attendee not found.");
                        }
                        break;
                    case 7:
                        System.out.print("Enter event name: ");
                        String listEventName = scanner.nextLine();
                        System.out.println("Attendees:");
                        for (Attendee a : eventManager.listAttendees(listEventName)) {
                            System.out.println(a);
                        }
                        break;
                    case 8:
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
