/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author yukih
 */
public class EventService {

    private EventDAO eventDataAccess;
    private Event event;

    public EventService() {
        eventDataAccess = new EventDAO();
    }

    public ArrayList<Event> getAllEvents() {
        ArrayList<Event> events  = null;
        try {
            events = eventDataAccess.eventRetrieve();
        } catch (Exception e) {
            events = null;
        }
        return events;
    }

    public void addEvent(String title, String image, String writeDate, String content) {
        eventDataAccess.addEvent(title, image, writeDate, content);
    }

    public void updateEvent(int eventID, String title, String image, String writeDate, String content) {
        eventDataAccess.updateEvent(eventID, title, image, writeDate, content);
    }

    public Event getEvent(int eventID) {
        Event event = null;
        try {
            event = eventDataAccess.getEvent(eventID);
        } catch (Exception e) {
            event = null;
        }
        return event;
    }

    public void  deleteEvent(int eventID) {
        eventDataAccess.deleteEvent(eventID);
    }

}
