package pec;

public interface IEvent
{
    /**
     * @return the time of the event
     */
    double getTime();
    /**
     * @param _time the time to be set on the event
     */
    void setTime(double _time);
    /**
     * call of the execute method of the event subclass
     * @param sim the eventlist
     * */

    void execute(EventList sim);
    /**
     * @param that the event to be compared to
     * @return 1 if this event is later than that event, -1 if this event is earlier than that event, 0 if they are equal
     */

    int compareTo(IEvent that);
}