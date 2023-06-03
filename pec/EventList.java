package pec;

import java.util.PriorityQueue;

public class EventList
{
    //the priority queue
    private PriorityQueue<Event> events;

    //constructor
    public EventList()
    {
        events = new PriorityQueue<Event>();
    }

    //add an event to the list
    public void add(Event _event)
    {
        events.add(_event);
    }

    //get the next event
    public Event next()
    {
        return events.poll();
    }

    //get the size of the list
    public int size()
    {
        return events.size();
    }
}