/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventmanagement;

/**
 *
 * @author PC
 */


import java.util.HashSet;
import java.util.Date;

public class Event {
    private String name;
    private Date date;
    private String location;
    private HashSet<Attendee> attendees;

    public Event(String name, Date date, String location) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.attendees = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public HashSet<Attendee> getAttendees() {
        return attendees;
    }

    public void addAttendee(Attendee attendee) {
        attendees.add(attendee);
    }

    public void removeAttendee(Attendee attendee) {
        attendees.remove(attendee);
    }

    public void updateDetails(String name, Date date, String location) {
        this.name = name;
        this.date = date;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", attendees=" + attendees.size() +
                '}';
    }
}
