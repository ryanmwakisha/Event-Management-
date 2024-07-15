/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventmanagement;

/**
 *
 * @author PC
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;

public class EventManager {
    private ArrayList<Event> events;
    private HashMap<String, Event> eventMap;

    public EventManager() {
        events = new ArrayList<>();
        eventMap = new HashMap<>();
    }

    public boolean addEvent(Event event) {
        if (eventMap.containsKey(event.getName())) {
            return false;
        }
        events.add(event);
        eventMap.put(event.getName(), event);
        return true;
    }

    public boolean removeEvent(String eventName) {
        Event event = eventMap.remove(eventName);
        if (event != null) {
            events.remove(event);
            return true;
        }
        return false;
    }

    public boolean updateEvent(String oldName, String newName, Date newDate, String newLocation) {
        Event event = eventMap.get(oldName);
        if (event != null) {
            if (!oldName.equals(newName) && eventMap.containsKey(newName)) {
                return false;
            }
            eventMap.remove(oldName);
            event.updateDetails(newName, newDate, newLocation);
            eventMap.put(newName, event);
            return true;
        }
        return false;
    }

    public List<Event> listEvents() {
        return events;
    }

    public boolean addAttendee(String eventName, Attendee attendee) {
        Event event = eventMap.get(eventName);
        if (event != null) {
            return event.getAttendees().add(attendee);
        }
        return false;
    }

    public boolean removeAttendee(String eventName, Attendee attendee) {
        Event event = eventMap.get(eventName);
        if (event != null) {
            return event.getAttendees().remove(attendee);
        }
        return false;
    }

    public List<Attendee> listAttendees(String eventName) {
        Event event = eventMap.get(eventName);
        if (event != null) {
            return new ArrayList<>(event.getAttendees());
        }
        return new ArrayList<>();
    }
}
