package com.Planner.event;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {
    private String eventId;
    private String eventName;
    private String eventLocation;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private double ticketPrice;
    private int availableTickets;

    public Event(String eventId, String eventName, String eventLocation,
                 LocalDate eventDate, LocalTime eventTime,
                 double ticketPrice, int availableTickets) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.ticketPrice = ticketPrice;
        this.availableTickets = availableTickets;
    }

    public String getEventId()          { return eventId; }
    public String getEventName()        { return eventName; }
    public String getEventLocation()    { return eventLocation; }
    public LocalDate getEventDate()     { return eventDate; }
    public LocalTime getEventTime()     { return eventTime; }
    public double getTicketPrice()      { return ticketPrice; }
    public int getAvailableTickets()    { return availableTickets; }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    @Override
    public String toString() {
        return "[" + eventId + "] " + eventName +
                " | Location: " + eventLocation +
                " | Date: " + eventDate +
                " | Time: " + eventTime +
                " | Price: ₦" + String.format("%,.2f", ticketPrice) +
                " | Tickets Left: " + availableTickets;
    }
}