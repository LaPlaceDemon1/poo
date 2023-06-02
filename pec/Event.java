package pec;

public abstract class Event
{
    double time;
    
    public Event(double _time)
    {
        this.time = _time;
    }

    public double getTime()
    {
        return this.time;
    }

    public void setTime(double _time)
    {
        this.time = _time;
    }

    public void execute()
    {
        System.out.println("Executing event at time " + this.time);
    }
}