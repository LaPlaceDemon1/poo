package pec;

import java.util.PriorityQueue;

public class EventList
{
    //the priority queue
    private PriorityQueue<IEvent> events;

    //constructor
    public EventList()
    {
        events = new PriorityQueue<IEvent>();
    }

    //add an event to the list
    public void add(IEvent _event)
    {
        events.add(_event);
    }

    //get the next event
    public IEvent next()
    {
        return events.poll();
    }

    //get the size of the list
    public int size()
    {
        return events.size();
    }


}