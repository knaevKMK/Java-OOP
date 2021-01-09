package c07.controller;

import java.util.ArrayDeque;
import java.util.Iterator;

public class EventSet {
    //private Event[] events = new Event[100];
    private ArrayDeque<Event> events = new ArrayDeque<>();
    private Iterator<Event> current = events.iterator();
//    private int index = 0;
//    private int next = 0;

    public void add(Event e) {

        //if (index >= events.length) {
        //  return; // (In real life, throw exception)
        //  }
        // events[index++] = e;
        events.push(e);
    }

    public Event getNext() {
        return current.next();
//        boolean looped = false;
//        int start = next;
//        do {
//            next = (next + 1) % events.length;
//// See if it has looped to the beginning:
//            if (start == next) {
//                looped = true;
//            }
//// If it loops past start, the list
//// is empty:
//            if ((next == (start + 1) % events.length) && looped) {
//                return null;
//            }
//        } while (events[next] == null);
//        return events[next];
    }

    public void removeCurrent() {
        Event event = current.next();
        event = null;
    }
}
