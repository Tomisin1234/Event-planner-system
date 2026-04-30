import com.Planner.event.User;
import com.Planner.event.Event;
import com.Planner.event.Booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ── Pre-load the 3 default Lagos events ───────────────────
        ArrayList<Event> events = new ArrayList<>();

        events.add(new Event(
                "E001",
                "Lagos Music Event",
                "Eko Convention Centre, Victoria Island",
                LocalDate.of(2026, 5, 12),
                LocalTime.of(18, 0),
                15000.00,
                200
        ));
        events.add(new Event(
                "E002",
                "Lagos Food Festival",
                "Muri Okunola Park, Victoria Island",
                LocalDate.of(2026, 8, 2),
                LocalTime.of(11, 0),
                8000.00,
                500
        ));
        events.add(new Event(
                "E003",
                "Lagos Sport Event",
                "Teslim Balogun Stadium, Surulere",
                LocalDate.of(2026, 9, 20),
                LocalTime.of(15, 0),
                5000.00,
                1000
        ));

        // ── Main app loop ──────────────────────────────────────────
        boolean running = true;

        while (running) {

            System.out.println("\n=====================================");
            System.out.println("      WELCOME TO EVENT PLANNER       ");
            System.out.println("=====================================");
            System.out.println("  1. Register and Book an Event");
            System.out.println("  2. Upload a New Event");
            System.out.println("  3. Exit");
            System.out.println("=====================================");
            System.out.print("Select mode: ");

            int mode = 0;
            try {
                mode = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                continue;
            }

            switch (mode) {

                // ══════════════════════════════════════════════════
                // MODE 1 — Register and Book
                // ══════════════════════════════════════════════════
                case 1 -> {

                    // ── STEP 1: Collect user info ──────────────────
                    System.out.print("\nEnter your first name: ");
                    String firstname = scanner.nextLine();
                    while (firstname.isEmpty() || firstname.length() < 3 || firstname.length() > 12) {
                        System.out.println("Invalid firstname. Must be 3-12 characters.");
                        System.out.print("Enter your first name: ");
                        firstname = scanner.nextLine();
                    }

                    System.out.print("Enter your last name: ");
                    String lastname = scanner.nextLine();
                    while (lastname.isEmpty() || lastname.length() < 3 || lastname.length() > 12) {
                        System.out.println("Invalid lastname. Must be 3-12 characters.");
                        System.out.print("Enter your last name: ");
                        lastname = scanner.nextLine();
                    }

                    System.out.print("Enter your age: ");
                    int age = 0;
                    while (true) {
                        try {
                            age = Integer.parseInt(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                            System.out.print("Please enter a valid number.\nEnter your age: ");
                            continue;
                        }
                        if      (age <= 0)  { System.out.print("Age can't be zero or negative.\nEnter your age: "); }
                        else if (age <= 13) { System.out.print("You are too young.\nEnter your age: "); }
                        else if (age < 18)  { System.out.print("Must be 18 and above.\nEnter your age: "); }
                        else if (age >= 70) { System.out.print("Sorry, you are too old.\nEnter your age: "); }
                        else                { System.out.println("Age accepted!"); break; }
                    }

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    while (email.isEmpty() || !email.contains("@")) {
                        System.out.println("Invalid email.");
                        System.out.print("Enter email: ");
                        email = scanner.nextLine();
                    }

                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    while (password.length() < 6) {
                        System.out.println("Password must be at least 6 characters.");
                        System.out.print("Enter password: ");
                        password = scanner.nextLine();
                    }

                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    while (phoneNumber.isEmpty() || phoneNumber.length() != 11 || !phoneNumber.matches("[0-9]+")) {
                        System.out.println("Phone number must be exactly 11 digits.");
                        System.out.print("Enter phone number: ");
                        phoneNumber = scanner.nextLine();
                    }

                    // ── STEP 2: Build User object ──────────────────
                    User user = new User();
                    user.setFirstname(firstname);
                    user.setLastname(lastname);
                    user.setAge(age);
                    user.setEmail(email);
                    user.setPassword(password);
                    user.setPhoneNumber(phoneNumber);

                    System.out.println("\n========================================");
                    System.out.println("  Registration Successful!");
                    System.out.println("  Welcome, " + user.getFirstname() + " " + user.getLastname() + "!");
                    System.out.println("  Your ID: " + user.getUserId());
                    System.out.println("========================================");
                    System.out.println("\nPress ENTER to view available events...");
                    scanner.nextLine();

                    // ── STEP 3: Display events ─────────────────────
                    if (events.isEmpty()) {
                        System.out.println("No events available at the moment. Check back later!");
                        break;
                    }

                    System.out.println("\n========================================");
                    System.out.println("         AVAILABLE EVENTS               ");
                    System.out.println("========================================");
                    for (int i = 0; i < events.size(); i++) {
                        System.out.println("\n  " + (i + 1) + ". " + events.get(i).getEventName());
                        System.out.println("     Location : " + events.get(i).getEventLocation());
                        System.out.println("     Date     : " + events.get(i).getEventDate());
                        System.out.println("     Time     : " + events.get(i).getEventTime());
                        System.out.println("     Price    : ₦" + String.format("%,.2f", events.get(i).getTicketPrice()));
                        System.out.println("     Tickets  : " + events.get(i).getAvailableTickets() + " available");
                    }
                    System.out.println("\n========================================");

                    // ── STEP 4: Pick event ─────────────────────────
                    System.out.print("\nChoose an event (1-" + events.size() + "): ");
                    int choice = 0;
                    while (true) {
                        try {
                            choice = Integer.parseInt(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                            System.out.print("Please enter a valid number: ");
                            continue;
                        }
                        if (choice >= 1 && choice <= events.size()) break;
                        System.out.print("Invalid choice. Try again (1-" + events.size() + "): ");
                    }

                    Event selectedEvent = events.get(choice - 1);

                    // ── STEP 5: Pick tickets ───────────────────────
                    System.out.print("How many tickets? ");
                    int tickets = 0;
                    while (true) {
                        try {
                            tickets = Integer.parseInt(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                            System.out.print("Please enter a valid number: ");
                            continue;
                        }
                        if (tickets <= 0) {
                            System.out.print("Must be at least 1 ticket: ");
                        } else if (tickets > selectedEvent.getAvailableTickets()) {
                            System.out.println("Only " + selectedEvent.getAvailableTickets() + " tickets left.");
                            System.out.print("How many tickets? ");
                        } else {
                            break;
                        }
                    }

                    // ── STEP 6: Create booking and show confirmation
                    Booking booking = new Booking(user, selectedEvent, tickets);
                    selectedEvent.setAvailableTickets(selectedEvent.getAvailableTickets() - tickets);
                    System.out.println(booking);

                    // ── STEP 7: Ask to return to main menu ────────
                    System.out.print("\nWould you like to go back to the main menu? (yes / no): ");
                    String returnChoice = scanner.nextLine().trim().toLowerCase();

                    while (!returnChoice.equals("yes") && !returnChoice.equals("no")) {
                        System.out.print("Please type yes or no: ");
                        returnChoice = scanner.nextLine().trim().toLowerCase();
                    }

                    if (returnChoice.equals("no")) {
                        System.out.println("\nThank you for using Event Planner. Goodbye!");
                        running = false; // stops the main loop and exits
                    }
                    // if "yes" — loop naturally cycles back to menu
                }

                // ══════════════════════════════════════════════════
                // MODE 2 — Upload a New Event
                // ══════════════════════════════════════════════════
                case 2 -> {

                    System.out.println("\n========================================");
                    System.out.println("          ADD A NEW EVENT               ");
                    System.out.println("========================================");

                    // ── Event Name ─────────────────────────────────
                    System.out.print("Enter event name: ");
                    String eventName = scanner.nextLine();
                    while (eventName.isEmpty() || eventName.length() < 3) {
                        System.out.println("Event name must be at least 3 characters.");
                        System.out.print("Enter event name: ");
                        eventName = scanner.nextLine();
                    }

                    // ── Event Location ─────────────────────────────
                    System.out.print("Enter event location: ");
                    String eventLocation = scanner.nextLine();
                    while (eventLocation.isEmpty()) {
                        System.out.println("Location cannot be empty.");
                        System.out.print("Enter event location: ");
                        eventLocation = scanner.nextLine();
                    }

                    // ── Event Date ─────────────────────────────────
                    LocalDate eventDate = null;
                    while (eventDate == null) {
                        System.out.print("Enter event date (YYYY-MM-DD): ");
                        String dateInput = scanner.nextLine().trim();
                        try {
                            eventDate = LocalDate.parse(dateInput);
                            if (eventDate.isBefore(LocalDate.now())) {
                                System.out.println("Date cannot be in the past.");
                                eventDate = null;
                            }
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid format. Use YYYY-MM-DD (e.g. 2026-12-01)");
                        }
                    }

                    // ── Event Time ─────────────────────────────────
                    LocalTime eventTime = null;
                    while (eventTime == null) {
                        System.out.print("Enter event time (HH:MM): ");
                        String timeInput = scanner.nextLine().trim();
                        try {
                            eventTime = LocalTime.parse(timeInput);
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid format. Use HH:MM (e.g. 18:00)");
                        }
                    }

                    // ── Ticket Price ───────────────────────────────
                    double ticketPrice = 0;
                    while (true) {
                        System.out.print("Enter ticket price (₦): ");
                        try {
                            ticketPrice = Double.parseDouble(scanner.nextLine().trim());
                            if (ticketPrice <= 0) {
                                System.out.println("Price must be greater than zero.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid price. Enter a number (e.g. 5000)");
                        }
                    }

                    // ── Available Tickets ──────────────────────────
                    int availableTickets = 0;
                    while (true) {
                        System.out.print("Enter total number of tickets available: ");
                        try {
                            availableTickets = Integer.parseInt(scanner.nextLine().trim());
                            if (availableTickets <= 0) {
                                System.out.println("Must have at least 1 ticket.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number. Enter a whole number (e.g. 200)");
                        }
                    }

                    // ── Auto generate Event ID and add event ───────
                    String newEventId = "E" + String.format("%03d", events.size() + 1);
                    Event newEvent = new Event(newEventId, eventName, eventLocation, eventDate, eventTime, ticketPrice, availableTickets);
                    events.add(newEvent);

                    System.out.println("\n========================================");
                    System.out.println("  Event Added Successfully!");
                    System.out.println("  Event ID : " + newEventId);
                    System.out.println("  Name     : " + eventName);
                    System.out.println("  Location : " + eventLocation);
                    System.out.println("  Date     : " + eventDate);
                    System.out.println("  Time     : " + eventTime);
                    System.out.println("  Price    : ₦" + String.format("%,.2f", ticketPrice));
                    System.out.println("  Tickets  : " + availableTickets);
                    System.out.println("========================================");

                    // ── Ask to return to main menu ─────────────────
                    System.out.print("\nWould you like to go back to the main menu? (yes / no): ");
                    String returnChoice = scanner.nextLine().trim().toLowerCase();

                    while (!returnChoice.equals("yes") && !returnChoice.equals("no")) {
                        System.out.print("Please type yes or no: ");
                        returnChoice = scanner.nextLine().trim().toLowerCase();
                    }

                    if (returnChoice.equals("no")) {
                        System.out.println("\nThank you for using Event Planner. Goodbye!");
                        running = false;
                    }
                }

                // ══════════════════════════════════════════════════
                // MODE 3 — Exit
                // ══════════════════════════════════════════════════
                case 3 -> {
                    System.out.println("\nThank you for using Event Planner. Goodbye!");
                    running = false;
                }

                default -> System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }

        scanner.close();
    }
}