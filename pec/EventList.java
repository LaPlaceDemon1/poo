package pec;

import java.util.PriorityQueue;

public class EventList {
    // the priority queue
    private final PriorityQueue<IEvent> events;

    /**
     * Creates a new EventList object.
     * The list is a priority queue, so the events are polled in order of their
     * time.
     */
    public EventList() {
        events = new PriorityQueue<IEvent>(IEvent::compareTo);
    }

    // add an event to the list
    /**
     * Adds an event to the list.
     *
     * @param _event
     */
    public void add(IEvent _event) {
        events.add(_event);
    }

    /**
     * Returns the next event in the list.
     *
     * @return
     */
    public IEvent next() {
        return events.poll();
    }

    /**
     * Returns the size of the list.
     *
     * @return
     */
    public int size() {
        return events.size();
    }

    /**
     * Clears the list of events.
     */
    public void clear() {
        events.clear();
    }

    /**
     * Removes the first event in the list.
     *
     * @return the next event to be executed
     */
    public IEvent removeFirst() {
        return events.poll();
    }
}
