import com.Planner.event.User;
import com.Planner.event.Event;
import com.Planner.event.Booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ── STEP 1: Collect user info ──────────────────────────────
        System.out.print("Enter your first name: ");
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
            age = scanner.nextInt();
            scanner.nextLine();
            if (age <= 0)       { System.out.print("Age can't be zero or negative.\nEnter your age: "); }
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


        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setAge(age);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);


        System.out.println("========================================\n");
        System.out.println("  Registration Successful!");
        System.out.println("  Welcome, " + user.getFirstname() + " " + user.getLastname() + "!");
        System.out.println("  Your ID: " + user.getUserId());
        System.out.println("========================================");
        System.out.println("\nPress ENTER to view available events...");
        scanner.nextLine(); // ← waits for user to press Enter before continuing


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
                LocalDate.of(2025, 9, 20),
                LocalTime.of(15, 0),
                5000.00,
                1000
        ));


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


        System.out.print("\nChoose an event (1-" + events.size() + "): ");
        int choice = 0;
        while (true) {
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice >= 1 && choice <= events.size()) break;
            System.out.print("Invalid choice. Try again (1-" + events.size() + "): ");
        }

        Event selectedEvent = events.get(choice - 1);

        System.out.print("How many tickets? ");
        int tickets = scanner.nextInt();
        scanner.nextLine();
        while (tickets <= 0 || tickets > selectedEvent.getAvailableTickets()) {
            System.out.println("Invalid. Available tickets: " + selectedEvent.getAvailableTickets());
            System.out.print("How many tickets? ");
            tickets = scanner.nextInt();
            scanner.nextLine();
        }


        Booking booking = new Booking(user, selectedEvent, tickets);
        selectedEvent.setAvailableTickets(selectedEvent.getAvailableTickets() - tickets);

        System.out.println(booking);

        scanner.close();
    }
}