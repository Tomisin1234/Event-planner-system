# Event Planner System

##  Description
The Event Planner System is a Java console application that allows users to register 
an account, browse available events in Lagos, select an event, and receive a booking 
confirmation — all through a simple and structured console interface.

##  Features
- User registration with full input validation (name, age, email, password, phone number)
- Auto-generated unique User ID for each registered user
- Browse 3 pre-loaded Lagos events with full details
- Ticket booking system with real-time availability tracking
- Auto-calculated total price in Naira (₦)
- Booking confirmation with a unique Booking ID

##  Technologies Used
- Java
- Object-Oriented Programming (OOP) — Encapsulation, Constructors, Getters & Setters
- `Scanner` for console input
- `ArrayList` for storing and displaying events
- `UUID` for auto-generating unique IDs
- `LocalDate` and `LocalTime` from `java.time` for event scheduling
- `String.format()` for Naira currency formatting

##  How to Run the Project
1. Clone the repository:
   git clone https://github.com/Tomisin1234/event-planner-system.git
2. Open the project in an IDE (e.g., IntelliJ or VS Code)
3. Navigate to the `Main.java` file
4. Run the program
5. Follow the prompts in the console to register and book an event

##  Project Structure
event-planner-system/
│
├── src/
│   ├── Main.java               → Entry point, handles all user input and app flow
│   └── com/Planner/event/
│       ├── User.java           → Stores and manages registered user data
│       ├── Event.java          → Represents an available event with details and pricing
│       └── Booking.java        → Links a User to an Event and generates confirmation

##  How to Use
1. Enter your personal details when prompted (name, age, email, password, phone number)
2. Your unique User ID will be generated automatically after successful registration
3. Press ENTER to browse the available Lagos events
4. Choose an event by entering its number (1, 2, or 3)
5. Enter the number of tickets you want to purchase
6. A booking confirmation will be displayed with your Booking ID and total price in Naira

##  Available Events
| # | Event | Location | Price Per Ticket |
|---|-------|----------|-----------------|
| 1 | Lagos Music Event | Eko Convention Centre, Victoria Island | ₦15,000.00 |
| 2 | Lagos Food Festival | Muri Okunola Park, Victoria Island | ₦8,000.00 |
| 3 | Lagos Sport Event | Teslim Balogun Stadium, Surulere | ₦5,000.00 |

## ⚠️ Notes
- This is a beginner-level project built to practice core Java and OOP concepts
- Input validation is enforced on all fields during registration
- Phone number must be exactly 11 digits and contain numbers only
- Age must be between 18 and 69 to register
- Future improvements may include GUI, database integration, and user login

## 👤 Author
Tomisin1234



