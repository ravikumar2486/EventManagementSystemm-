package com.Eventt;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Event class
class Event {
    private String name;
    private String date;
    private List<String> participants;

    public Event(String name, String date) {
        this.name = name;
        this.date = date;
        this.participants = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void addParticipant(String participant) {
        participants.add(participant);
    }

    @Override
    public String toString() {
        return "Event Name: " + name + ", Date: " + date + ", Participants: " + participants.size();
    }
}

// EventManager class
class EventManager {
    private List<Event> events;

    public EventManager() {
        events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> getEvents() {
        return events;
    }

    public Event findEvent(String name) {
        for (Event event : events) {
            if (event.getName().equalsIgnoreCase(name)) {
                return event;
            }
        }
        return null;
    }
}

// Main class
public class EventManagementSystem {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Register for Event");
            System.out.println("4. View Registrations");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter event name: ");
                    String eventName = scanner.nextLine();
                    System.out.print("Enter event date: ");
                    String eventDate = scanner.nextLine();
                    eventManager.addEvent(new Event(eventName, eventDate));
                    System.out.println("Event added!");
                    break;

                case "2":
                    System.out.println("Events:");
                    for (Event event : eventManager.getEvents()) {
                        System.out.println(event);
                    }
                    break;

                case "3":
                    System.out.print("Enter event name to register: ");
                    String registerEventName = scanner.nextLine();
                    Event eventToRegister = eventManager.findEvent(registerEventName);
                    if (eventToRegister != null) {
                        System.out.print("Enter your name: ");
                        String participantName = scanner.nextLine();
                        eventToRegister.addParticipant(participantName);
                        System.out.println("Registered successfully!");
                    } else {
                        System.out.println("Event not found.");
                    }
                    break;

                case "4":
                    System.out.print("Enter event name to view registrations: ");
                    String viewEventName = scanner.nextLine();
                    Event eventToView = eventManager.findEvent(viewEventName);
                    if (eventToView != null) {
                        System.out.println("Participants: " + eventToView.getParticipants());
                    } else {
                        System.out.println("Event not found.");
                    }
                    break;

                case "5":
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (!choice.equals("5"));

        scanner.close();
    }
}