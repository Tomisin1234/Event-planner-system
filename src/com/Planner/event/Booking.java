package com.Planner.event;

import java.util.UUID;

public class Booking {
    private String bookingId;
    private User user;
    private Event event;
    private int numberOfTickets;
    private double totalPrice;
    private String status;

    public Booking(User user, Event event, int numberOfTickets) {
        this.bookingId = UUID.randomUUID().toString();
        this.user = user;
        this.event = event;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = event.getTicketPrice() * numberOfTickets;
        this.status = "CONFIRMED";
    }

    public String getBookingId()    { return bookingId; }
    public User getUser()           { return user; }
    public Event getEvent()         { return event; }
    public int getNumberOfTickets() { return numberOfTickets; }
    public double getTotalPrice()   { return totalPrice; }
    public String getStatus()       { return status; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "\n=== BOOKING CONFIRMATION ===" +
                "\nBooking ID : " + bookingId +
                "\nEvent      : " + event.getEventName() +
                "\nLocation   : " + event.getEventLocation() +
                "\nDate       : " + event.getEventDate() +
                "\nTime       : " + event.getEventTime() +
                "\nTickets    : " + numberOfTickets +
                "\nTotal Price: ₦" + String.format("%,.2f", totalPrice) +
                "\nStatus     : " + status +
                "\n============================";
    }
}