# Event Planner System

##  Description
The Event Planner System is a Java console application that allows users to register 
an account, browse available events in Lagos, select an event, and receive a booking 
confirmation. It also supports uploading new events through a dedicated mode — making 
it a full CRUD-based console application.

##  Features
- User registration with full input validation (name, age, email, password, phone number)
- Auto-generated unique User ID for each registered user
- Browse all available Lagos events with full details
- Ticket booking system with real-time availability tracking
- Auto-calculated total price in Naira (₦)
- Booking confirmation with a unique Booking ID
- Upload new events through Mode 2 (Create)
- Auto-generated Event ID for every new uploaded event
- Past date validation when uploading events
- Menu-driven interface with the option to return to main menu or exit after each action

## 🛠️ Technologies Used
- Java
- Object-Oriented Programming (OOP) — Encapsulation, Constructors, Getters & Setters
- `Scanner` for console input
- `ArrayList` for storing and displaying events
- `UUID` for auto-generating unique User and Booking IDs
- `LocalDate` and `LocalTime` from `java.time` for event scheduling
- `String.format()` for Naira currency formatting
- `try/catch` and `DateTimeParseException` for input error handling
- `switch` statement for mode-based navigation

## 🔁 CRUD Operations
| Operation | Where it happens |
|-----------|-----------------|
| **Create** | Mode 2 — Upload a new event |
| **Read**   | Mode 1 — Browse and view all available events |
| **Update** | Mode 1 — Available ticket count updates after every booking |
| **Delete** | Not yet implemented — planned for future release |

## ▶️ How to Run the Project
1. Clone the repository:
   git clone https://github.com/Tomisin1234/event-planner-system.git
2. Open the project in an IDE (e.g., IntelliJ or VS Code)
3. Navigate to the `Main.java` file
4. Run the program
5. Select a mode from the main menu and follow the on-screen prompts

## 📂 Project Structure
event-planner-system/
│
├── src/
│   ├── Main.java                   → Entry point, handles all input, modes and app flow
│   └── com/Planner/event/
│       ├── User.java               → Stores and manages registered user data
│       ├── Event.java              → Represents an available event with details and pricing
│       └── Booking.java            → Links a User to an Event and generates confirmation

## 📖 How to Use

### Mode 1 — Register and Book an Event
1. Enter your personal details when prompted (name, age, email, password, phone number)
2. Your unique User ID will be generated automatically after successful registration
3. Press ENTER to browse the available events
4. Choose an event by entering its number
5. Enter the number of tickets you want to purchase
6. A booking confirmation will be displayed with your Booking ID and total price in Naira
7. Choose to return to the main menu or exit

### Mode 2 — Upload a New Event
1. Enter the event name, location, date (YYYY-MM-DD), and time (HH:MM)
2. Enter the ticket price and total number of available tickets
3. A unique Event ID will be auto-generated
4. The event is immediately added to the list and visible to users in Mode 1
5. Choose to return to the main menu or exit

### Mode 3 — Exit
- Closes the application

## 🗓️ Default Pre-loaded Events
| # | Event | Location | Price Per Ticket |
|---|-------|----------|-----------------|
| 1 | Lagos Music Event | Eko Convention Centre, Victoria Island | ₦15,000.00 |
| 2 | Lagos Food Festival | Muri Okunola Park, Victoria Island | ₦8,000.00 |
| 3 | Lagos Sport Event | Teslim Balogun Stadium, Surulere | ₦5,000.00 |

## ⚠️ Notes
- This project is built to practice core Java and OOP concepts
- Input validation is enforced on all fields during registration and event upload
- Phone number must be exactly 11 digits and contain numbers only
- Age must be between 18 and 69 to register
- Events added in Mode 2 are stored in memory only — they will be lost when the program closes
- Delete functionality is not yet implemented and is planned as a future improvement

##  Future Improvements
- Delete and full edit (Update) support to complete the CRUD cycle
- File or database storage so uploaded events are saved permanently
- User login and authentication system
- GUI interface to replace the console

## 👤 Author
Tomisin1234
