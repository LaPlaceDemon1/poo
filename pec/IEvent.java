package pec;

public interface IEvent
{
    double getTime();

    void setTime(double _time);

    void execute(EventList sim);

    int compareTo(IEvent that);
}